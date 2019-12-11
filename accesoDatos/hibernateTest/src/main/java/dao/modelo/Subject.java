package dao.modelo;


import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsubject;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idteacher", referencedColumnName = "idteacher")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject() {
    }

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idsubject=" + idsubject +
                ", name='" + name + '\'' +
                '}';
    }
}
