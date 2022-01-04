package cn.qhy.common.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.qhy.common.annotation.NotResponseWrap;
import cn.qhy.common.core.CustomException;
import cn.qhy.common.core.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

/**
 * 统一包装返回结果
 *
 * @author qhy
 * @date 2021/12/29 16:04
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.qhy.goods.web")
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    @Resource
    private ObjectMapper objectMapper;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.hasMethodAnnotation(NotResponseWrap.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        try {
            // fixme 这里的错误地址
            if ((contextPath + "/error").equals(((ServletServerHttpRequest) request).getServletRequest().getRequestURI())) {
                return o;
            }

            if (null == o || void.class.equals(returnType.getGenericParameterType())) {
                return R.ok();
            }

            if (R.class.equals(o.getClass())) {
                return o;
            }

            // 这里统一包装
            if (!String.class.equals(returnType.getGenericParameterType())) {
                return R.ok(o);
            }

            // String类型不能直接包装，所以需要进行些特别的处理
            // 注意，如果接口声明为String返回，那么应该在@RequestMapping中声明produces为application/json，否则按text/plan返回
            try {
                return objectMapper.writeValueAsString(R.ok(o));
            } catch (JsonProcessingException e) {
                log.error("统一包装返回json数据解析异常{}", e.getMessage());
                throw CustomException.msg("数据接口异常，请联系管理员");
            }
        } catch (Exception e) {
            log.warn("统一包装返回json数据失败: {}", e);
            return o;
        }

    }
}
