package cn.qhy.goods.entity;

import cn.qhy.common.core.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * SPU表
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("goods_spu")
@Schema(name = "GoodsSpu对象", description = "SPU表")
public class GoodsSpu extends BaseEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @Schema(description = "商品编号，唯一")
    private String spuNo;

    @Schema(description = "商品名称")
    private String goodsName;

    @Schema(description = "最低售价")
    private BigDecimal lowPrice;

    @Schema(description = "分类ID")
    private Long categoryId;

    @Schema(description = "品牌ID")
    private Long brandId;

    /**
     * 生成商品编码
     */
    public GoodsSpu generateSpuNo() {
        // 分类ID、品牌ID各占3位 + 时间戳
        this.spuNo = String.format("%03d%03d%s", brandId, categoryId, System.currentTimeMillis());
        return this;
    }


}
