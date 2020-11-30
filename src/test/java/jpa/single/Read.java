package jpa.single;

import com.mycompany.springbasic1102.jpa.entities.many2one.Customer;
import java.util.List;
import jpa.JPATemplate;
import org.hibernate.Query;
import org.junit.Test;

public class Read extends JPATemplate {

    @Test
    public void t1() {
        //查單筆
        Customer customer = (Customer) session.get(Customer.class, 1);//類別,ID值
        System.out.println(customer.getId() + "," + customer.getLastName());
        //查多筆1
        List list = session.createSQLQuery("select*from customer").list();
        list.stream().forEach(System.out::println);
        //查多筆2
        List<Customer> list2 = session.createQuery("from Customer").list();
        list2.stream().forEach(System.out::println);
        //查多筆3
        Query query = session.createQuery("from Customer c where c.id>=?");
        query.setParameter(0, 2);
        List<Customer> list3 = query.list();
        list3.stream().forEach(System.out::println);
    }
}
