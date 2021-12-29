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
 * SKU规格值
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_sku_spec_value")
@Schema(name = "GoodsSkuSpecValue对象", description = "SKU规格值")
public class GoodsSkuSpecValue extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "SKU_ID")
    private Long spuId;

    @Schema(description = "规格值ID")
    private Long specValueId;

    

    


}
