package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        this.id = studentList.size() + 1;
        Major.findById(majorID).addStudent();
        this.setStudentCode();
        studentList.add(this);
    }

    public static Student findById(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public void setStudentCode() {
        this.studentID = this.entranceYear + "" + this.majorID + "0" + (Major.findById(this.majorID).numberOfstudents);
    }
}