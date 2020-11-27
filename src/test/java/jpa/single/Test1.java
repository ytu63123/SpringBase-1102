package jpa.single;

import com.mycompany.springbasic1102.jpa.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jpa-config.xml");
        //取得連線工廠
        SessionFactory sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
        //取得連線物件
        Session session = sessionFactory.getCurrentSession();
        //取得交易管理
        Transaction tran = session.beginTransaction();
        //進行資料表交易程序.....  
        //CRUD
        Customer customer=new Customer();
        customer.setLastName("Jonh");
        session.persist(customer);//新增 customer物件資料到customer資料表中建立一筆紀錄
        
        tran.commit();//提交
        sessionFactory.close();//關閉
    }
}
