public class Teacher extends Person {
    String profession;


    public Teacher(String name, int age, String profession) {
        super(name, age);
        this.profession = profession;
    }

    @Override
    public String toString() {
        return  super.toString() + " profession='" + profession + '\'';
    }
}
