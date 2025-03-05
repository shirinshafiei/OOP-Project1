package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIDs;

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        this.studentIDs = new ArrayList<>();
        this.id = presentedCourseList.size() + 1;
        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int id) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == id) {
                return presentedCourse;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (this.studentIDs.size() < this.capacity) {
            this.studentIDs.add(studentID);
        } else {
            System.out.println("ظرفیت درس پر است.");
        }
    }
}
