package wizard.modelo;

import javax.persistence.*;

@Entity
@Table(name = "teach", schema = "test", catalog = "")
public class TeachEntityjpa {
  private int idteach;
  private TeacherEntityjpa teacherByIdteacher;
  private SubjectEntityjpa subjectByIdsubject;

  @Id
  @Column(name = "idteach", nullable = false)
  public int getIdteach() {
    return idteach;
  }

  public void setIdteach(int idteach) {
    this.idteach = idteach;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TeachEntityjpa that = (TeachEntityjpa) o;

    if (idteach != that.idteach) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return idteach;
  }

  @ManyToOne
  @JoinColumn(name = "idteacher", referencedColumnName = "idteacher", nullable = false)
  public TeacherEntityjpa getTeacherByIdteacher() {
    return teacherByIdteacher;
  }

  public void setTeacherByIdteacher(TeacherEntityjpa teacherByIdteacher) {
    this.teacherByIdteacher = teacherByIdteacher;
  }

  @ManyToOne
  @JoinColumn(name = "idsubject", referencedColumnName = "idsubject", nullable = false)
  public SubjectEntityjpa getSubjectByIdsubject() {
    return subjectByIdsubject;
  }

  public void setSubjectByIdsubject(SubjectEntityjpa subjectByIdsubject) {
    this.subjectByIdsubject = subjectByIdsubject;
  }
}
