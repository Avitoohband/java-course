import java.util.Arrays;

public class Student extends Person{

    Grade[] grades;

    public Student(String name, int age) {
        super(name, age);
        initiateGrages();

    }
    private void initiateGrages(){
        grades = new Grade[ProfessionType.values().length];
        for (int i = 0; i < grades.length; i++) {
            int tempScore = (int)(Math.random() * (Grade.MAXIMUM_SCORE - Grade.MINIMUM_SCORE) + Grade.MINIMUM_SCORE);
            grades[i] = new Grade(ProfessionType.values()[i].name(), tempScore);
        }
    }
    public int getAverage(){
        int average = 0 ;
        for (int i = 0; i < grades.length; i++) {
            average += grades[i].getScore();
        }
        return (average/grades.length);
    }
    public Grade[] getGrades(){
        return grades;
    }
    @Override
    public String toString() {
        return super.toString() + " age=" + age +
                ", grades=" + Arrays.toString(grades);
    }
}
