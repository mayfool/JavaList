package test.webCrawlerM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.*;

public class redisTest {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务

		Jedis jedis = new Jedis("localhost");
		jedis.sadd("qew", "asd");
		
		System.out.println(jedis.smembers("qew"));
		// jedis.sadd("foo", "bar");
		// String value = jedis.get("foo");
		//jedis.set("longtest", "{name: leto, planet: dune, likes: [spice]}");
		System.out.println(jedis.hget("sdf", "sdf"));
		if(jedis.spop("test123")==null)
			System.out.println("nullllll");
		System.out.println("sadfds");
	}
}
