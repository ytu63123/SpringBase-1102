package di;

import com.mycompany.springbasic1102.di.bytype.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Emp {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config-2.xml");
        Emp emp = ctx.getBean("emp", Emp.class);
        System.out.println(emp);
        Emp emp2 = ctx.getBean("emp2", Emp.class);
        System.out.println(emp2);
         Emp emp3 =ctx.getBean("emp3",Emp.class);
        System.out.println(emp3);
        ctx.close();
    }
}
