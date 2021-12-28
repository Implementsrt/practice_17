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
 * 规格表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_spec")
@ApiModel(value = "GoodsSpec对象", description = "规格表")
public class GoodsSpec extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("规格编号")
    private String specNo;

    @ApiModelProperty("规格名称")
    private String specName;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;


}
