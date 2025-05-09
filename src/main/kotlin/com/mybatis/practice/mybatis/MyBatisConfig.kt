package com.mybatis.practice.mybatis

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource


@Configuration
class MybatisConfig {

    @Bean
    @Throws(Exception::class)
    // 데이터베이스 연결 및 SQL 실행을 관리
    fun sqlSessionFactory(dataSource: DataSource?): SqlSessionFactory? {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        sqlSessionFactoryBean.setConfigLocation(ClassPathResource("mybatis/mybatis-config.xml"))

        return sqlSessionFactoryBean.getObject()
    }

    @Bean
    // SQL 실행 및 트랜잭션 관리를 담당
    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }

    @Bean
    // 스프링에서 트랜잭션 관리
    fun transactionManager(dataSource: DataSource?): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource!!)
    }
}