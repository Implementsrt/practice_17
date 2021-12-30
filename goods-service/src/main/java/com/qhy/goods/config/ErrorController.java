package com.qhy.goods.config;

import cn.hutool.core.bean.BeanUtil;
import com.qhy.goods.common.CustomException;
import com.qhy.goods.dto.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author qhy
 * @date 2021/12/30 11:00
 */
@Slf4j
@RestController
public class ErrorController extends BasicErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

        // 输出一下重定向之前的路径
        Object requestUri = request.getAttribute("javax.servlet.error.request_uri");
        log.error("error request uri [{}]", requestUri);

        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        if (exception instanceof CustomException customException) {
            // 专心处理自定义异常
            R<?> ret = R.error(customException.getCode(), customException.getMessage());
            HttpStatus httpStatus = HttpStatus.valueOf(customException.getCode());
            return new ResponseEntity<>(BeanUtil.beanToMap(ret), httpStatus);
        }

        return super.error(request);

    }
}
