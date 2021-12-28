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
 * 增值保障
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_safeguard")
@ApiModel(value = "GoodsSafeguard对象", description = "增值保障")
public class GoodsSafeguard extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("保障名称")
    private String safeguardName;

    @ApiModelProperty("保障价格")
    private BigDecimal price;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;


}
