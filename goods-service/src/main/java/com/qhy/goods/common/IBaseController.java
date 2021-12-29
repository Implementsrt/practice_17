package com.qhy.goods.common;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qhy
 * @date 2021/12/29 15:34
 */
public class IBaseController<S>  {

    @Autowired(required = false)
    protected S baseService;

}
