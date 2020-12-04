package jpa.one2one;

import com.mycompany.springbasic1102.jpa.entities.one2one.Boss;
import com.mycompany.springbasic1102.jpa.entities.one2one.Company;
import jpa.JPATemplate;
import org.junit.Test;

public class Create2 extends JPATemplate {

    @Test
    public void t1() {
        Boss boss = new Boss();
        boss.setName("Mary");
        Company company = new Company();
        company.setName("B公司");

        company.setBoss(boss);
        //聯集新增
        //@OneToOne(cascade = CascadeType.PERSIST)
        session.persist(company);
    }
}
