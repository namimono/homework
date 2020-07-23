package com.wuxiao.config;


import com.wuxiao.person.aspect.ISayAspect;
import com.wuxiao.person.method.ChineseSay;
import com.wuxiao.person.method.EnglishSay;
import com.wuxiao.person.method.ISay;
import com.wuxiao.person.model.Person;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.wuxiao.bussiness.*", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
@PropertySource("classpath:db.properties")
@MapperScan("com.wuxiao.bussiness.*.dao")
public class ConfigIOC {
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${driver}")
    private String driver;
    @Value("${password}")
    private String password;

    @Bean
    public Person person(@Qualifier("englishSay") ISay iSay) {
        return new Person("a", iSay);
    }

    @Bean
    public ISay chineseSay() {
        return new ChineseSay();
    }

    @Bean
    public ISay englishSay() {
        return new EnglishSay();
    }

    @Bean
    public ISayAspect iSayAspect(){
        return new ISayAspect();
    }
//    配置hikari数据源
    @Bean
    public DataSource dataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setDriverClassName(driver);
        hikariDataSource.setUsername(user);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }
//  整合mybatis
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        给mybatis配置数据源
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
//        注册mapper文件
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }


//    配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) throws PropertyVetoException {

        return new DataSourceTransactionManager(dataSource);
    }

}
