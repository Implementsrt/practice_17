package com.qhy.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@ApiModel(value = "GoodsSku对象", description = "SKU表")
public class GoodsSku extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("SKU编号,唯一")
    private String skuNo;

    @ApiModelProperty("SKU名称(冗余SPU_NAME)")
    private String skuName;

    @ApiModelProperty("售价")
    private BigDecimal price;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("商铺ID,为0表示自营")
    private Long shopId;

    @ApiModelProperty("SPU_ID")
    private Long spuId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;


}
