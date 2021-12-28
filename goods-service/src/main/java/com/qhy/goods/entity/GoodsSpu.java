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
 * SPU表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_spu")
@ApiModel(value = "GoodsSpu对象", description = "SPU表")
public class GoodsSpu extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号，唯一")
    private String spuNo;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("最低售价")
    private BigDecimal lowPrice;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;


}
