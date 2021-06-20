import java.util.Arrays;

public class ClassRoom {
    public static final int NUM_OF_STUDENTS = 15;
    private String name;
    private Teacher teacher;
    Student[] students;

    public ClassRoom(String name, Teacher teacher, Student[] students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }
    public int getAverage(){
        int average = 0;
        for (int i = 0; i < students.length; i++) {
            average += students[i].getAverage();
        }
        return (average/NUM_OF_STUDENTS);

    }
    public Student[] getStudents(){
        return students;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "name: '" + name + '\'' +
                ", teacher: " + teacher +
                '}';
    }
}
