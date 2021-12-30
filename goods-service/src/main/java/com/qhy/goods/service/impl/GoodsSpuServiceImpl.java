package com.qhy.goods.service.impl;

import com.github.pagehelper.PageInfo;
import com.qhy.goods.common.AbstractCommonServiceImpl;
import com.qhy.goods.dto.GoodsSpuAddDto;
import com.qhy.goods.dto.GoodsSpuQuery;
import com.qhy.goods.entity.GoodsSpu;
import com.qhy.goods.mapper.GoodsSpuMapper;
import com.qhy.goods.service.IGoodsSpuService;
import com.qhy.goods.vo.GoodsSpuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * SPU表 服务实现类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
@Service
public class GoodsSpuServiceImpl extends AbstractCommonServiceImpl<GoodsSpuMapper, GoodsSpu> implements IGoodsSpuService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long create(GoodsSpuAddDto formData) {
        GoodsSpu goodsSpu = msConverter.toEntity(formData);
        // 生成商品编码
        baseMapper.insert(goodsSpu.generateSpuNo());

        return goodsSpu.getId();
    }

    @Override
    public GoodsSpuVo getDetail(Long id) {
        return baseMapper.getDetail(id);
    }

    @Override
    public PageInfo<GoodsSpuVo> listByPage(GoodsSpuQuery query) {

        query.paging();

        return PageInfo.of(baseMapper.listGoodsSpu(query));
    }


}
