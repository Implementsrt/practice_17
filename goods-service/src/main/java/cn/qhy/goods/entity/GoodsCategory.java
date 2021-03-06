package cn.qhy.goods.entity;

import cn.qhy.common.core.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_category")
@Schema(name = "GoodsCategory对象", description = "分类表")
public class GoodsCategory extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "分类名称")
    private String categoryName;

    

    


}
