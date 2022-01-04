package cn.qhy.goods.web;


import cn.qhy.common.core.BaseController;
import cn.qhy.goods.dto.GoodsBrandAddDto;
import cn.qhy.goods.service.IGoodsBrandService;
import cn.qhy.goods.vo.GoodsBrandVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/goods-brand")
@Tag(name = "商品品牌管理接口")
public class GoodsBrandController extends BaseController<IGoodsBrandService> {

    @Operation(summary = "创建品牌")
    @PutMapping("/create")
    public Long createBrand(@Validated @RequestBody GoodsBrandAddDto formData) {
        return baseService.create(formData);
    }

    @Operation(summary = "品牌列表")
    @GetMapping("/list")
    public List<GoodsBrandVo> listBrand() {
        return baseService.listBrand();
    }

}
