package jdbc.tx;

import com.mycompany.springbasic1102.jdbc.tx.exception.InsufficientAmount;
import com.mycompany.springbasic1102.jdbc.tx.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tx2 {
 @Test   
    public void Tx2(){
      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
       BookService bookService=ctx.getBean("bookServiceImpl",BookService.class);
   int bid=1; int wid=1;
     try {
            bookService.buyOne(wid, bid);
     } catch (InsufficientAmount e) {
         System.out.println("交易失敗");
         System.out.println(e);        
     }
  
    }
   
}
