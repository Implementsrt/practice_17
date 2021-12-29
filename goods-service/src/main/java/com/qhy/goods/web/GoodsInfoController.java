package com.qhy.goods.web;


import com.qhy.goods.dto.R;
import com.qhy.goods.service.IGoodsInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 店铺表 前端控制器
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/goods/goods-info")
@Tag(name = "商品信息接口")
public class GoodsInfoController extends BaseController {

    @Resource
    private IGoodsInfoService goodsInfoService;

    @Operation(description = "获取商品详情", parameters = @Parameter(name = "id", description = "商品ID"))
    @GetMapping("/{id}")
    public R<?> getById(@PathVariable Long id) {
        return R.ok(goodsInfoService.getById(id));
    }

}
