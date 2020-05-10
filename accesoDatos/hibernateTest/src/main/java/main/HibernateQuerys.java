package main;

import dao.HibernateUtils;


import org.hibernate.Session;
import org.hibernate.query.Query;
import wizard.test1.Teacher;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class HibernateQuerys {


    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "log4j2.xml");

        Session session = HibernateUtils.getSession();

//        Query q = session.createQuery("from Teacher ");
//        List<Teacher> teachers = q.getResultList();
//        teachers.forEach(teacher -> teacher.getSubjectsByIdteacher().forEach(subject -> subject.getName()));
//        session.close();
//
//        teachers.forEach(teacher -> teacher.getSubjectsByIdteacher().forEach(System.out::println));
//
//        session = HibernateUtils.getSession();
//         q = session.createQuery("select t from Teacher as t inner join t.subjectsByIdteacher as s " +
//                " where s.name = :name " );
//        q.setParameter("name","PSP");
//        Teacher teacher = (Teacher)q.getSingleResult();
//            System.out.println(teacher);
//            teacher.getSubjectsByIdteacher().forEach(System.out::println);
//        session.close();
//
//        session = HibernateUtils.getSession();
//         q = session.createQuery("select s.name from Subject as s   " +
//                " where " +
//                " s.teacherByIdteacher.idteacher = :idTeacher " );
//        q.setParameter("idTeacher",17);
//        q.stream().forEach(System.out::println);
//        session.close();

//        session = HibernateUtils.getSession();
//        q = session.createQuery("select s.name from Subject as s  " +
//                " where " +
//                " s.teacher.start_date > :fecha " );
//        q.setParameter("fecha", LocalDate.now().minus(1, ChronoUnit.YEARS));
//        q.stream().forEach(System.out::println);
//        session.close();
//
//        session = HibernateUtils.getSession();
//        q = session.createQuery("select t,count(s.name) from Subject as s inner join s.teacher as t " +
//                " where " +
//                " t.start_date < :fecha ");
//        q.setParameter("fecha", LocalDate.now().minus(1, ChronoUnit.YEARS));
//        q.stream().forEach(o -> {
//            Object[] result = (Object[])o;
//
//            Arrays.stream(result).forEach(System.out::println);
//
//        });
//        session.close();

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
