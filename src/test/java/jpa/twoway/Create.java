package jpa.twoway;

import com.mycompany.springbasic1102.jpa.entities.twoway.Department;
import com.mycompany.springbasic1102.jpa.entities.twoway.Employee;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate {

    @Test
    public void t1() {
        Department dept = new Department();
        dept.setDname("IT");

        Employee e1 = new Employee();
        e1.setEname("John");

        Employee e2 = new Employee();
        e2.setEname("Mary");

        //建立關係
        e1.setDepartment(dept);
        e2.setDepartment(dept);
        //因為在Department中有設定mappedBy = "department" <--由Employee的department來維護
        //所以下面不用寫
//        dept.getEmployees().add(e1);
//        dept.getEmployees().add(e2);

        //儲存
        session.persist(dept);
        session.persist(e1);
        session.persist(e2);

    }
}
