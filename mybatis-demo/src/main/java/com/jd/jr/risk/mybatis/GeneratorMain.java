package com.jd.jr.risk.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjin271
 * @date 2020/8/5 16:43
 * @desc
 */
public class GeneratorMain {

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        String genCfg = "/generatorConfiguration.xml";
        File configFile = new File(GeneratorMain.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {

            config = cp.parseConfiguration(configFile);
        } catch (IOException | XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            assert config != null;
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            assert myBatisGenerator != null;
            myBatisGenerator.generate(null);

        } catch (SQLException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("代码反向生成完毕-----");
    }
}
