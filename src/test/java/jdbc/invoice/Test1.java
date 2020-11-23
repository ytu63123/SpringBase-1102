package jdbc.invoice;

import com.mycompany.springbasic1102.jdbc.invoice.entity.Invoice;
import com.mycompany.springbasic1102.jdbc.invoice.entity.Item;
import com.mycompany.springbasic1102.jdbc.invoice.entity.ItemProduct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Test1 {

    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
    JdbcTemplate jdbcTemplate = ctx.getBean("jdbcTemplate", JdbcTemplate.class);

    class ItemMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setAmount(rs.getInt("amount"));
            Integer ipid = rs.getInt("ipid");
            String sql_1 = "select *from itemproduct where id=?";
            ItemProduct product = jdbcTemplate.queryForObject(sql_1, new BeanPropertyRowMapper<>(ItemProduct.class), ipid);
            item.setProduct(product);
            Integer invid = rs.getInt("invid");
            String sql_2 = "select *from invoice where id=?";
            Invoice invoice = jdbcTemplate.queryForObject(sql_2, new BeanPropertyRowMapper<>(Invoice.class), invid);
            item.setInvoice(invoice);
            return item;
        }

    }

    @Test
    public void t1() {
        String sql = "select *from item";
        List<Item> list = jdbcTemplate.query(sql, new ItemMapper());
        System.out.println(list);
    }
}
