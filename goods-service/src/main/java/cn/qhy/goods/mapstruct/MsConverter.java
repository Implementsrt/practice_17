package cn.qhy.goods.mapstruct;

import cn.qhy.goods.dto.GoodsBrandAddDto;
import cn.qhy.goods.dto.GoodsCategoryAddDto;
import cn.qhy.goods.dto.GoodsSpuAddDto;
import cn.qhy.goods.dto.GoodsSpuQuery;
import cn.qhy.goods.entity.GoodsBrand;
import cn.qhy.goods.entity.GoodsCategory;
import cn.qhy.goods.entity.GoodsSpu;
import cn.qhy.goods.vo.GoodsBrandVo;
import cn.qhy.goods.vo.GoodsCategoryVo;
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

    GoodsSpu toEntity(GoodsSpuQuery source);

}
