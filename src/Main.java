
import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Major major1 = new Major("Computer Science", 30);
        Major major2 = new Major("Mathematics", 50);

        Person person1 = new Person("Shirin", "001");
        Person person2 = new Person("Maryam", "002");
        Person person3 = new Person("Zhina", "003");
        Person person4 = new Person("Niloofar", "004");
        Person person5 = new Person("Shamila", "005");

        Student student1 = new Student(person1.id, 403, major1.id);
        Student student2 = new Student(person2.id, 403, major1.id);
        Student student3 = new Student(person3.id, 403, major2.id);

        for (Student student : Student.studentList) {
            System.out.println("Name: " + Person.findByID(student.personID).name + ", Student ID: " + student.studentID);
        }

        Professor professor1 = new Professor(person4.id, major1.id);
        Professor professor2 = new Professor(person5.id, major2.id);


        for (Professor professor : Professor.professorsList) {
            System.out.println("Name: " + Person.findByID(professor.personID).name + ", Professor ID: " + professor.id);
        }

        Course course1 = new Course("Advanced Programming", 3);
        Course course2 = new Course("Data Structures", 3);
        Course course3 = new Course("Algorithms", 3);

        PresentedCourse presentedCourse1 = new PresentedCourse(course1.id, professor1.id, 25);
        PresentedCourse presentedCourse2 = new PresentedCourse(course2.id, professor1.id, 25);
        PresentedCourse presentedCourse3 = new PresentedCourse(course3.id, professor2.id, 25);

        presentedCourse1.addStudent(student1.id);
        presentedCourse1.addStudent(student2.id);
        presentedCourse2.addStudent(student1.id);
        presentedCourse2.addStudent(student2.id);
        presentedCourse2.addStudent(student3.id);
        presentedCourse3.addStudent(student3.id);

        Transcript transcript1 = new Transcript(student1.id);
        transcript1.setGrade(presentedCourse1.id, 18.5);
        transcript1.setGrade(presentedCourse2.id, 17.0);

        Transcript transcript2 = new Transcript(student2.id);
        transcript2.setGrade(presentedCourse1.id, 19.0);
        transcript2.setGrade(presentedCourse2.id, 18.5);

        Transcript transcript3 = new Transcript(student3.id);
        transcript3.setGrade(presentedCourse2.id, 16.0);
        transcript3.setGrade(presentedCourse3.id, 15.5);

        transcript1.printTranscript();
        System.out.println("GPA: " + transcript1.getGPA());

        transcript2.printTranscript();
        System.out.println("GPA: " + transcript2.getGPA());

        transcript3.printTranscript();
        System.out.println("GPA: " + transcript3.getGPA());
        }
    }
