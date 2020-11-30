package jpa.many2one;

import com.mycompany.springbasic1102.jpa.entities.many2one.Customer;
import com.mycompany.springbasic1102.jpa.entities.many2one.Orders;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate {

    @Test
    public void t1() {
        Customer c1 = new Customer();
        c1.setLastName("Mary");
        Orders o1 = new Orders();
        o1.setOrderName("Cake");
        Orders o2 = new Orders();
        o2.setOrderName("Drink");
        //配置關聯
        o1.setCustomer(c1);
        o2.setCustomer(c1);
        //執行保存動作
        //先新增One的一方，就不會多出Update語句
        session.persist(c1);
        session.persist(o1);
        session.persist(o2);
    
        
        System.out.println("完成");
        
    }
}
