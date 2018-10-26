package com.application.boot.redis;

import com.application.boot.redis.jedis.factory.JedisSimpleSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @desc redis 管理.
 * @author 孤狼
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix="spring.redis")
public class RedisInfoConfig {
	
	private int timeout=50000;
	private String host="127.0.0.1";
	private int port=6379;
	private String password="123456";

	@Autowired
	private RedisPoolConfig poolConfig;
	
	@Bean
	public JedisPoolConfig getRedisConfig(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(poolConfig.getMaxTotal());
		config.setMaxIdle(poolConfig.getMaxIdle());
		config.setMinIdle(poolConfig.getMinIdle());
		config.setMaxWaitMillis(poolConfig.getMaxWaitMillis());
		config.setTestOnBorrow(poolConfig.isTestOnBorrow());
		config.setTestOnReturn(poolConfig.isTestOnReturn());
		config.setTestWhileIdle(poolConfig.isTestWhileIdle());
		config.setTimeBetweenEvictionRunsMillis(poolConfig.getTimeBetweenEvictionRunsMillis());
		config.setNumTestsPerEvictionRun(poolConfig.getNumTestsPerEvictionRun());
		return config;
	}
	
	@Bean
	public JedisPool getJedisPool(){
		JedisPoolConfig config = getRedisConfig();
		JedisPool pool = new JedisPool(config,host,port,timeout,password);
		return pool;
	}
	
	
	@Bean
	public JedisSimpleSessionFactory getSessionFactory(){
		JedisPool pool = getJedisPool();
		JedisSimpleSessionFactory factory = new JedisSimpleSessionFactory();
		factory.setPool(pool);
		return  factory;
	}
	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
