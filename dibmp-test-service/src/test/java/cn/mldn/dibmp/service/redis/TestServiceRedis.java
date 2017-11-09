package cn.mldn.dibmp.service.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations= {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceRedis {
		@Resource
		private	 RedisTemplate<String, Long> redisTemplate;
		@Test
		public void testSet() {
			this.redisTemplate.opsForValue().set("mldn-admin", 1L);
		}
		@Test
		public void testGet() {
			System.err.println("redis 中保存的数据："+ this.redisTemplate.opsForValue().get("mldn-admin"));
		}
}
