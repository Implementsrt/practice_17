package cn.qhy.goods.service;

import cn.qhy.goods.dto.GoodsCategoryAddDto;
import cn.qhy.goods.entity.GoodsCategory;
import cn.qhy.goods.vo.GoodsCategoryVo;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsCategoryService extends com.baomidou.mybatisplus.extension.service.IService<GoodsCategory> {

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
