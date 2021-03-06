package cn.qhy.goods.mapper;

import cn.qhy.goods.dto.GoodsSpuQuery;
import cn.qhy.goods.entity.GoodsSpu;
import cn.qhy.goods.vo.GoodsSpuVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

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

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 商品列表
     */
    List<GoodsSpuVo> listGoodsSpu(GoodsSpuQuery query);

}
