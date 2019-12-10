package main;

import dao.HibernateUtils;
import dao.modelo.EntitySubject;
import org.hibernate.Session;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        // get Object

        EntitySubject s = session.get(
                EntitySubject.class,9);
        System.out.println(s);

        session.close();

        EntitySubject s1 = new EntitySubject();
        //s1.setIdsubject(5);
        s1.setName("kkkk");
        s1.setIdteacher(17);
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(s1);
        session.getTransaction().commit();
        session.close();
        System.out.println(s1);









    }
}
