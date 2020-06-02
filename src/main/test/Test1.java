import com.atguigu.domain.Department;
import com.atguigu.domain.Employee;
import com.atguigu.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    public void test() {
        mapper.dels(new Integer[]{4, 5});
    }


}
