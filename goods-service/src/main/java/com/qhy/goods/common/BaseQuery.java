package com.qhy.goods.common;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

/**
 * @author qhy
 * @date 2021/12/30 9:58
 */
@Data
public class BaseQuery {

    @Hidden
    private Integer page;
    @Hidden
    private Integer limit;

    public void paging() {
        // fixme 想一下办法，怎么能够全局自动的判断，而不需要显式的调用
        // 然后第二个问题就是怎么优化countSql  参考pagination，在count的时候把left join 的表去掉
        // 第三个就是允许自定义limit的  （Mysql
        if (!ObjectUtil.hasNull(page, limit)) {
            PageHelper.startPage(page, limit);
        }
    }

}
