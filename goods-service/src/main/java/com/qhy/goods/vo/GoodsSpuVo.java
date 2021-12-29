package com.qhy.goods.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author qhy
 * @date 2021/12/29 15:19
 */
@Data
@Schema(description = "商品详情")
public class GoodsSpuVo implements Serializable {

    @Schema(description = "商品SPUID")
    private Long id;

    @Schema(description = "商品编号，唯一")
    private String spuNo;

    @Schema(description = "商品名称")
    private String goodsName;

    @Schema(description = "最低售价")
    private BigDecimal lowPrice;

    @Schema(description = "分类ID")
    private Long categoryId;

    @Schema(description = "分类名称")
    private String categoryName;

    @Schema(description = "品牌ID")
    private Long brandId;

    @Schema(description = "品牌名称")
    private String brandName;
}
