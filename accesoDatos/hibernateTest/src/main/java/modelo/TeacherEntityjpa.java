package modelo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "teacher", schema = "test", catalog = "")
public class TeacherEntityjpa {
  private int idteacher;
  private String type;
  private Date startdate;
  private Collection<TeachEntityjpa> teachesByIdteacher;

  @Id
  @Column(name = "idteacher", nullable = false)
  public int getIdteacher() {
    return idteacher;
  }

  public void setIdteacher(int idteacher) {
    this.idteacher = idteacher;
  }

  @Basic
  @Column(name = "type", nullable = false, length = 45)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Basic
  @Column(name = "startdate", nullable = false)
  public Date getStartdate() {
    return startdate;
  }

  public void setStartdate(Date startdate) {
    this.startdate = startdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TeacherEntityjpa that = (TeacherEntityjpa) o;

    if (idteacher != that.idteacher) {
      return false;
    }
    if (type != null ? !type.equals(that.type) : that.type != null) {
      return false;
    }
    if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = idteacher;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "teacherByIdteacher")
  public Collection<TeachEntityjpa> getTeachesByIdteacher() {
    return teachesByIdteacher;
  }

  public void setTeachesByIdteacher(Collection<TeachEntityjpa> teachesByIdteacher) {
    this.teachesByIdteacher = teachesByIdteacher;
  }
}
