package cn.qhy.goodsfeign.config;

import cn.qhy.goodsfeign.dto.CustomException;
import cn.qhy.goodsfeign.dto.R;
import com.alibaba.fastjson.JSON;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 返回状态非200时处理
 * fixme 看一下加入断路器之后还需不需要
 *
 * @author qhy
 * @date 2022/1/5 10:11
 */
@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String errorBody = Optional.ofNullable(response.body()).map(Object::toString).orElse("");
        log.error("商品服务异常：{}, {}, {}", s, response.status(), errorBody);
        R<?> resultDto = JSON.parseObject(errorBody, R.class);
        throw CustomException.msg("商品服务异常：" + resultDto.getMsg());
    }
}
