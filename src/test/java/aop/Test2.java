package aop;

import com.mycompany.springbasic1102.aop.BMI;
import com.mycompany.springbasic1102.aop.Calc;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
      @Test
    public void t2() {
         ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
          BMI bmi=  ctx.getBean("BMIImpl",BMI.class);
          System.out.println(bmi.clac(160.0, 80.0));
    ctx.close();
    }
}
