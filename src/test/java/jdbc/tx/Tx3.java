package jdbc.tx;

import com.mycompany.springbasic1102.jdbc.tx.controller.BookController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tx3 {

    @Test
    public void Tx3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        BookController bookController = ctx.getBean("bookControllerImpl", BookController.class);
        int wid = 1;
        int bid = 1;
        bookController.buyBook(wid, bid);

    }
}
