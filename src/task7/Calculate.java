package task7;

import task6.Indexes;
import java.util.Arrays;

public class Calculate {

    public void print(Student[] s) {
        Arrays.stream(s).forEach(student -> System.out.println("Student: " + student.getNumber() + " next Student: " + student.getStudent().getNumber()));
    }

    private int getStudentNumber(int i, Student[] students) {
        return students[i].getNumber();
    }

    private int getNextStudentNumber(int i, Student[] students) {
        return students[i].getStudent().getNumber();
    }

    private Student[] copyArray(Student[] ws) {
        return Arrays.copyOf(ws, ws.length + 1);
    }
    private int[] copyArray(int[] ws) {
        return Arrays.copyOf(ws, ws.length + 1);
    }

    public Indexes getStudentIndex(Student[] students) {
        int[] nextStudentList = new int[0];
        int[] studentNumbersList = new int[students.length];
        Student[] wrongStudents = new Student[0];
        for (int i = 0; i < students.length; i++) {
            int nextStudentNumber = getNextStudentNumber(i, students);
            int studentNumber = getStudentNumber(i, students);
            studentNumbersList[i] = studentNumber;
            boolean isFall = false;
            for (int k : nextStudentList) {
                if (nextStudentNumber == k) {
                    wrongStudents = copyArray(wrongStudents);
                    wrongStudents[wrongStudents.length - 1] = students[i];
                    isFall = true;
                    break;
                }
            }
            if (studentNumber == nextStudentNumber) {
                wrongStudents = copyArray(wrongStudents);
                wrongStudents[wrongStudents.length - 1] = students[i];
            } else if(!isFall) {
                nextStudentList = copyArray(nextStudentList);
                nextStudentList[nextStudentList.length - 1] = nextStudentNumber;
            }
        }
        if (wrongStudents.length > 1) {
            return new Indexes();
        } else {
            int sumNextNumbers = Arrays.stream(nextStudentList).sum();
            int sumNumbers = Arrays.stream(studentNumbersList).sum();
            Indexes res = new Indexes();
            res.setFirstIndex(wrongStudents[0].getNumber());
            res.setSecondIndex(sumNumbers - sumNextNumbers);
            return res;
        }
    }
}
