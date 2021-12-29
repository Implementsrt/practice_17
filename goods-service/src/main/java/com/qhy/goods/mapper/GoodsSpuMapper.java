package com.qhy.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhy.goods.entity.GoodsSpu;
import com.qhy.goods.vo.GoodsSpuVo;

/**
 * <p>
 * SPU表 Mapper 接口
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface GoodsSpuMapper extends BaseMapper<GoodsSpu> {

    /**
     * 查询商品详情
     *
     * @param id 商品ID
     * @return 商品详情
     */
    GoodsSpuVo getDetail(Long id);

}
