package jpa.many2one;

import com.mycompany.springbasic1102.jpa.entities.many2one.Customer;
import jpa.JPATemplate;
import org.junit.Test;

public class Delete extends JPATemplate {

    @Test
    public void t1() {
        //透過游離物件來 Delete One的一方
//        Orders o1=new Orders();
//        o1.setId(1);
//        session.delete(o1);

        //透過永續物件來 Delete One的一方
//     Orders o1=(Orders)session.get(Orders.class, 2);
//        session.delete(o1);

//透過永續物件來 Delete 多的一方，條件是沒有Orders的資料
        Customer c1 = (Customer) session.get(Customer.class, 1);
        session.delete(c1);
       
        System.out.println("刪除成功");
    }
}
