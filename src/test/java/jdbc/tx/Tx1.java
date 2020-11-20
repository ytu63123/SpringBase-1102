package jdbc.tx;

import com.mycompany.springbasic1102.jdbc.tx.dao.BookDAO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tx1 {
    @Test
    public void t1(){
      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        BookDAO bookDAO=ctx.getBean("bookDaoImpl",BookDAO.class);
        System.out.println(bookDAO);
        //bid=1的書籍價格
        int bid=1; int wid=1;
        int price=bookDAO.getPrice(bid);
        //進行交易
        System.out.println("交易開始");
        bookDAO.updateStock(bid);
      //  bookDAO.updateWallet(wid, price);
        System.out.println("交易完成");
    }
}
