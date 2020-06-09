package wizard.test1;



import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subject {
  private int idsubject;
  private String name;
  private Teacher teacherByIdteacher;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idsubject", nullable = false)
  public int getIdsubject() {
    return idsubject;
  }

  public void setIdsubject(int idsubject) {
    this.idsubject = idsubject;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 45)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subject subject = (Subject) o;
    return idsubject == subject.idsubject &&
        Objects.equals(name, subject.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idsubject, name);
  }

  @ManyToOne
  @JoinColumn(name = "idteacher", referencedColumnName = "idteacher", nullable = false)
  public Teacher getTeacherByIdteacher() {
    return teacherByIdteacher;
  }
  public void setTeacherByIdteacher(Teacher teacherByIdteacher) {
    this.teacherByIdteacher = teacherByIdteacher;
  }
}
