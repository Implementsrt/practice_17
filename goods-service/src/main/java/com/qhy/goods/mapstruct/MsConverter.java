package com.qhy.goods.mapstruct;

import com.qhy.goods.dto.GoodsBrandAddDto;
import com.qhy.goods.dto.GoodsCategoryAddDto;
import com.qhy.goods.dto.GoodsSpuAddDto;
import com.qhy.goods.entity.GoodsBrand;
import com.qhy.goods.entity.GoodsCategory;
import com.qhy.goods.entity.GoodsSpu;
import com.qhy.goods.vo.GoodsBrandVo;
import com.qhy.goods.vo.GoodsCategoryVo;
import org.mapstruct.Mapper;

/**
 * @author qhy
 * @date 2021/12/29 15:39
 */
@Mapper(componentModel = "spring")
public interface MsConverter {

    GoodsSpu toEntity(GoodsSpuAddDto source);

    GoodsBrand toEntity(GoodsBrandAddDto source);

    GoodsBrandVo toVo(GoodsBrand source);

    GoodsCategory toEntity(GoodsCategoryAddDto source);

    GoodsCategoryVo toVo(GoodsCategory source);

}
