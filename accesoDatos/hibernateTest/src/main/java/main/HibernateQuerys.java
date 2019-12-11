package main;

import dao.HibernateUtils;
import dao.modelo.Subject;
import dao.modelo.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateQuerys {


    public static void main(String[] args) {
        Session session = HibernateUtils.getSession();
        Query q = session.createQuery("select t from Teacher as t inner join t.subjects as s " +
                " where s.name = :name " );
        q.setParameter("name","PSP");
        List<Teacher> teachers = q.list();
        teachers.forEach(teacher -> {
            System.out.println(teacher);
            teacher.getSubjects().forEach(System.out::println);

        });
        session.close();

        session = HibernateUtils.getSession();
         q = session.createQuery("select s.name from Subject as s  " +
                " where " +
                "s.teacher.idteacher = :idTeacher " );
        q.setParameter("idTeacher",18);
        q.stream().forEach(System.out::println);
        session.close();




    }
}
