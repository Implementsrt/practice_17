package com.qhy.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * SKU增值保障
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_sku_safeguard")
@Schema(name = "GoodsSkuSafeguard对象", description = "SKU增值保障")
public class GoodsSkuSafeguard extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "SKU_ID")
    private Long skuId;

    @Schema(description = "SAFEGUARD_ID")
    private Long safeguardId;

    

    


}
