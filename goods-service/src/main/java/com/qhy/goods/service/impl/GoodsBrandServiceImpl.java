package com.qhy.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qhy.goods.common.AbstractCommonServiceImpl;
import com.qhy.goods.dto.GoodsBrandAddDto;
import com.qhy.goods.entity.GoodsBrand;
import com.qhy.goods.mapper.GoodsBrandMapper;
import com.qhy.goods.service.IGoodsBrandService;
import com.qhy.goods.util.AssertUtil;
import com.qhy.goods.vo.GoodsBrandVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Service
public class GoodsBrandServiceImpl extends AbstractCommonServiceImpl<GoodsBrandMapper, GoodsBrand> implements IGoodsBrandService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long create(GoodsBrandAddDto formData) {
        GoodsBrand goodsBrand = msConverter.toEntity(formData);

        GoodsBrand repeatRec = baseMapper.selectOne(new QueryWrapper<>(goodsBrand));
        AssertUtil.isTrue(null != repeatRec, "品牌已存在");

        baseMapper.insert(goodsBrand);
        return goodsBrand.getId();
    }

    @Override
    public List<GoodsBrandVo> listBrand() {
        List<GoodsBrand> goodsBrands = baseMapper.selectList(new QueryWrapper<>());
        return goodsBrands.stream().map(d -> msConverter.toVo(d)).toList();
    }
}
