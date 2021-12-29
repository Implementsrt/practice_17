package com.qhy.goods.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qhy
 * @date 2021/12/29 15:59
 */
@Data
@Schema(description = "商品品牌信息")
public class GoodsBrandVo implements Serializable {

    @Schema(description = "品牌ID")
    private Long id;

    @Schema(description = "品牌名称")
    private String brandName;

}
