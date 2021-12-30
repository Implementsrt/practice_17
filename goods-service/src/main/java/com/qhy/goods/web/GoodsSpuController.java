package com.qhy.goods.web;


import com.github.pagehelper.PageInfo;
import com.qhy.goods.common.BaseController;
import com.qhy.goods.dto.GoodsSpuAddDto;
import com.qhy.goods.dto.GoodsSpuQuery;
import com.qhy.goods.service.IGoodsSpuService;
import com.qhy.goods.vo.GoodsSpuVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * SPU表 前端控制器
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/goods/goods-spu")
@Tag(name = "商品SPU管理接口")
public class GoodsSpuController extends BaseController<IGoodsSpuService> {

    @Operation(summary = "添加商品SPU")
    @PostMapping("/create")
    public Long createGoodsSpu(@Validated @RequestBody GoodsSpuAddDto formData) {
        return baseService.create(formData);
    }

    @Operation(summary = "商品详情", parameters = @Parameter(name = "id", description = "商品SPUID"))
    @GetMapping("/{id}")
    public GoodsSpuVo getDetail(@PathVariable Long id) {
        return baseService.getDetail(id);
    }

    @Operation(summary = "商品列表")
    @PostMapping("/list")
    public PageInfo<GoodsSpuVo> listGoodsSpu(@RequestBody GoodsSpuQuery query) {
        return baseService.listByPage(query);
    }

}
