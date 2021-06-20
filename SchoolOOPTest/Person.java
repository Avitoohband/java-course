public class Person {

    public final static int MINIMUM_AGE= 20;
    public final static int MAXSIMUM_AGE = 120;
    private String name;
    int age; // 20 - 120

    public Person(String name) {
        this.name = name;
        this.age = MINIMUM_AGE;
    }
    public Person (String name, int age){
        this(name);
        if (age < MINIMUM_AGE || age > MAXSIMUM_AGE){
            System.out.println("Invalid age number\nthe age sets to " + MINIMUM_AGE);
        }else{
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age;
    }
}
