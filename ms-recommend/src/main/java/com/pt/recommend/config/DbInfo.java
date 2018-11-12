package com.pt.recommend.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: DbInfo
 * @Description: 设置数据库连接信息
 * @author 谯雕
 * @date 2018年11月2日
 *
 */
@SpringBootConfiguration
@PropertySource(value = { "file:config/dbinfo.properties" })
@ConfigurationProperties(prefix = "jpa.datasource")
public class DbInfo {

	private Boolean onlyRead;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Long maxLifeTime;
	private Integer maximumPoolSize;
	private Integer minimumIdle;
	private Long idleTimeout;
	private Long connectionTimeout;
	private Long validationTimeout;
	public Boolean getOnlyRead() {
		return onlyRead;
	}
	public void setOnlyRead(Boolean onlyRead) {
		this.onlyRead = onlyRead;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMaxLifeTime() {
		return maxLifeTime;
	}
	public void setMaxLifeTime(Long maxLifeTime) {
		this.maxLifeTime = maxLifeTime;
	}
	public Integer getMaximumPoolSize() {
		return maximumPoolSize;
	}
	public void setMaximumPoolSize(Integer maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}
	public Integer getMinimumIdle() {
		return minimumIdle;
	}
	public void setMinimumIdle(Integer minimumIdle) {
		this.minimumIdle = minimumIdle;
	}
	public Long getIdleTimeout() {
		return idleTimeout;
	}
	public void setIdleTimeout(Long idleTimeout) {
		this.idleTimeout = idleTimeout;
	}
	public Long getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(Long connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public Long getValidationTimeout() {
		return validationTimeout;
	}
	public void setValidationTimeout(Long validationTimeout) {
		this.validationTimeout = validationTimeout;
	}
}
