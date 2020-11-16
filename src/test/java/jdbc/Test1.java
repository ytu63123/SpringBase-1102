package jdbc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test1 {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
    JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

    @Test  //測試是否能用作
    public void t1() {
        System.out.println(jdbcTemplate);
        //create();
        //create("DeleteMe", 19, "女");
        // updateAgeById(1, 20);
       // deleteById(3);
    }

    // CRUD - Create 新增資料
    private void create() {
        String sql = "insert into Emp(ename,age,sex) values('john',18,'男')";
        jdbcTemplate.update(sql);
    }

    // CRUD - Create 新增資料2
    private void create(String ename, Integer age, String sex) {
        String sql = "insert into Emp(ename,age,sex) values(?,?,?)";
        jdbcTemplate.update(sql, ename, age, sex);
    }

    // CRUD - Update 更新資料
    private void updateAgeById(Integer eid, Integer age) {
        String sql = "update emp set age=? where eid=?";
        jdbcTemplate.update(sql, age, eid);
    }
    // CRUD = Delete 刪除資料
    private void deleteById(Integer eid) {
        String sql = "Delete From Emp where eid=?";
        jdbcTemplate.update(sql, eid);
    }

}
