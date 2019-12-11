package main;

import dao.HibernateUtils;
import dao.modelo.Subject;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

public class HibernateTest {

    public static void main(String[] args) {

        Session session = HibernateUtils.getSession();
        // get Object

        Subject s = session.get(
                Subject.class,9);
        System.out.println(s);

        session.close();

        Subject s1 = new Subject();
        //s1.setIdsubject(5);
        s1.setName("kkkk");
        //s1.setIdteacher(17);
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(s1);
        session.getTransaction().commit();
        session.close();
        System.out.println(s1);

        //s1 = new Subject();
        //s1.setIdsubject(5);
        s1.setName("jjj");
        //s1.setIdteacher(17);

        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(s1);
        session.getTransaction().commit();
        session.close();


        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(s1);
        session.getTransaction().commit();
        session.close();

        System.out.println(s1);


        Subject s2 = new Subject();
        s2.setIdsubject(45);
        s2.setName("kkkk");
        //s2.setIdteacher(47);
        session = HibernateUtils.getSession();

        try {
            session.beginTransaction();


            session.save(s2);
            session.getTransaction().commit();
        }
        catch (ConstraintViolationException e)
        {
            System.out.println("error de pk o fk "
                    +e.getMessage()+" "+e.getConstraintName() + " "
            +e.getCause().getMessage());
            session.getTransaction().rollback();
        }
        catch (Exception e)
        {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        System.out.println(s2);



    }
}
