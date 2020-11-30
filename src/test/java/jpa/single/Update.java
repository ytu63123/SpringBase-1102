package jpa.single;

import com.mycompany.springbasic1102.jpa.entities.many2one.Customer;
import jpa.JPATemplate;
import org.hibernate.Query;
import org.junit.Test;

public class Update extends JPATemplate {

    @Test
    public void t1() {
        //永續物件修改
        Customer c1 = (Customer) session.get(Customer.class, 1);
        c1.setLastName("AAA");
        //新創物件修改
        Customer c2=new Customer();
        c2.setId(2);
        c2.setLastName("BBB");
        session.update(c2);
        //下達SQL修改
        String sql="update Customer set last_name = :lastName where id = :id";
        Query query=session.createQuery(sql);
        query.setParameter("lastName", "CCC");
        query.setParameter("id", 3);
        int updateRowCount=query.executeUpdate();
        System.out.println("updateRowCount="+updateRowCount);
        
        
        
    }
}
