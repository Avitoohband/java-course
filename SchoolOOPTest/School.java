public class School{

    public static final int NUM_OF_CLASSES = 5 ;
    private ClassRoom[] classrooms;
    private School( ){
        classrooms = new ClassRoom[NUM_OF_CLASSES];
    }

    private static School school = new School();

    public static School getInstance(){
        return school;
    }

    public void setClassrooms(ClassRoom[] classrooms) {
        this.classrooms = classrooms;
    }
    public int getClassesAverages(){
        int average = 0;
        for (int i = 0; i < classrooms.length; i++) {
            average += classrooms[i].getAverage();
        }
        return (average/classrooms.length);
    }
    public int getClassAverage(int index){
        return classrooms[index].getAverage();
    }
    public ClassRoom[] getClassrooms(){
        return this.classrooms;
    }
    public int getTotalStudentsNumber(){
        return NUM_OF_CLASSES*ClassRoom.NUM_OF_STUDENTS;
    }
    public int getMathAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.MATH.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getChemAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.CHEMISTRY.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getGeoAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.GEOGRAPHY.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getLiteratueAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.LITERATURE.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getPhysicsAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.PHYSICS.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getSportsAverages(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getGrades()[ProfessionType.SPORTS.ordinal()].getScore();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public int getTotalStudentsAverageAge(){
        int average = 0 ;
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                average += classrooms[i].getStudents()[j].getAge();
            }
        }
        return (average/getTotalStudentsNumber());
    }
    public void printSportTeamNames(){
        for (int i = 0; i < classrooms.length; i++) {
            for (int j = 0; j < ClassRoom.NUM_OF_STUDENTS; j++) {
                Student tempSudent =  classrooms[i].getStudents()[j];
                int grade = tempSudent.getGrades()[ProfessionType.SPORTS.ordinal()].getScore();
                if (grade > Grade.EXCEED_GRADE){
                    System.out.println(tempSudent);
                }
            }
        }
    }
}
