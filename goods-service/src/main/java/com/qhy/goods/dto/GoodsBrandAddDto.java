package com.qhy.goods.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author qhy
 * @date 2021/12/29 15:56
 */
@Data
@Tag(name = "添加品牌参数")
public class GoodsBrandAddDto {

    /**
     * 品牌名称
     */
    @Schema(description = "品牌名称")
    @NotBlank(message = "请输入品牌名称")
    @Size(max = 50, message = "品牌名称不能超过50个字符")
    private String brandName;


}
