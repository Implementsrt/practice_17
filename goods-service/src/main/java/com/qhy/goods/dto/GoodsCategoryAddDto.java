package com.qhy.goods.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author qhy
 * @date 2021/12/29 16:27
 */
@Data
@Tag(name = "添加分类参数")
public class GoodsCategoryAddDto {

    /**
     * 分类名称
     */
    @Schema(description = "分类名称")
    @NotBlank(message = "请输入分类名称")
    @Size(max = 50, message = "分类名称不能超过50个字符")
    private String categoryName;

}
