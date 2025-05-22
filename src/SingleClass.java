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
        students = new ArrayList<>();
    } // SingleClass

    public SingleClass(Course c, Course sc, int maxStudent, int b) {
        course = c;
        simultaneousCourse = sc;
        currentCapacity = maxStudent;
        block = b;
        students = new ArrayList<>();
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


    /**
     * 获取
     * @return course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * 设置
     * @param course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * 获取
     * @return simultaneousCourse
     */
    public Course getSimultaneousCourse() {
        return simultaneousCourse;
    }

    /**
     * 设置
     * @param simultaneousCourse
     */
    public void setSimultaneousCourse(Course simultaneousCourse) {
        this.simultaneousCourse = simultaneousCourse;
    }

    /**
     * 获取
     * @return currentCapacity
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * 设置
     * @param currentCapacity
     */
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    /**
     * 获取
     * @return block
     */
    public int getBlock() {
        return block;
    }

    /**
     * 设置
     * @param block
     */
    public void setBlock(int block) {
        this.block = block;
    }

    /**
     * 获取
     * @return students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * 设置
     * @param students
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String toString() {
        return "SingleClass{course = " + course + ", simultaneousCourse = " + simultaneousCourse + ", currentCapacity = " + currentCapacity + ", block = " + block + ", students = " + students + "}";
    }
}