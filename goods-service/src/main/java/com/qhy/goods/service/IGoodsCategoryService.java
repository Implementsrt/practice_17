package com.qhy.goods.service;

import com.qhy.goods.common.IBaseService;
import com.qhy.goods.dto.GoodsCategoryAddDto;
import com.qhy.goods.entity.GoodsCategory;
import com.qhy.goods.vo.GoodsCategoryVo;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsCategoryService extends IBaseService<GoodsCategory> {

    /**
     * 添加分类
     *
     * @param formData 分类信息
     * @return 分类ID
     */
    Long create(GoodsCategoryAddDto formData);

    /**
     * 分类列表
     *
     * @return 分类列表
     */
    List<GoodsCategoryVo> listCategory();

}
