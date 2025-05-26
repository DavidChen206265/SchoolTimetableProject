import java.util.*;

public class SingleClass {
    private static int currentClassId = 0;
    private int id;
    private String courseCode;
    //private Course blockingCourse;
    private int currentCapacity;
    private int block;
    private ArrayList<Integer> classStudentIdList;

    public SingleClass(String courseCode, int currentCapacity, int block) {
        this.id = currentClassId;
        currentClassId++;
        this.courseCode = courseCode;
        this.currentCapacity = currentCapacity;
        this.block = block;
        this.classStudentIdList = new ArrayList<>();
    } // SingleClass

    public SingleClass(String courseCode, int currentCapacity) {
        this.id = currentClassId;
        currentClassId++;
        this.courseCode = courseCode;
        this.currentCapacity = currentCapacity;
        this.block = -1;
        this.classStudentIdList = new ArrayList<>();
    } // SingleClass

    public SingleClass() {
    }

    public SingleClass(int currentClassId, int id, String courseCode, int currentCapacity, int block, ArrayList<Integer> classStudentIdList) {
        this.currentClassId = currentClassId;
        this.id = id;
        this.courseCode = courseCode;
        this.currentCapacity = currentCapacity;
        this.block = block;
        this.classStudentIdList = classStudentIdList;
    }

    public static int getCurrentClassId() {
        return currentClassId;
    }

    public static void setCurrentClassId(int currentClassId) {
        SingleClass.currentClassId = currentClassId;
    }

    //public SingleClass(String c, Course sc, int b) {
    //    courseCode = c;
    //    blockingCourse = sc;
    //    currentCapacity = c.getMaxEnrollment();
    //    block = b;
    //    classStudentList = new ArrayList<>();
    //} // SingleClass

    // returns true if student can be added to the class, false if class is full
    public boolean addStudent(Student s) {
        if (currentCapacity > 0) {
            classStudentIdList.add(s.getId());
            s.addToClass(this.id, this.block);
            currentCapacity--;
            return true;
        } else {
            return false;
        } // else
    } // addStudent

    // getters & setters

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    //public Course getBlockingCourse() {
    //    return blockingCourse;
    //}

    //public void setBlockingCourse(Course blockingCourse) {
    //    this.blockingCourse = blockingCourse;
    //}

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public ArrayList<Integer> getClassStudentIdList() {
        return classStudentIdList;
    }

    public void setClassStudentIdList(ArrayList<Integer> classStudentIdList) {
        this.classStudentIdList = classStudentIdList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "SingleClass{currentClassId = " + currentClassId + ", id = " + id + ", courseCode = " + courseCode + ", currentCapacity = " + currentCapacity + ", block = " + block + ", classStudentIdList = " + classStudentIdList + "}";
    }
}