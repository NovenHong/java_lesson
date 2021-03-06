package com.owner.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
		
		redisTemplate.setConnectionFactory(connectionFactory);
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		
		return redisTemplate;
		
	}
}
