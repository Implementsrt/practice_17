package cn.qhy.goodsfeign.web;

import cn.qhy.goodsfeign.dto.R;
import cn.qhy.goodsfeign.service.GoodsFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author qhy
 * @date 2022/1/5 9:29
 */
@RestController
@RequestMapping("/goods-spu")
public class GoodsSpuController {

    @Resource
    private GoodsFeign goodsFeign;

    @GetMapping("/{id}")
    public R<?> getDetail(@PathVariable Long id) {
        return goodsFeign.getDetail(id);
    }

    @PostMapping("/list")
    public R<?> listGoodsSpu(@RequestBody Map<String, Object> query) {
        return goodsFeign.listGoodsSpu(query);
    }

    @PostMapping("/create")
    public Long createGoodsSpu(@RequestBody Map<String, Object> formData) {
        return goodsFeign.createGoodsSpu(formData);
    }

}