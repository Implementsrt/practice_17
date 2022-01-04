package cn.qhy.goods.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 新增商品SPU参数
 *
 * @author qhy
 * @date 2021/12/29 15:21
 */
@Data
@Schema(name = "新增商品SPU参数")
public class GoodsSpuAddDto {

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    @NotBlank(message = "请输入商品名称")
    @Size(max = 50, message = "商品名称不能超过50个字符")
    private String goodsName;

    /**
     * 品牌ID
     */
    @Schema(description = "品牌ID")
    @NotNull(message = "请选择商品品牌")
    private Long brandId;

    /**
     * 分类ID
     */
    @Schema(description = "分类ID")
    @NotNull(message = "请选择商品分类")
    private Long categoryId;

    /**
     * 商品最低售价
     */
    @Schema(description = "商品最低售价")
    @NotNull(message = "请输入商品最低售价")
    @Max(value = 9999999, message = "商品最低售价不能超过9999999")
    @Min(value = 0, message = "商品最低售价不能低于0")
    private BigDecimal lowPrice;

}
