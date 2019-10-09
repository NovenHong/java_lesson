package lesson4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.owner.test.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisTest {
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Test
	public void test01() {
		
		redisTemplate.opsForValue().set("test3", "test3");
	}
}
