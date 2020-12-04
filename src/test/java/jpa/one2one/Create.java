package jpa.one2one;

import com.mycompany.springbasic1102.jpa.entities.one2one.Boss;
import com.mycompany.springbasic1102.jpa.entities.one2one.Company;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate{
    @Test
    public void t1(){
      Boss boss=new Boss();
      boss.setName("John");
      Company company=new Company();
      company.setName("A公司");
      
      company.setBoss(boss);
      
      session.persist(boss);
      session.persist(company);
        
    }
}
