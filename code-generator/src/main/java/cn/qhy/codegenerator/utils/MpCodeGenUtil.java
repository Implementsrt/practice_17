package cn.qhy.codegenerator.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mybatis plus 代码生成工具
 *
 * @author qhy
 * @date 2021/10/13 11:09
 */
public class MpCodeGenUtil {

    public static void main(String[] args) {

        String regex = "limit\\s+\\d+(,\\d+)?";

        String sql = "select a,b,c from table_name /*limit*/ where 1=1 ";
        sql += " limit 1,3";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sql);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            String result = sql.replaceAll(regex, "")
                    .replace("/*limit*/", group);
            System.out.println(result);
        }

        // generate();
    }

    public static void generate() {
        String outputDir = System.getProperty("user.dir") + "/goods-service/src/main/java";
        String xmlOutputDir = System.getProperty("user.dir") + "/goods-service/src/main/resources/mapper";
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/practice_17", "root", "root")
                .globalConfig(builder -> {
                    builder.author("qhy") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() // 禁止打开文件
                            .outputDir(outputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.qhy") // 设置父包名
                            .controller("web")
                            .moduleName("goods") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("goods_info") // 设置需要生成的表名

                            // fixme 处理继承时的泛型，以及注解的处理

                            .entityBuilder()
                            .disableSerialVersionUID()
                            .superClass("cn.qhy.goods.common.BaseEntity")
                            .enableLombok()
                            .enableChainModel()
                            .enableRemoveIsPrefix()
                            // 不起作用啊
                            .addSuperEntityColumns("gmtCreate", "gmtUpdate")

                            // .enableTableFieldAnnotation()
                            // .idType(IdType.AUTO)

                            .controllerBuilder()
                            .enableRestStyle()
                            .superClass("cn.qhy.goods.common.BaseController")

                            .serviceBuilder()
                            .superServiceClass("cn.qhy.goods.common.IBaseService")
                            .superServiceImplClass("cn.qhy.goods.common.AbstractCommonServiceImpl")


                    // .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    ;
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
