import java.util.ServiceConfigurationError;

public class SchoolStatistics {

    public static void classesAverage(){
        System.out.println("School average: " + School.getInstance().getClassesAverages());
        System.out.println();
    }
    public static void everyClassAverage(){
        System.out.println("Classes averages:");
        for (int i = 0; i < School.NUM_OF_CLASSES; i++) {
            School tempSchool = School.getInstance();
            System.out.print(tempSchool.getClassrooms()[i] + " average: ");
            System.out.println(School.getInstance().getClassAverage(i));
        }
        System.out.println();
    }
    public static void getProfessionsAverages(){
        School tempSchool = School.getInstance();
        System.out.println("Professions averages:");
        System.out.print(ProfessionType.MATH.name() + " average: " + tempSchool.getMathAverages() + " | ");
        System.out.print(ProfessionType.CHEMISTRY.name() + " average: " + tempSchool.getChemAverages() + " | ");
        System.out.print(ProfessionType.GEOGRAPHY.name() + " average: " + tempSchool.getGeoAverages() + " | ");
        System.out.print(ProfessionType.LITERATURE.name() + " average: " + tempSchool.getLiteratueAverages() +" | ");
        System.out.print(ProfessionType.PHYSICS.name() + " average: " + tempSchool.getPhysicsAverages() + " | ");
        System.out.println(ProfessionType.SPORTS.name() + " average: " + tempSchool.getSportsAverages() + " | ");

    }
    // Bonus questions
    public static void getStudentsAverageAge(){
        System.out.println("Total Students average age: " + School.getInstance().getTotalStudentsNumber());
    }
    public static void getSportTeam(){
        System.out.println("School's Sports Team are:");
        School.getInstance().printSportTeamNames();
    }
    public static void main(String[] args) {

        School school  = School.getInstance();
        Teacher[] teachers = new Teacher[School.NUM_OF_CLASSES];
        ClassRoom[] classrooms = new ClassRoom[School.NUM_OF_CLASSES];

        String[] teacherNames = {"Kaleb Gomez",
                "Ikrah Bowman",
                "Maeve Forster",
                "Anastazja Franks",
                "Azaan Mckay"
        };

        String[] classroomsNames = { "401 class",
                "402 class",
                "403 class",
                "404 class",
                "405 class",
        };

        for (int i = 0; i < classrooms.length; i++) {
            int tempAge = (int)(Math.random() * (Student.MAXSIMUM_AGE - Student.MINIMUM_AGE) + Student.MINIMUM_AGE);
            Teacher tempTeacher = new Teacher(teacherNames[i], tempAge, ProfessionType.values()[i].name());
            Student[] tempStudents = new Student[ClassRoom.NUM_OF_STUDENTS];
            for (int j = 0; j < tempStudents.length; j++) {
                tempAge = (int)(Math.random() * (Student.MAXSIMUM_AGE - Student.MINIMUM_AGE) + Student.MINIMUM_AGE);
                String tempName = "Student_" + i;
                tempStudents[j] = new Student(tempName, tempAge);
            }
            classrooms[i] = new ClassRoom(classroomsNames[i], tempTeacher, tempStudents);
        }
        school.setClassrooms(classrooms);

        System.out.println("   _____                                                                 \n" +
                "  / ____|                        /\\                                      \n" +
                " | (___   ___ ___  _ __ ___     /  \\__   _____ _ __ __ _  __ _  ___  ___ \n" +
                "  \\___ \\ / __/ _ \\| '__/ _ \\   / /\\ \\ \\ / / _ \\ '__/ _` |/ _` |/ _ \\/ __|\n" +
                "  ____) | (_| (_) | | |  __/  / ____ \\ V /  __/ | | (_| | (_| |  __/\\__ \\\n" +
                " |_____/ \\___\\___/|_|  \\___| /_/    \\_\\_/ \\___|_|  \\__,_|\\__, |\\___||___/\n" +
                "                                                          __/ |          \n" +
                "                                                         |___/           ");
        classesAverage();
        everyClassAverage();
        getProfessionsAverages();
        //Bonus questions
        System.out.println("   _____ _             _            _                                                                    \n" +
                "  / ____| |           | |          | |           /\\                   /\\                                 \n" +
                " | (___ | |_ _   _  __| | ___ _ __ | |_ ___     /  \\   __ _  ___     /  \\__   _____ _ __ __ _  __ _  ___ \n" +
                "  \\___ \\| __| | | |/ _` |/ _ \\ '_ \\| __/ __|   / /\\ \\ / _` |/ _ \\   / /\\ \\ \\ / / _ \\ '__/ _` |/ _` |/ _ \\\n" +
                "  ____) | |_| |_| | (_| |  __/ | | | |_\\__ \\  / ____ \\ (_| |  __/  / ____ \\ V /  __/ | | (_| | (_| |  __/\n" +
                " |_____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__|___/ /_/    \\_\\__, |\\___| /_/    \\_\\_/ \\___|_|  \\__,_|\\__, |\\___|\n" +
                "                                                       __/ |                                   __/ |     \n" +
                "                                                      |___/                                   |___/      ");
        getStudentsAverageAge();
        System.out.println("   _____                  _         _______                   \n" +
                "  / ____|                | |       |__   __|                  \n" +
                " | (___  _ __   ___  _ __| |_ ___     | | ___  __ _ _ __ ___  \n" +
                "  \\___ \\| '_ \\ / _ \\| '__| __/ __|    | |/ _ \\/ _` | '_ ` _ \\ \n" +
                "  ____) | |_) | (_) | |  | |_\\__ \\    | |  __/ (_| | | | | | |\n" +
                " |_____/| .__/ \\___/|_|   \\__|___/    |_|\\___|\\__,_|_| |_| |_|\n" +
                "        | |                                                   \n" +
                "        |_|                                                   ");
        getSportTeam();


    }
}
