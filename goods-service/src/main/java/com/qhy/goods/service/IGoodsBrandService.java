package com.qhy.goods.service;

import com.qhy.goods.common.IBaseService;
import com.qhy.goods.dto.GoodsBrandAddDto;
import com.qhy.goods.entity.GoodsBrand;
import com.qhy.goods.vo.GoodsBrandVo;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsBrandService extends IBaseService<GoodsBrand> {

    /**
     * 添加品牌
     *
     * @param formData 品牌信息
     * @return 品牌ID
     */
    Long create(GoodsBrandAddDto formData);

    /**
     * 品牌列表
     *
     * @return 品牌列表
     */
    List<GoodsBrandVo> listBrand();

}
