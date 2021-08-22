package com.prodigious.messanger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class CacheConfiguration {
	@Value("${spring.redis.url}")
	private String redisURL;
	@Value("${spring.redis.port}")
	private String redisPort;
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConFactory
	      = new JedisConnectionFactory();
	    jedisConFactory.setHostName(redisURL);
	    jedisConFactory.setPort(Integer.valueOf(redisPort));
	    jedisConFactory.getPoolConfig().setMaxIdle(30);
	    jedisConFactory.getPoolConfig().setMinIdle(10);
	    return jedisConFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
}
