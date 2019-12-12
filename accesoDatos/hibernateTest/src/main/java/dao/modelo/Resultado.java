package dao.modelo;

public class Resultado {

    private Teacher teacher;
    private int count;

    public Resultado() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "teacher=" + teacher.toString() +
                ", count=" + count +
                '}';
    }
}

