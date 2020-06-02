import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-9:11
 */
public class Test2 {

    Jedis jedis=new Jedis("121.199.31.160",6379);
    @Test
    public void test(){
        System.out.println("jedis.ping() = " + jedis.ping());
    }
}
