package com.trkj.code.modules.examine_management;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

//代码自动生成器
public class MybatisPlusCode {
    public static void main(String[] args) {
        //需要构建一个代码自动生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //配置策略
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        /*获取当前系统目录*/
        String property = System.getProperty("user.dir");
        //代码输出目录
        globalConfig.setOutputDir(property + "/src/main/java/");
        /*生成作者的信息*/
        globalConfig.setAuthor("晚风");
        //是否打开资源管理器
        globalConfig.setOpen(false);
        //是否覆盖原来生成的文件
        globalConfig.setFileOverride(false);
        //服务的所有的名字 去掉Service的I前缀
        globalConfig.setServiceName("%sService");
        //日期的类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        //Swagger2文档
        globalConfig.setSwagger2(true);
        //生成基本的resultMap
        globalConfig.setBaseResultMap(true);
        //生成基本的SQL片段
        globalConfig.setBaseColumnList(true);
        //将全局配置放在自动生成器里面
        autoGenerator.setGlobalConfig(globalConfig);

        //2、设置数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
        //数据库的连接驱动
        dataSourceConfig.setDriverName("oracle.jdbc.driver.OracleDriver");
        //用户名
        dataSourceConfig.setUsername("power");
        //密码
        dataSourceConfig.setPassword("123456");
        //数据库的类型
        dataSourceConfig.setDbType(DbType.ORACLE);
        //将数据源配置放在自动生成器里面
        autoGenerator.setDataSource(dataSourceConfig);

        // 配置模板 自定义模板
//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null); // 不生成xml文件
//        templateConfig.setEntity(null); // 不生成实体类
//        templateConfig.setMapper(null);//不生成mapper
//        templateConfig.setService(null);//不生成service
//        templateConfig.setServiceImpl(null);//不生成serviceImpl
//        templateConfig.setController(null);//不生成controller
//        autoGenerator.setTemplate(templateConfig);

        //3.包的配置
        PackageConfig packageConfig = new PackageConfig();
        //模块名
//        packageConfig.setModuleName("mybatisplus");
        //放在哪一个包下
        packageConfig.setParent("com.trkj.balance.modules.examine_management");

      // 不写会默认一个包名
        //实体类的名字
//        packageConfig.setEntity("entity");
        //Mapper的名字
//        packageConfig.setMapper("mapper");
        //服务层的名字
//        packageConfig.setService("service");
        //控制器层的名字
//        packageConfig.setController("controller");



        //将包的配置放在自动生成器里面
        autoGenerator.setPackageInfo(packageConfig);

        //4、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        //数据库表名 自己写自己模块的表名
        strategyConfig.setInclude("CLOCK_RECORD");// 不写默认生成所有的表！！！
        //包的命名规则
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //列的名字
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否开启Lombok注解
        strategyConfig.setEntityLombokModel(true);
        //开启我们的驼峰命名
        strategyConfig.setRestControllerStyle(true);
        //将策略配置放在自动生成器里面
        autoGenerator.setStrategy(strategyConfig);
        //执行自动生成器
        autoGenerator.execute();
    }
}
