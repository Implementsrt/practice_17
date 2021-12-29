package com.qhy.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * SKU表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_sku")
@Schema(name = "GoodsSku对象", description = "SKU表")
public class GoodsSku extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "SKU编号,唯一")
    private String skuNo;

    @Schema(description = "SKU名称(冗余SPU_NAME)")
    private String skuName;

    @Schema(description = "售价")
    private BigDecimal price;

    @Schema(description = "库存")
    private Integer stock;

    @Schema(description = "商铺ID,为0表示自营")
    private Long shopId;

    @Schema(description = "SPU_ID")
    private Long spuId;

    

    


}
