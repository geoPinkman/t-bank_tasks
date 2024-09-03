package task7;

public class Student {

    private int number;
    private Student student;

    public Student() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", student=" + student.number +
                '}';
    }
}
