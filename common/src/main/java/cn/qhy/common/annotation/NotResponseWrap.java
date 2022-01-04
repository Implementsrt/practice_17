package cn.qhy.common.annotation;

import cn.qhy.common.aspect.ResponseControllerAdvice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明不需要进行包装的接口
 * <p>那么也不会进行加密返回</p>
 *
 * @author qhy
 * @see ResponseControllerAdvice
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NotResponseWrap {
}
