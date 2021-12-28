package com.qhy.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
@ApiModel(value = "GoodsSpuSpec对象", description = "SPU规格表")
public class GoodsSpuSpec extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("SPU_ID")
    private Long spuId;

    @ApiModelProperty("SPEC_ID")
    private Long specId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;


}
