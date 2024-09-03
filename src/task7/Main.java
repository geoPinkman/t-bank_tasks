package task7;

public class Main {
    public static void main(String[] args) {
        Student s0 = new Student();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();

        s0.setNumber(1);
        s1.setNumber(2);
        s2.setNumber(3);
        s3.setNumber(4);
        s4.setNumber(5);

        s0.setStudent(s0);
        s1.setStudent(s4);
        s2.setStudent(s3);
        s3.setStudent(s0);
        s4.setStudent(s2);

        Student[] students = new Student[5];
        students[0] = s0;
        students[1] = s1;
        students[2] = s2;
        students[3] = s3;
        students[4] = s4;

        Calculate c = new Calculate();
        c.print(students);
        System.out.println(c.getStudentIndex(students));
    }
}
