# classDiagram

   ##  class Block 
    {
        -int block
        -ArrayList<SingleClass> classes
        _________________________________________________________________________________________________________________________________________________________
        +Block(int block)
        +Block(int block, ArrayList<SingleClass> classes)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +void addClass(SingleClass c)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +ArrayList<SingleClass> getClasses()
        +void setClasses(ArrayList<SingleClass> classes)
        +int getBlock()
        +void setBlock(int block)
        +String toString()
    }

   ## class Course 
    {
        -String code
        -String name
        -int primary
        -int alternate
        -int maxEnrollment
        -int sections
        -ArrayList<SingleClass> classes
        -ArrayList<String> sequencingCourseCodeList
        -ArrayList<String> blockingCourseCodeList
        -ArrayList<Integer> waitlist
        _________________________________________________________________________________________________________________________________________________________
        +Course()
        +Course(String code, String name, int primary, int alternate, int maxEnrollment, int sections)
        +Course(String code, String name, int primary, int alternate, int maxEnrollment, int sections, ArrayList<SingleClass> classes, ArrayList<String> sequencingCourseCodeList, ArrayList<String> blockingCourseCodeList, ArrayList<Integer> waitlist)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +void updateWaitlist()
        +void addClass(SingleClass c)
        +void addSequencingCourse(String c)
        +void addBlockingCourse(String c)
        +void addWaitingStudent(int id, boolean isPrioritized)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +String getCode()
        +void setCode(String code)
        +String getName()
        +void setName(String name)
        +int getPrimary()
        +void setPrimary(int primary)
        +int getAlternate()
        +void setAlternate(int alternate)
        +int getMaxEnrollment()
        +void setMaxEnrollment(int maxEnrollment)
        +int getSections()
        +void setSections(int sections)
        +ArrayList<SingleClass> getClasses()
        +void setClasses(ArrayList<SingleClass> classes)
        +ArrayList<String> getSequencingCourseCodeList()
        +void setSequencingCourseCodeList(ArrayList<String> sequencingCourseCodeList)
        +ArrayList<String> getBlockingCourseCodeList()
        +void setBlockingCourseCodeList(ArrayList<String> blockingCourseCodeList)
        +ArrayList<Integer> getWaitlist()
        +void setWaitlist(ArrayList<Integer> waitlist)
        +String toString()
    }

   ## class Main 
    {
        -static Map<String, Course> courseMap
        -static ArrayList<Student> studentList
        _________________________________________________________________________________________________________________________________________________________
        +void main(String[] args)
        -static void readInCourseData()
        -static void readInSequencingData()
        -static void readInBlockingData()
        -static void readInStudentData()
        -static Timetable generateRandomTimetable(int studentId)
        -static void outputTimetable(Timetable t)
    }

   ## class SingleClass 
    {
        -static int currentClassId
        -int id
        -String courseCode
        -int currentCapacity
        -int block
        -ArrayList<Integer> classStudentIdList
        _________________________________________________________________________________________________________________________________________________________
        +SingleClass(String courseCode, int currentCapacity, int block)
        +SingleClass(String courseCode, int currentCapacity)
        +SingleClass()
        +SingleClass(int currentClassId, int id, String courseCode, int currentCapacity, int block, ArrayList<Integer> classStudentIdList)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +boolean addStudent(Student s)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +static int getCurrentClassId()
        +static void setCurrentClassId(int currentClassId)
        +String getCourseCode()
        +void setCourseCode(String courseCode)
        +int getCurrentCapacity()
        +void setCurrentCapacity(int currentCapacity)
        +int getBlock()
        +void setBlock(int block)
        +ArrayList<Integer> getClassStudentIdList()
        +void setClassStudentIdList(ArrayList<Integer> classStudentIdList)
        +int getId()
        +void setId(int id)
        +String toString()
    }

   ## class Student 
    {
        -int id
        -ArrayList<String> requestedChosenCourseCodeList
        -ArrayList<String> requestedAlternativeCourseCodeList
        -int[] currentClassIdArray
        _________________________________________________________________________________________________________________________________________________________
        +Student(int id, ArrayList<String> requestedChosenCourseCodeList, ArrayList<String> requestedAlternativeCourseCodeList)
        +Student()
        +Student(int id, ArrayList<String> requestedChosenCourseCodeList, ArrayList<String> requestedAlternativeCourseCodeList, int[] currentClassIdArray)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +void addToClass(int classId, int block)        
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +void setId(int id)
        +int getId()
        +void setRequestedChosenCourseCodeList(ArrayList<String> requestedChosenCourseCodeList)
        +ArrayList<String> getRequestedChosenCourseCodeList()
        +void setRequestedAlternativeCourseCodeList(ArrayList<String> requestedAlternativeCourseCodeList)
        +ArrayList<String> getRequestedAlternativeCourseCodeList()
        +int[] getCurrentClassIdArray()
        +void setCurrentClassIdArray(int[] currentClassIdArray)
        +String toString()
    }

   ## class Timetable 
    {

        -Block[] blocks
        _________________________________________________________________________________________________________________________________________________________
        +Timetable()
        +Timetable(Block[] blocks)
        ---------------------------------------------------------------------------------------------------------------------------------------------------------
        +Block[] getBlocks()
        +void setBlocks(Block[] blocks)
        +String toString()
    }

   ## relationships
    Main "1" --> "0..*" Course : uses >
    Main "1" --> "0..*" Student : uses >
    Main "1" --> "1" Timetable : creates >
    Course "1" --> "0..*" SingleClass : contains >
    Block "1" --> "0..*" SingleClass : contains >
    Timetable "1" --> "8" Block : contains >
    SingleClass "1" --> "0..*" Student : enrolls >
    Student "1" --> "0..*" SingleClass : has enrolled in >