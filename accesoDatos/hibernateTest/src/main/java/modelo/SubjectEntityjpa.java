package modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject", schema = "test", catalog = "")
public class SubjectEntityjpa {
  private int idsubject;
  private String name;
  private Collection<EnrolledEntityjpa> enrolledsByIdsubject;
  private Collection<TeachEntityjpa> teachesByIdsubject;

  @Id
  @Column(name = "idsubject", nullable = false)
  public int getIdsubject() {
    return idsubject;
  }

  public void setIdsubject(int idsubject) {
    this.idsubject = idsubject;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 45)
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

    SubjectEntityjpa that = (SubjectEntityjpa) o;

    if (idsubject != that.idsubject) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = idsubject;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "subjectByIdsubject")
  public Collection<EnrolledEntityjpa> getEnrolledsByIdsubject() {
    return enrolledsByIdsubject;
  }

  public void setEnrolledsByIdsubject(Collection<EnrolledEntityjpa> enrolledsByIdsubject) {
    this.enrolledsByIdsubject = enrolledsByIdsubject;
  }

  @OneToMany(mappedBy = "subjectByIdsubject")
  public Collection<TeachEntityjpa> getTeachesByIdsubject() {
    return teachesByIdsubject;
  }

  public void setTeachesByIdsubject(Collection<TeachEntityjpa> teachesByIdsubject) {
    this.teachesByIdsubject = teachesByIdsubject;
  }
}
