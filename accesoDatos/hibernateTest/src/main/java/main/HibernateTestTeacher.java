package main;

import dao.HibernateUtils;
import dao.modelo.Subject;
import dao.modelo.Teacher;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HibernateTestTeacher {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        // get Object

        Teacher t = session.get(
                Teacher.class,17);
        //System.out.println(t);
        //t.getSubjects().stream().findFirst().get().getName();
        session.close();
        t.getSubjects().forEach(System.out::println);

        session = HibernateUtils.getSession();
        Subject s = session.get(
                Subject.class,9);
        System.out.println(s);
        s.getTeacher().getStart_date();
        session.close();
        System.out.println(s.getTeacher());

        s.getTeacher().setStart_date(LocalDate.now().plus(10, ChronoUnit.DAYS));
        s.setName("llll");
        session = HibernateUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(s.getTeacher());
        session.save(s);

        s.getTeacher().getStart_date();
        session.getTransaction().commit();
        session.close();

        System.out.println(s);

    }
}
