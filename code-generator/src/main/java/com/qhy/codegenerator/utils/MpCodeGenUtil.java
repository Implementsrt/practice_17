package com.qhy.codegenerator.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mybatis plus 代码生成工具
 *
 * @author qhy
 * @date 2021/10/13 11:09
 */
public class MpCodeGenUtil {

    public static void main(String[] args) {
        generate();
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
                    builder.parent("com.qhy") // 设置父包名
                            .controller("web")
                            .moduleName("goods") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("goods_info") // 设置需要生成的表名

                            .entityBuilder()
                            .disableSerialVersionUID()
                            .superClass("com.qhy.goods.entity.BaseEntity")
                            .enableLombok()
                            .enableChainModel()
                            .enableRemoveIsPrefix()
                            // 不起作用啊
                            .addSuperEntityColumns("gmtCreate", "gmtUpdate")

                            // .enableTableFieldAnnotation()
                            // .idType(IdType.AUTO)

                            .controllerBuilder()
                            .enableRestStyle()
                            .superClass("com.qhy.goods.web.BaseController")

                            .serviceBuilder()
                            .superServiceClass("com.qhy.goods.service.IBaseService")

                    // .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    ;
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
