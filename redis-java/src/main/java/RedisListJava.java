import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author wh
 * @description Redis list 示例
 * @date 2019/4/2
 */
public class RedisListJava {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        //存储数据到列表中,返货long类型,value数量
        Long lpush = jedis.lpush("mylist", "hello", "world", "你好", "世界");
        System.out.println(lpush);
        //通过键与下标获取list [参数说明:key , start , end]键,初始下标,结束下标
        List<String> mylist = jedis.lrange("mylist", 0, 5);
        for (String value : mylist) {
            System.out.println(value);
        }
    }
}
