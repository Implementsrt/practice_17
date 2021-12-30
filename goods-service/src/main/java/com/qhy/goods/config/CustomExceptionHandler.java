package com.qhy.goods.config;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.qhy.goods.common.CustomException;
import com.qhy.goods.dto.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/**
 * 对controller访问的异常做处理
 * <p/>
 * <p><b>这里有个坑，如果是使用@ControllerAdvice的话，会直接返回Spring原生404错误</b></p>
 * <pre>难道是因为我实现了ResponseBodyAdvice？</pre>
 *
 * @author qhy
 * @date 2021/12/29 16:49
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public R<?> handleError(CustomException ex, HttpServletResponse response) {
        log.warn("业务异常:{}", ex.getMessage());
        int code = null == ex.getCode() ? HttpStatus.HTTP_CONFLICT : ex.getCode();
        switch (code) {
            case HttpStatus.HTTP_UNAUTHORIZED -> {
                // 未登录异常
                response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
                return R.error(HttpStatus.HTTP_UNAUTHORIZED, ex.getMessage());
            }
            case HttpStatus.HTTP_FORBIDDEN -> {
                // 鉴权失败
                response.setStatus(HttpStatus.HTTP_FORBIDDEN);
                return R.error(HttpStatus.HTTP_FORBIDDEN, ex.getMessage());
            }
            case HttpStatus.HTTP_PRECON_FAILED -> {
                // 需要确认的异常
                response.setStatus(HttpStatus.HTTP_PRECON_FAILED);
                return R.error(code, ex.getMessage());
            }
            default -> {
                // 其他业务异常
                response.setStatus(HttpStatus.HTTP_CONFLICT);
                return R.error(HttpStatus.HTTP_CONFLICT, ex.getMessage());
            }
        }
    }


    @ExceptionHandler(SQLException.class)
    public R<?> handleError(SQLException ex, HttpServletResponse response) {
        log.error("数据库执行异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        return R.error("数据异常");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<?> handleError(HttpMessageNotReadableException ex, HttpServletResponse response) {
        log.info("JSON参数异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(response.getStatus(), "参数不合法,请检查输入项是否合理");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R<?> handleError(HttpRequestMethodNotSupportedException ex, HttpServletResponse response) {
        log.info("请求方式异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_BAD_METHOD);
        return R.error(response.getStatus(), "HTTP方式不支持");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R<?> handleError(HttpMediaTypeNotSupportedException ex, HttpServletResponse response) {
        log.info("请求类型异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_UNSUPPORTED_TYPE);
        return R.error(response.getStatus(), "请求类型不支持");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R<?> handleError(MethodArgumentTypeMismatchException ex, HttpServletResponse response) {
        log.info("参数类型异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(response.getStatus(), "参数类型错误");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public R<?> handleError(MissingServletRequestParameterException ex, HttpServletResponse response) {
        // 普通POST表单，参数缺失
        log.info("参数缺失异常:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(response.getStatus(), "参数缺失");
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> handleError(MethodArgumentNotValidException ex, HttpServletResponse response) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验失败:{}", ex.getMessage());
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(response.getStatus(), Optional.ofNullable(fieldError).map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("未知参数异常"));
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public R<?> handleError(NullPointerException ex, HttpServletResponse response) {
        log.error("空指针异常:{}", ex);
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        return R.error(response.getStatus(), "系统错误-空指针异常");
    }

    /**
     * 数据库执行异常
     */
    @ExceptionHandler(PersistenceException.class)
    public R<?> handleError(PersistenceException ex, HttpServletResponse response) {
        log.error("数据库异常:{}", ex);
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        return R.error(response.getStatus(), "系统错误-数据库异常");
    }


    /**
     * 未处理异常
     */
    @ExceptionHandler(Throwable.class)
    public R<?> handleError(Throwable ex, HttpServletResponse response) {
        log.error("未处理异常:{}", ex);
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        String message = ex.getMessage();
        if (StrUtil.length(message) < 64) {
            return R.error(message);
        }

        return R.error(Optional.ofNullable(ex.getCause()).map(Throwable::getMessage)
                .map(m -> m.substring(0, 64)).orElseGet(() -> message.substring(0, 64)));
    }
}
