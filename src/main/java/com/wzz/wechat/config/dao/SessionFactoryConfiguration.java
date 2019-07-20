package com.wzz.wechat.config.dao;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 用于事务的提交
 */
@SpringBootConfiguration
public class SessionFactoryConfiguration {

    @Value("${mybatis.config-location}")
    private String myBatisConfigPath;
    @Value("${mybatis.mapper-locations}")
    private String mapperXMLConfigPath;
    @Value("${mybatis.type-aliases-package}")
    private String mapperPackagePath;

    @Autowired
    //这里注入数据源
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperXMLConfigPath;

        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigPath));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(mapperPackagePath);

        return sqlSessionFactoryBean;

    }

}
