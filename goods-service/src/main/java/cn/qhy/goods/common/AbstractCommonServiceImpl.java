package cn.qhy.goods.common;

import cn.qhy.common.core.BaseEntity;
import cn.qhy.goods.mapstruct.MsConverter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

/**
 * @author qhy
 * @date 2021/12/29 17:01
 */
public class AbstractCommonServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> {

    @Resource
    protected MsConverter msConverter;

}
