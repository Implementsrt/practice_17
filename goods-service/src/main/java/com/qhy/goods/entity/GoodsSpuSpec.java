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
 * SPU规格表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_spu_spec")
@Schema(name = "GoodsSpuSpec对象", description = "SPU规格表")
public class GoodsSpuSpec extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "SPU_ID")
    private Long spuId;

    @Schema(description = "SPEC_ID")
    private Long specId;

    

    


}
