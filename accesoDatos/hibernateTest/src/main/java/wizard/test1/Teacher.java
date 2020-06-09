package wizard.test1;

import wizard.dao2.SubjectTest;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Teacher {
  private int idteacher;
  private Date startDate;
  private Collection<Subject> subjectsByIdteacher;
  private Members membersByIdteacher;


  @Id
  @Column(name = "idteacher", nullable = false)
  public int getIdteacher() {
    return idteacher;
  }

  public void setIdteacher(int idteacher) {
    this.idteacher = idteacher;
  }

  @Basic
  @Column(name = "start_date", nullable = true)
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Teacher teacher = (Teacher) o;
    return idteacher == teacher.idteacher &&
        Objects.equals(startDate, teacher.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idteacher, startDate);
  }

  @OneToOne
  @JoinColumn(name = "idteacher", referencedColumnName = "idmember", nullable = false)
  public Members getMembersByIdteacher() {
    return membersByIdteacher;
  }

  public void setMembersByIdteacher(Members membersByIdteacher) {
    this.membersByIdteacher = membersByIdteacher;
  }

  @OneToMany(mappedBy = "teacherByIdteacher")
  public Collection<Subject> getSubjectsByIdteacher() {
    return subjectsByIdteacher;
  }

  public void setSubjectsByIdteacher(Collection<Subject> subjectsByIdteacher) {
    this.subjectsByIdteacher = subjectsByIdteacher;
  }

}
