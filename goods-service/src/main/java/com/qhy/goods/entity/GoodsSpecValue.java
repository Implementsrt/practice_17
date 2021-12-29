package com.qhy.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qhy.goods.common.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 规格值表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_spec_value")
@Schema(name = "GoodsSpecValue对象", description = "规格值表")
public class GoodsSpecValue extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "规格ID")
    private Long specId;

    @Schema(description = "规格值")
    private String specValue;

    

    


}
