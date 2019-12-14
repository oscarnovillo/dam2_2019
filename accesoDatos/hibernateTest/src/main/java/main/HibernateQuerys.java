package main;

import dao.HibernateUtils;

import dao.modelo.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HibernateQuerys {


    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();

        Query q = session.createQuery("select t from Teacher as t inner join t.subjects as s " +
                " where s.name = :name " );
        q.setParameter("name","PSP");
        Teacher teacher = (Teacher)q.getSingleResult();
            System.out.println(teacher);
            teacher.getSubjects().forEach(System.out::println);
        session.close();

        session = HibernateUtils.getSession();
         q = session.createQuery("select s.name from Subject as s   " +
                " where " +
                " s.teacher.idteacher = :idTeacher " );
        q.setParameter("idTeacher",17);
        q.stream().forEach(System.out::println);
        session.close();

        session = HibernateUtils.getSession();
        q = session.createQuery("select s.name from Subject as s  " +
                " where " +
                " s.teacher.start_date > :fecha " );
        q.setParameter("fecha", LocalDate.now().minus(1, ChronoUnit.YEARS));
        q.stream().forEach(System.out::println);
        session.close();

        session = HibernateUtils.getSession();
        q = session.createQuery("select new list(t,count(s.name)) from Subject as s inner join s.teacher as t " +
                " where " +
                " t.start_date < :fecha ");
        q.setParameter("fecha", LocalDate.now().minus(1, ChronoUnit.YEARS));
        q.stream().forEach(o -> {
            List result = (List)o;
            result.stream().forEach(System.out::println);

        });
        session.close();

//        session = HibernateUtils.getSession();
//        q = session.createNativeQuery("select count(s.name) from subject as s inner join teacher as t on s.idteacher = t.idteacher " +
//                " where " +
//                " t.start_date > :fecha " );
//        q.setParameter("fecha", LocalDate.now().minus(1, ChronoUnit.YEARS));
//        q.stream().forEach(System.out::println);
//        session.close();
//
//
//        session = HibernateUtils.getSession();
//        q = session.createQuery("select count(s.name) as count from Subject as s inner join s.teacher as t " +
//        " group by t " );
//        q.stream().forEach(o -> System.out.println(o));
//        session.close();


    }
}
