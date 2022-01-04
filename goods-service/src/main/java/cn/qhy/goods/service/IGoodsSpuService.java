package cn.qhy.goods.service;

import cn.qhy.goods.dto.GoodsSpuAddDto;
import cn.qhy.goods.dto.GoodsSpuQuery;
import cn.qhy.goods.entity.GoodsSpu;
import cn.qhy.goods.vo.GoodsSpuVo;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * SPU表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsSpuService extends com.baomidou.mybatisplus.extension.service.IService<GoodsSpu> {

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

    /**
     * 商品SPU列表
     *
     * @param query 筛选条件
     * @return 商品SPU列表
     */
    PageInfo<GoodsSpuVo> listByPage(GoodsSpuQuery query);

}
