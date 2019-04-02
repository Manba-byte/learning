import redis.clients.jedis.Jedis;

/**
 * @author wh
 * @description redis连接示例
 * @date 2019/4/2
 */
public class RedisDemo {
    public static void main(String[] args) {
        //获取jedis对象,设置ip连接,端口号
        Jedis jedis = new Jedis("localhost",6379);
        // 调用ping方法查看是否连接,返回pong即连接成功
        System.out.println("连接成功:"+jedis.ping());
    }
}
