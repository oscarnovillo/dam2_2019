package wizard.dao;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    private int idstudent;
    private Integer schoolYear;

    @Id
    @Column(name = "idstudent", nullable = false)
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    @Basic
    @Column(name = "school_year", nullable = true)
    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idstudent != student.idstudent) return false;
        if (schoolYear != null ? !schoolYear.equals(student.schoolYear) : student.schoolYear != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idstudent;
        result = 31 * result + (schoolYear != null ? schoolYear.hashCode() : 0);
        return result;
    }
}
