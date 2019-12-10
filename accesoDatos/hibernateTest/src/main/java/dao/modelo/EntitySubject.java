package dao.modelo;


import javax.persistence.*;

@Entity
@Table(name = "subject")
public class EntitySubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idsubject;
    private int idteacher;
    private String name;

    public EntitySubject() {
    }

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    public int getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(int idteacher) {
        this.idteacher = idteacher;
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
                ", idteacher=" + idteacher +
                ", name='" + name + '\'' +
                '}';
    }
}
