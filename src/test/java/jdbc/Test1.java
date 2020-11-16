package jdbc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Test1 {
  @Test  //測試是否能用作
    public  void t1(){
      ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-config.xml");
      JdbcTemplate jdbcTemplate=ctx.getBean("jdbcTemplate",JdbcTemplate.class);
      System.out.println(jdbcTemplate);
    }
}
