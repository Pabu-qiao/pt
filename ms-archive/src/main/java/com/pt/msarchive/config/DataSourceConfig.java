package com.pt.msarchive.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @ClassName: DataSourceConfig
 * @Description: 数据源相关配置
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@SpringBootConfiguration
public class DataSourceConfig {

	@Autowired
	private DbInfo dbInfo;
	
	/**
	 * @Title: dataSource
	 * @Description: 配置数据源
	 * @return
	 */
	@Bean(destroyMethod="close")
	@Primary
	public DataSource dataSource() {
		HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
		
		dataSource.setDriverClassName(dbInfo.getDriverClassName());
		dataSource.setJdbcUrl(dbInfo.getUrl());
		dataSource.setUsername(dbInfo.getUsername());
		dataSource.setPassword(dbInfo.getPassword());
		
		dataSource.setReadOnly(dbInfo.getOnlyRead());
		dataSource.setMaxLifetime(dbInfo.getMaxLifeTime());
		dataSource.setMaximumPoolSize(dbInfo.getMaximumPoolSize());
		dataSource.setMinimumIdle(dbInfo.getMinimumIdle());
		dataSource.setIdleTimeout(dbInfo.getIdleTimeout());
		dataSource.setConnectionTimeout(dbInfo.getConnectionTimeout());
		dataSource.setValidationTimeout(dbInfo.getValidationTimeout());
		
		return dataSource;
	}
	
	/**
	 * @Title: transactionManager
	 * @Description: 配置数据源事务管理
	 * @return
	 */
	/*@Bean
	@Primary
	这个方式定义事务，会导致不能存入数据库
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}*/
}
