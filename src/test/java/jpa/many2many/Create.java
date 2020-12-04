package jpa.many2many;

import com.mycompany.springbasic1102.jpa.entities.many2many.Cstock;
import com.mycompany.springbasic1102.jpa.entities.many2many.Fund;
import jpa.JPATemplate;
import org.junit.Test;

public class Create extends JPATemplate {

    @Test
    public void t1() {
        Cstock c1 = new Cstock("2330.TW");
        Cstock c2 = new Cstock("2317.TW");
        Cstock c3 = new Cstock("3008.TW");
        Cstock c4 = new Cstock("1101.TW");

        Fund f1 = new Fund("A基金");

        f1.getCstocks().add(c1);
        f1.getCstocks().add(c3);


        session.persist(f1);

    }
}
