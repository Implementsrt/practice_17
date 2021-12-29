package com.qhy.goods.service;

import com.qhy.goods.common.IBaseService;
import com.qhy.goods.dto.GoodsSpuAddDto;
import com.qhy.goods.entity.GoodsSpu;
import com.qhy.goods.vo.GoodsSpuVo;

/**
 * <p>
 * SPU表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsSpuService extends IBaseService<GoodsSpu> {

    /**
     * 添加商品SPU
     *
     * @param formData 商品信息
     * @return 商品ID
     */
    Long create(GoodsSpuAddDto formData);

    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品列表
     */
    GoodsSpuVo getDetail(Long id);

}
