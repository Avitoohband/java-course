public class Grade {

    public final static int MINIMUM_SCORE = 40;
    public final static int MAXIMUM_SCORE = 100;
    public final static int EXCEED_GRADE = 90;
    String Profession;
    int score; // values 40-100

    public Grade(String profession) {
        this.Profession = profession;
        this.score = MINIMUM_SCORE ;
    }
    public Grade(String profession, int score) {
        this(profession);
        if (score < MINIMUM_SCORE || score > MAXIMUM_SCORE){
            System.out.println("Invalid score number\nthe scores sets to 40");
        }else{
            this.score = score;
        }
    }

    public String getProfession() {
        return Profession;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "Profession='" + Profession + '\'' +
                ", score=" + score +
                '}';
    }
}
