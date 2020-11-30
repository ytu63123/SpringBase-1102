package jpa.one2many;

import com.mycompany.springbasic1102.jpa.entities.one2many.Book;
import com.mycompany.springbasic1102.jpa.entities.one2many.Bookshelf;
import java.util.Date;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate {

    @Test
    public void t1() {
        Book b1 = new Book();
        b1.setBname("Andriod雲端");
        b1.setPrice(50);
        b1.setCt(new Date());
        
        Book b2 = new Book();
        b2.setBname("Andriod穿戴式");
        b2.setPrice(150);
        b2.setCt(new Date());
        
        Bookshelf bookshelf=new Bookshelf();
        bookshelf.setName("App類");
        
        //建立關聯關係
        bookshelf.getBooks().add(b1);
        bookshelf.getBooks().add(b2);
       
        //儲存 //OneToMany 單向統一最後都會Update 外鍵資料 Bookshelf_id
        //下面兩種都可
//        session.persist(bookshelf);
//        session.persist(b1);
//        session.persist(b2);
        
        session.persist(bookshelf);
        session.persist(b1);
        session.persist(b2);
        System.out.println("完成");
    }
}
