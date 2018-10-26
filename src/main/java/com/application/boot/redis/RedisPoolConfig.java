package com.application.boot.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @desc jedisPools 配置
 * @author 孤狼
 */
@Component
@ConfigurationProperties(prefix="spring.redis.pool")
public class RedisPoolConfig {
	
	private int maxTotal=100;
	
	private int maxIdle=50;
	
	private int minIdle=50;
	
	private int maxWaitMillis=18000;
	
	private boolean testOnBorrow=true;
	
	private boolean testOnReturn=true;
	
	private boolean testWhileIdle=true;
	
	private int  timeBetweenEvictionRunsMillis=60000;
	
	private int  numTestsPerEvictionRun=-1;
	
	public int getMaxTotal() {
		return maxTotal;
	}
	
	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}
	
	public int getMaxIdle() {
		return maxIdle;
	}
	
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	
	public int getMinIdle() {
		return minIdle;
	}
	
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	
	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}
	
	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}
	
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	
	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	
	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	
	public int getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}
	
	public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}
}
