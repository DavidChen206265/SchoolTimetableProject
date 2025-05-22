import java.util.*;

public class SingleClass {
    private Course course;
    private Course simultaneousCourse;
    private int currentCapacity;
    private int block;
    private ArrayList<Student> students;

    public SingleClass(Course c, int maxStudent, int b) {
        course = c;
        simultaneousCourse = null;
        currentCapacity = maxStudent;
        block = b;
        students = new ArrayList();
    } // SingleClass

    public SingleClass(Course c, Course sc, int maxStudent, int b) {
        course = c;
        simultaneousCourse = sc;
        currentCapacity = maxStudent;
        block = b;
        students = new ArrayList();
    } // SingleClass

    // returns true if student can be added to the class, false if class is full
    public boolean addStudent(Student s) {
        if(currentCapacity > 0) {
            students.add(s);
            currentCapacity--;
            return true;
        } else {
            return false;
        } // else
    } // addStudent
}