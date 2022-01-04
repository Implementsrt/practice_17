package cn.qhy.goods.web;


import cn.qhy.common.core.BaseController;
import cn.qhy.goods.dto.GoodsCategoryAddDto;
import cn.qhy.goods.service.IGoodsCategoryService;
import cn.qhy.goods.vo.GoodsCategoryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/goods/goods-category")
@Tag(name = "商品分类管理接口")
public class GoodsCategoryController extends BaseController<IGoodsCategoryService> {

    @Operation(summary = "创建分类")
    @PutMapping("/create")
    public Long createCategory(@Validated @RequestBody GoodsCategoryAddDto formData) {
        return baseService.create(formData);
    }

    @Operation(summary = "分类列表")
    @GetMapping("/list")
    public List<GoodsCategoryVo> listCategory() {
        return baseService.listCategory();
    }


}
