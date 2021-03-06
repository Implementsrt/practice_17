package cn.qhy.goods.web;


import cn.qhy.common.core.BaseController;
import cn.qhy.goods.dto.GoodsSpuAddDto;
import cn.qhy.goods.dto.GoodsSpuQuery;
import cn.qhy.goods.service.IGoodsSpuService;
import cn.qhy.goods.vo.GoodsSpuVo;
import com.github.pagehelper.PageInfo;
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
// @CrossOrigin
@RestController
@RequestMapping("/goods-spu")
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
