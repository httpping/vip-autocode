package com.baomidou.springboot.test.generator;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import org.junit.Test;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.tp.api";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "work_share_rule","work_share_sku","work_share_sku_item","work_share_order","work_share_order_item","work_share_manage","work_share_business_info");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://fas-mysql-test.paas.kjtyun.com:44408/init_table";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("v9mq3C48QG")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("work_")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("tanping")
                .setOutputDir("C:\\work\\java\\mybatis\\mybatisplus-spring-boot\\src\\main\\java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        config.setActiveRecord(true);
        config.setBaseColumnList(true);
        config.setBaseResultMap(true);


        //自定义 末班
        List temple = new ArrayList();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")

                ).setCfg( // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                        new InjectionConfig() {
                            @Override
                            public void initMap() {
                                Map<String, Object> map = new HashMap<>();
                                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                                map.put("rpc.java.vm",this.getConfig().getGlobalConfig().getControllerName() + "-myen");
                                map.put("rpc","rpcdemo");
                                this.setMap(map);
                            }
                        }.setFileOutConfigList(temple))
                ;

        mpg.execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
