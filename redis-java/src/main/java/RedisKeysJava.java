import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author wh
 * @description Redis Keys 示例
 * @date 2019/4/2
 */
public class RedisKeysJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        //通配符获取所有key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
