package com.qhy.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qhy.goods.common.AbstractCommonServiceImpl;
import com.qhy.goods.dto.GoodsCategoryAddDto;
import com.qhy.goods.entity.GoodsCategory;
import com.qhy.goods.mapper.GoodsCategoryMapper;
import com.qhy.goods.service.IGoodsCategoryService;
import com.qhy.goods.util.AssertUtil;
import com.qhy.goods.vo.GoodsCategoryVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Service
public class GoodsCategoryServiceImpl extends AbstractCommonServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long create(GoodsCategoryAddDto formData) {
        GoodsCategory goodsCategory = msConverter.toEntity(formData);

        GoodsCategory repeatRec = baseMapper.selectOne(new QueryWrapper<>(goodsCategory));
        AssertUtil.isTrue(null != repeatRec, "分类已存在");

        baseMapper.insert(goodsCategory);
        return goodsCategory.getId();
    }

    @Override
    public List<GoodsCategoryVo> listCategory() {
        List<GoodsCategory> goodsCategories = baseMapper.selectList(new QueryWrapper<>());
        return goodsCategories.stream().map(d -> msConverter.toVo(d)).toList();
    }
}
