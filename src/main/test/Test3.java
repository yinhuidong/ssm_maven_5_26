import com.atguigu.domain.Account;
import com.atguigu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-18:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test3 {

    @Autowired
    private AccountService service;
    @Test
    public void test(){
        service.findAll().forEach(System.out::println);
    }
    @Test
    public void test2(){
        System.out.println("service.findById(1) = " + service.findById(1));
    }
    @Test
    public void test3(){
        System.out.println("service.count() = " + service.count());
    }
    @Test
    public void test4(){
        service.add(new Account(1,"ee",200.0));
    }
    @Test
    public void test5(){
        service.delete(1);
    }
    @Test
    public void test6(){
        service.update(new Account(1,"ff",2000.0));
    }
}
