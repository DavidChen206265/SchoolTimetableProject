import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private int id;
    private ArrayList<String> requestedChosenCourseCodeList;
    private ArrayList<String> requestedAlternativeCourseCodeList;
    private int[] currentClassIdArray;

    public Student(int id, ArrayList<String> requestedChosenCourseCodeList, ArrayList<String> requestedAlternativeCourseCodeList) {
        this.id = id;
        this.requestedChosenCourseCodeList = requestedChosenCourseCodeList;
        this.requestedAlternativeCourseCodeList = requestedAlternativeCourseCodeList;
        this.currentClassIdArray = new int[8];
        Arrays.fill(currentClassIdArray, -1);
    }

    public Student() {
    }

    public Student(int id, ArrayList<String> requestedChosenCourseCodeList, ArrayList<String> requestedAlternativeCourseCodeList, int[] currentClassIdArray) {
        this.id = id;
        this.requestedChosenCourseCodeList = requestedChosenCourseCodeList;
        this.requestedAlternativeCourseCodeList = requestedAlternativeCourseCodeList;
        this.currentClassIdArray = currentClassIdArray;
    }

    public void addToClass(int classId, int block) {
        currentClassIdArray[block] = classId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRequestedChosenCourseCodeList(ArrayList<String> requestedChosenCourseCodeList) {
        this.requestedChosenCourseCodeList = requestedChosenCourseCodeList;
    }

    public ArrayList<String> getRequestedChosenCourseCodeList() {
        return requestedChosenCourseCodeList;
    }

    public void setRequestedAlternativeCourseCodeList(ArrayList<String> requestedAlternativeCourseCodeList) {
        this.requestedAlternativeCourseCodeList = requestedAlternativeCourseCodeList;
    }

    public ArrayList<String> getRequestedAlternativeCourseCodeList() {
        return requestedAlternativeCourseCodeList;
    }

    public int[] getCurrentClassIdArray() {
        return currentClassIdArray;
    }

    public void setCurrentClassIdArray(int[] currentClassIdArray) {
        this.currentClassIdArray = currentClassIdArray;
    }

    public String toString() {
        return "Student{id = " + id + ", requestedChosenCourses = " + requestedChosenCourseCodeList + ", requestedAlternativeCourses = " + requestedAlternativeCourseCodeList + ", currentClasses = " + currentClassIdArray + "}";
    }

}
