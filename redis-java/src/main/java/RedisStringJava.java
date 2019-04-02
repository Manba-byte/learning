import redis.clients.jedis.Jedis;

/**
 * @author wh
 * @description Redis String示例
 * @date 2019/4/2
 */
public class RedisStringJava {
    public static void main(String[] args) {
        Jedis jedis =  new Jedis("localhost",6379);
        //设置String键值对
        String set = jedis.set("hello", "world");
        System.out.println("set:"+set);
        //通过键取值
        String get = jedis.get("hello");
        System.out.println("get:"+get);


    }
}
