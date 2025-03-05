package uni;

import java.util.ArrayList;

public class Course {
    public int id;
    public static ArrayList<Course> courseList = new ArrayList<>();
    public String title;
    public int units;

    public Course(String title, int units) {
        this.title = title;
        this.units = units;
        this.id = courseList.size() + 1;
        courseList.add(this);
    }

    public static Course findByID(int id) {
        for (Course course : courseList) {
            if (course.id == id) {
                return course;
            }
        }
        return null;
    }
}
