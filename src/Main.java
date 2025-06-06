import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;




public class Main {

    private static Map<String, Course> courseMap = new HashMap<>();
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        readInCourseData();
        //readInSequencingData();
        //readInBlockingData();
        readInStudentData();

        Timetable t = generateRandomTimetable();
        evaluateTimetable(t, studentList);
        storeTimetableintoJson(t);
    }

    private static void storeTimetableintoJson(Timetable t) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedWriter bw;


        for(Block b : t.getBlocks()){
            String json = mapper.writeValueAsString(b);
            bw = new BufferedWriter(new FileWriter("MasterTimetable.json"));
            System.out.println(json.length());
            bw.write(json);
        }
    }

    private static void showStudentTimetable(Timetable t, int studentId){

        studentId -= 1000;

        String[] timetableCourseCode = new String[8];

        for (int i = 0; i < t.getBlocks().length; i++) {
            Block b = t.getBlocks()[i];
            for (SingleClass c : b.getClasses()) {
                if(c.getClassStudentIdList().contains(studentId)) {
                    timetableCourseCode[i] = c.getCourseCode();
                }
            }
        }

        System.out.println("[S1A       ,S1B       ,S1C       ,s1D       ,S2A       ,S2B       ,S2C       ,s2D       ]");
        System.out.println(Arrays.toString(timetableCourseCode));

    }

    private static void evaluateTimetable(Timetable t, ArrayList<Student> studentListE) {
        int fulfilledCourses;
        int[] arr = new int[9];
        int totalFulfilled = 0;

        for(Student s : studentListE) {
            fulfilledCourses = 0;
            for(int id : s.getCurrentClassIdArray()) {
                for(SingleClass c : t.getAllClasses()){
                    if (c.getId() == id && s.getRequestedChosenCourseCodeList().contains(c.getCourseCode())){
                        fulfilledCourses++;
                    }
                }
            }
            arr[fulfilledCourses]++;
            totalFulfilled += fulfilledCourses;
        }

        System.out.println("------- % Of Requested Courses Placed -------");
        System.out.println((double)totalFulfilled / (8 * studentList.size()) * 100 +"%");

        System.out.println("------- % Of Students With 8/8 -------");
        System.out.println((double) arr[8] / studentList.size() * 100 +"%");

        System.out.println("------- % Of Students With 7-8/8 -------");
        System.out.println((double) (arr[8] + arr[7]) / studentList.size() * 100 +"%");
    }

    private static int evaluateTimetableBonus(Timetable t) {
        int fulfilledCourses;
        int[] arr = new int[9];

        for(Student s : studentList) {
            fulfilledCourses = 0;
            for(int id : s.getCurrentClassIdArray()) {
                for(SingleClass c : t.getAllClasses()){
                    if (c.getId() == id && (s.getRequestedChosenCourseCodeList().contains(c.getCourseCode()) || s.getRequestedAlternativeCourseCodeList().contains(c.getCourseCode()))){
                        fulfilledCourses++;
                    }
                }
            }
            arr[fulfilledCourses]++;
        }

        return (arr[8] + arr[7]);
    }

    private static void readInCourseData() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("data_course.csv"));
        String[] fileContent = br.lines().toArray(String[]::new);
        String[] lineContent;

        for (int row = 0; row < fileContent.length; row++) {

            lineContent = fileContent[row].split(",");
            courseMap.put(lineContent[0], new Course(
                    lineContent[0],
                    lineContent[1],
                    Integer.parseInt(lineContent[2]),
                    Integer.parseInt(lineContent[3]),
                    Integer.parseInt(lineContent[4]),
                    Integer.parseInt(lineContent[5])
            ));

        } // for

    } // readInCourseData

    private static void readInSequencingData() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("data_sequencing.csv"));
        String[] fileContent = br.lines().toArray(String[]::new);
        String courseCode;
        String[] sequencingCourseCodes;

        for (int row = 0; row < fileContent.length; row++) {
            courseCode = fileContent[row].substring(0, 10);
            sequencingCourseCodes = fileContent[row].substring(18).split(",");

            try {

                for (String sequencingCourseCode : sequencingCourseCodes) {
                    courseMap.get(sequencingCourseCode).addSequencingCourse(courseCode);
                }

            } catch (Exception e) {
                System.out.println("Error on line: " + (row + 1) + " of data_sequencing.csv");
            }

        } // for

    } // readInSequencingData

    private static void readInBlockingData() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("data_blocking.csv"));
        String[] fileContent = br.lines().toArray(String[]::new);
        String[] blockingCourseCodes;

        for (int row = 0; row < fileContent.length; row++) {
            blockingCourseCodes = fileContent[row].split(",");

            try {

                for (String courseCode : blockingCourseCodes) {

                    Course c = courseMap.get(courseCode);
                    for (String blockingCourseCode : blockingCourseCodes) {
                        if (!courseCode.equals(blockingCourseCode))
                            c.addBlockingCourse(blockingCourseCode);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error on line: " + (row + 1) + " of data_blocking.csv");
            }

        } // for

    } // readInBlockingData

    private static void readInStudentData() throws FileNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("data_student.csv"));
        String[] fileContent = br.lines().toArray(String[]::new);
        String[] lineContent;

        int id = 0;
        String courseCode;
        for (int row = 0; row < fileContent.length; row++) {

            ArrayList<String> requestedChosenCourseCodeList = new ArrayList<>();
            ArrayList<String> requestedAlternativeCourseCodeList = new ArrayList<>();

            while (!fileContent[row].startsWith("/")) {

                try {
                    lineContent = fileContent[row].split(",");
                    courseCode = lineContent[0];
                    if (lineContent[1].equals("Y")) {
                        requestedAlternativeCourseCodeList.add(courseCode);
                        courseMap.get(courseCode).addWaitingStudent(id, false);
                    } else {
                        requestedChosenCourseCodeList.add(courseCode);
                        courseMap.get(courseCode).addWaitingStudent(id, true);
                    }
                } catch (Exception e) {
                    //System.out.println("Error on line: " + (row + 1) + " of data_student.csv");
                }

                row++;
            } // while

            studentList.add(new Student(id, requestedChosenCourseCodeList, requestedAlternativeCourseCodeList));
            id++;
        } // for
    } // readInStudentData

    private static Timetable generateRandomTimetable() {
        Random r = new Random();

        ArrayList<SingleClass> classList = new ArrayList<>();
        int block;

        for (Course c : courseMap.values()) {
            for (int i = 0; i < c.getSections(); i++) {
                classList.add(new SingleClass(c.getCode(), c.getMaxEnrollment()));
            }
        }
        Timetable t = new Timetable(classList);
        Collections.shuffle(classList);

        for (int i = 0; i < classList.size(); i++) {
            block = i % 8;
            SingleClass sc = classList.get(i);
            t.getBlocks()[block].addClass(sc);

            ArrayList<Integer> waitlist = courseMap.get(sc.getCourseCode()).getWaitlist();
            for (int j = 0; j < waitlist.size(); j++) {
                //if (sc.getCurrentCapacity() == 0) break;

                Student s = studentList.get(waitlist.get(j));
                if (s.getCurrentClassIdArray()[block] == -1){
                    s.getCurrentClassIdArray()[block] = sc.getId();
                    sc.addStudent(s);
                    waitlist.set(j, -1);
                }
            }

            courseMap.get(sc.getCourseCode()).updateWaitlist();

        }

        for (Student s : studentList) {

            for (int i = 0; i < s.getCurrentClassIdArray().length; i++) {
                if (s.getCurrentClassIdArray()[i] == -1) {
                    ArrayList<SingleClass> classes = t.getBlocks()[i].getClasses();
                    for (int j = 0; j < classes.size(); j++) {
                        if (classes.get(j).getCurrentCapacity() > 0) {
                            s.getCurrentClassIdArray()[i] = classes.get(j).getId();
                            classes.get(j).addStudent(s);
                        }
                    }
                }
            }
        }

        return t;
    } // generateRandomTimetable

    private static void outputTimetable(Timetable t){

        try (FileWriter writer = new FileWriter("output_timetable.csv")) {
            // Write CSV headers
            writer.append("S1A,S1B,S1C,S1D,S2A,S2B,S2C,S2D\n");

            // Write data rows
            int counter = 0;
            int maxCount = 0;
            for (Block block : t.getBlocks()) {
                if (block.getClasses().size() > maxCount) maxCount = block.getClasses().size();
            }

            while (counter < maxCount) {
                for (Block block : t.getBlocks()) {
                    if (counter < block.getClasses().size()) writer.append(block.getClasses().get(counter).getCourseCode());
                    writer.append(",");
                }
                writer.append("\n");
                counter++;
            }

            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }

    } // outputTimetable

} // Main