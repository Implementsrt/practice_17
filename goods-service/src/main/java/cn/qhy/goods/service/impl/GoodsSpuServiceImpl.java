package cn.qhy.goods.service.impl;

import cn.qhy.goods.common.AbstractCommonServiceImpl;
import cn.qhy.goods.dto.GoodsSpuAddDto;
import cn.qhy.goods.dto.GoodsSpuQuery;
import cn.qhy.goods.entity.GoodsSpu;
import cn.qhy.goods.mapper.GoodsSpuMapper;
import cn.qhy.goods.service.IGoodsSpuService;
import cn.qhy.goods.vo.GoodsSpuVo;
import com.github.pagehelper.PageInfo;
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

        return PageInfo.of(baseMapper.listGoodsSpu(query));
    }


}
