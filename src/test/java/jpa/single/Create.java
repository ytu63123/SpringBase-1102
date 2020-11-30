package jpa.single;

import com.mycompany.springbasic1102.jpa.entities.many2one.Customer;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate{

    @Test
    public void t1() {
     //進行資料表交易程序.....  
        //CRUD
        Customer customer=new Customer();
        customer.setLastName("Mary");
        session.persist(customer);//新增 customer物件資料到customer資料表中建立一筆紀錄
        
        
    }

}
