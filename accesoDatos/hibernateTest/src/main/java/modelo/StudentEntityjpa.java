package modelo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "student")
@SecondaryTable(name = "member", pkJoinColumns = @PrimaryKeyJoinColumn(name = "idmember", referencedColumnName = "idstudent"))
public class StudentEntityjpa extends MemberEntityjpa{
  private int idstudent;
  private Date schoolYear;
  private Collection<EnrolledEntityjpa> enrolledsByIdstudent;

  @Id
  @Column(name = "idstudent", nullable = false)
  public int getIdstudent() {
    return idstudent;
  }

  public void setIdstudent(int idstudent) {
    this.idstudent = idstudent;
  }

  @Basic
  @Column(name = "schoolYear", nullable = false)
  public Date getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Date schoolYear) {
    this.schoolYear = schoolYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    StudentEntityjpa that = (StudentEntityjpa) o;

    if (idstudent != that.idstudent) {
      return false;
    }
    if (schoolYear != null ? !schoolYear.equals(that.schoolYear) : that.schoolYear != null) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "StudentEntityjpa{" +
        "idstudent=" + idstudent +
        ", schoolYear=" + schoolYear +

        "} " + super.toString();
  }

  @Override
  public int hashCode() {
    int result = idstudent;
    result = 31 * result + (schoolYear != null ? schoolYear.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "studentByIdstudient")
  public Collection<EnrolledEntityjpa> getEnrolledsByIdstudent() {
    return enrolledsByIdstudent;
  }

  public void setEnrolledsByIdstudent(Collection<EnrolledEntityjpa> enrolledsByIdstudent) {
    this.enrolledsByIdstudent = enrolledsByIdstudent;
  }
}
