package cn.qhy.goodsfeign.service;

import cn.qhy.goodsfeign.dto.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <pre>这里比较奇怪，只能用name，不能用value，否则刚启动的时候会有一段时间503</pre>
 *
 * @author qhy
 * @date 2022/1/4 17:51
 */
@FeignClient(name = "goods-service", path = "/goods/goods-spu")
public interface GoodsFeign {

    /**
     * 商品SPU详情
     *
     * @param id 商品SPU ID
     * @return 商品SPU详情
     */
    @GetMapping("/{id}")
    R<?> getDetail(@PathVariable Long id);

    /**
     * 商品SPU列表
     *
     * @param query 筛选条件
     * @return 商品SPU列表
     */
    @PostMapping("/list")
    R<?> listGoodsSpu(@RequestBody Map<String, Object> query);

    /**
     * 添加商品SPU
     *
     * @param formData 商品信息
     * @return 商品ID
     */
    @PostMapping("/create")
    Long createGoodsSpu(@RequestBody Map<String, Object> formData);

}
