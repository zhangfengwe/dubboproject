package com.fwzhang.generator.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangfengwei
 * @create 2019-03-15 14:59
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        MybatisGenerator mybatisGenerator = new MybatisGenerator();
        try {
            mybatisGenerator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定配置文件
//        File configFile = new File("./src/main/resources/mybatis/gerneratorConfig.xml");
//        File configFile = new File("./src/main/reources/mybatis/gerneratorConfig.xml");
        File configFile = new File("./dubboproject_common/src/main/resources/mybatis/gerneratorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("end");
    }


}
