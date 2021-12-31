package com.qhy.goods.config;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.github.pagehelper.Page;
import com.github.pagehelper.dialect.helper.MySqlDialect;
import lombok.SneakyThrows;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
     * 是否开启优化countSql中的left join  : 默认开启
     * Warning!!!  如果开启，那么在where条件中的字段必须带有指定的表前缀，否则可能会出现优化后无法找到字段的异常
     */
    private static final boolean OPTIMIZE_LEFT_JOIN = true;

    /**
     * sql中自定义limit位置的注释标记
     */
    public static final String SQL_LIMIT_TAG = "/*limit*/";
    public static final String REGEX_LIMIT_STATEMENT = "LIMIT\\s+\\?(,\\s+\\?)?";
    public static final Pattern PATTERN_LIMIT_STATEMENT = Pattern.compile(REGEX_LIMIT_STATEMENT);

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        // 时代变了，不给我参数和对应的位置了，那我们直接正则匹配 limit  然后替换到我们想要的位置就行
        String pageSql = super.getPageSql(sql, page, pageKey);
        return this.supportCustomLimitLocation(pageSql);
    }

    @Override
    public String getCountSql(MappedStatement ms, BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey) {
        String countSql = super.getCountSql(ms, boundSql, parameterObject, rowBounds, countKey);
        return this.optimizeCountSql(countSql);
    }

    /**
     * 支持自定义limit 位置
     *
     * @param pageSql 分页sql
     * @return 自定义limit位置后的sql
     */
    private String supportCustomLimitLocation(String pageSql) {

        if (!pageSql.contains(SQL_LIMIT_TAG)) {
            return pageSql;
        }

        Matcher matcher = PATTERN_LIMIT_STATEMENT.matcher(pageSql);
        if (!matcher.find()) {
            return pageSql;
        }

        String group = matcher.group();
        return pageSql.replaceAll(REGEX_LIMIT_STATEMENT, "")
                .replace("/*limit*/", group);

    }

    /**
     * count sql 自动优化left join
     *
     * @param countSql 原count sql
     * @return 优化后的count sql
     */
    @SneakyThrows
    private String optimizeCountSql(String countSql) {

        if (!OPTIMIZE_LEFT_JOIN) {
            return countSql;
        }

        /* 此方法借鉴于PaginationInnerInterceptor.autoCountSql方法 */

        Select select = (Select) CCJSqlParserUtil.parse(countSql);
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        List<Join> joins = plainSelect.getJoins();

        if (CollUtil.isEmpty(joins)) {
            return countSql;
        }


        String whereS = Optional.ofNullable(plainSelect.getWhere()).map(Expression::toString).orElse(StringPool.EMPTY);
        // 不区分大小写
        whereS = whereS.toLowerCase();

        Iterator<Join> joinIterator = joins.iterator();
        while (joinIterator.hasNext()) {
            Join join = joinIterator.next();

            // 如果不是左连接，保留
            if (!join.isLeft()) {
                continue;
            }

            FromItem rightItem = join.getRightItem();
            String str = "";
            if (rightItem instanceof Table table) {
                str = Optional.ofNullable(table.getAlias()).map(Alias::getName).orElse(table.getName()) + StringPool.DOT;
            } else if (rightItem instanceof SubSelect subSelect) {
                /* 如果 left join 是子查询，并且子查询里包含 ?(代表有入参) 或者 where 条件里包含使用 join 的表的字段作条件,就不移除 join */
                if (subSelect.toString().contains(StringPool.QUESTION_MARK)) {
                    continue;
                }
                str = subSelect.getAlias().getName() + StringPool.DOT;
            }
            // 不区分大小写
            str = str.toLowerCase();
            String onExpressionS = join.getOnExpression().toString();
            /* 如果 join 里包含 ?(代表有入参) 或者 where 条件里包含使用 join 的表的字段作条件,就不移除 join */
            if (onExpressionS.contains(StringPool.QUESTION_MARK) || whereS.contains(str)) {
                continue;
            }

            joinIterator.remove();

        }

        return select.toString();

    }

}
