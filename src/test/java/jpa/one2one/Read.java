package jpa.one2one;

import com.mycompany.springbasic1102.jpa.entities.one2one.Company;
import jpa.JPATemplate;
import org.hibernate.Query;
import org.junit.Test;

public class Read extends JPATemplate {

    @Test
    public void t1() {

        Query query = session.createQuery("From Company c");
        System.out.println(query.list());

        for (Object object : query.list()) {
            Company company = (Company) object;
            System.out.printf("%s %s\n", company.getName(), company.getBoss().getName());
        }

        Company company = (Company) session.get(Company.class, 1);
        Company company1 = (Company) session.get(Company.class, 2);
        System.out.println(company.getName() + ":" + company.getBoss().getName());
        System.out.println(company1.getName() + ":" + company1.getBoss().getName());

    }
}
