package uni;

import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);
        if (presentedCourse != null && presentedCourse.studentIDs.contains(this.studentID)) {
            this.transcript.put(presentedCourseID, grade);
        } else {
            System.out.println("دانشجو در این درس ثبت‌نام نکرده است.");
        }
    }

    public void printTranscript() {
        System.out.println("Transcript for student ID: " + this.studentID);
        Person student = Person.findByID(this.studentID);
        if (student != null) {
            System.out.println("Student Name: " + student.name);
        }
        for (Integer courseID : this.transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.courseID);
                if (course != null) {
                    System.out.println("Course: " + course.title + ", Grade: " + this.transcript.get(courseID));
                }
            }
        }
    }

    public double getGPA() {
        double totalGrades = 0;
        int totalUnits = 0;
        for (Integer courseID : this.transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.courseID);
                if (course != null) {
                    totalGrades += this.transcript.get(courseID) * course.units;
                    totalUnits += course.units;
                }
            }
        }
        return totalUnits != 0 ? totalGrades / totalUnits : 0;
    }
}
