package com.qhy.goods.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.dialect.helper.MySqlDialect;
import org.apache.ibatis.cache.CacheKey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义mybatis分页拦截器，实现指定limit位置的功能
 *
 * @author qhy
 * @date 2021/12/30 17:34
 */
public class MybatisPlugins extends MySqlDialect {

    /**
     * sql中自定义limit位置的注释标记
     */
    public static final String SQL_LIMIT_TAG = "/*limit*/";
    public static final String REGEX_LIMIT_STATEMENT = "LIMIT\\s+\\?(,\\s+\\?)?";
    public static final Pattern PATTERN_LIMIT_STATEMENT = Pattern.compile(REGEX_LIMIT_STATEMENT);

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        // fixme 应该也就是在这里优化掉left join 了

        // 时代变了，不给我参数的位置了，那我们直接正则匹配 limit  然后替换到我们想要的位置就行

        String pageSql = super.getPageSql(sql, page, pageKey);

        if (pageSql.contains(SQL_LIMIT_TAG)) {
            Matcher matcher = PATTERN_LIMIT_STATEMENT.matcher(pageSql);
            if (matcher.find()) {
                String group = matcher.group();
                return pageSql.replaceAll(REGEX_LIMIT_STATEMENT, "")
                        .replace("/*limit*/", group);
            }
        }

        return super.getPageSql(sql, page, pageKey);
    }
}
