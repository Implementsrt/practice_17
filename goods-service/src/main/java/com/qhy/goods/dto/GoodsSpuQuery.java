package com.qhy.goods.dto;

import com.qhy.goods.common.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author qhy
 * @date 2021/12/30 10:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class GoodsSpuQuery extends BaseQuery {

    private Long brandId;

    private Long categoryId;

    private String goodsName;

}
