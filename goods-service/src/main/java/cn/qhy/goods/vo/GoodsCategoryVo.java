package cn.qhy.goods.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author qhy
 * @date 2021/12/29 16:29
 */
@Data
public class GoodsCategoryVo implements Serializable {

    @Schema(description = "分类ID")
    private Long id;

    @Schema(description = "分类名称")
    private String categoryName;

}
