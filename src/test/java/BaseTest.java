import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Mr.lynn
 * @create: 2018-12-30 16:55
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml","classpath:data-source.xml"})
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
