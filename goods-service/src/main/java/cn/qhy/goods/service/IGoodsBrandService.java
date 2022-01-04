package cn.qhy.goods.service;

import cn.qhy.goods.dto.GoodsBrandAddDto;
import cn.qhy.goods.entity.GoodsBrand;
import cn.qhy.goods.vo.GoodsBrandVo;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author qhy
 * @since 2021-12-28
 */
public interface IGoodsBrandService extends com.baomidou.mybatisplus.extension.service.IService<GoodsBrand> {

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
