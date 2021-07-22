package avi.core;

import avi.core.entities.Employee;
import avi.core.entities.Job;
import avi.core.services.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class SpringJpaExerciseApplication {

    public static void printList(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaExerciseApplication.class, args)){
            CompanyService companyService = ctx.getBean(CompanyService.class);

            Employee emp1 = new Employee(0,"Marcus", 14500, null);
            companyService.addEmployee(
                    new Employee(0,"Marcus", 14500,
                            Arrays.asList(new Job(0, "Work easy", LocalDate.now().plusDays(25)),
                                    new Job(0, "Work very easy ZzZzz..", LocalDate.now().plusDays(50)))));
            companyService.addEmployee(
                    new Employee(0,"Pedro", 3500,
                            Arrays.asList(new Job(0, "Work very Hard!", LocalDate.now().plusDays(1)),
                                    new Job(0, "Work very Very VEry VERy VERY HARD!!!", LocalDate.now()))));
            System.out.println("========================================================================================");
            System.out.println("  ______ _           _            _ _   ______                 _                            \n" +
                    " |  ____(_)         | |     /\\   | | | |  ____|               | |                           \n" +
                    " | |__   _ _ __   __| |    /  \\  | | | | |__   _ __ ___  _ __ | | ___  _   _  ___  ___  ___ \n" +
                    " |  __| | | '_ \\ / _` |   / /\\ \\ | | | |  __| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\/ __|\n" +
                    " | |    | | | | | (_| |  / ____ \\| | | | |____| | | | | | |_) | | (_) | |_| |  __/  __/\\__ \\\n" +
                    " |_|    |_|_| |_|\\__,_| /_/    \\_\\_|_| |______|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___||___/\n" +
                    "                                                        | |             __/ |               \n" +
                    "                                                        |_|            |___/                ");
            printList(companyService.findAllEmployees());
            System.out.println("  ______ _           _   ______                 _                         _             _____    _   __ \n" +
                    " |  ____(_)         | | |  ____|               | |                       | |           |_   _|  | | /_ |\n" +
                    " | |__   _ _ __   __| | | |__   _ __ ___  _ __ | | ___  _   _  ___  ___  | |__  _   _    | |  __| |  | |\n" +
                    " |  __| | | '_ \\ / _` | |  __| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\ | '_ \\| | | |   | | / _` |  | |\n" +
                    " | |    | | | | | (_| | | |____| | | | | | |_) | | (_) | |_| |  __/  __/ | |_) | |_| |  _| || (_| |  | |\n" +
                    " |_|    |_|_| |_|\\__,_| |______|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___| |_.__/ \\__, | |_____\\__,_|  |_|\n" +
                    "                                         | |             __/ |                   __/ |                  \n" +
                    "                                         |_|            |___/                   |___/                   ");
            System.out.println(companyService.findEmployeeById(1));
            System.out.println("  ______ _           _   ______                 _                         ____          _   _                        _ _ _____         _          _ _ \n" +
                    " |  ____(_)         | | |  ____|               | |                       |  _ \\        | \\ | |                      ( | )  __ \\       | |        ( | )\n" +
                    " | |__   _ _ __   __| | | |__   _ __ ___  _ __ | | ___  _   _  ___  ___  | |_) |_   _  |  \\| | __ _ _ __ ___   ___   V V| |__) |__  __| |_ __ ___ V V \n" +
                    " |  __| | | '_ \\ / _` | |  __| | '_ ` _ \\| '_ \\| |/ _ \\| | | |/ _ \\/ _ \\ |  _ <| | | | | . ` |/ _` | '_ ` _ \\ / _ \\     |  ___/ _ \\/ _` | '__/ _ \\    \n" +
                    " | |    | | | | | (_| | | |____| | | | | | |_) | | (_) | |_| |  __/  __/ | |_) | |_| | | |\\  | (_| | | | | | |  __/     | |  |  __/ (_| | | | (_) |   \n" +
                    " |_|    |_|_| |_|\\__,_| |______|_| |_| |_| .__/|_|\\___/ \\__, |\\___|\\___| |____/ \\__, | |_| \\_|\\__,_|_| |_| |_|\\___|     |_|   \\___|\\__,_|_|  \\___/    \n" +
                    "                                         | |             __/ |                   __/ |                                                                \n" +
                    "                                         |_|            |___/                   |___/                                                                 ");
            System.out.println(companyService.findEmployeesByName("Pedro"));
            System.out.println("  ______ _           _            _ _        _       _         \n" +
                    " |  ____(_)         | |     /\\   | | |      | |     | |        \n" +
                    " | |__   _ _ __   __| |    /  \\  | | |      | | ___ | |__  ___ \n" +
                    " |  __| | | '_ \\ / _` |   / /\\ \\ | | |  _   | |/ _ \\| '_ \\/ __|\n" +
                    " | |    | | | | | (_| |  / ____ \\| | | | |__| | (_) | |_) \\__ \\\n" +
                    " |_|    |_|_| |_|\\__,_| /_/    \\_\\_|_|  \\____/ \\___/|_.__/|___/\n" +
                    "                                                               \n" +
                    "                                                               ");
            printList(companyService.findAllJobs());
            System.out.println("  ______ _           _        _       _           ____          ______           _   _____        _       \n" +
                    " |  ____(_)         | |      | |     | |         |  _ \\        |  ____|         | | |  __ \\      | |      \n" +
                    " | |__   _ _ __   __| |      | | ___ | |__  ___  | |_) |_   _  | |__   _ __   __| | | |  | | __ _| |_ ___ \n" +
                    " |  __| | | '_ \\ / _` |  _   | |/ _ \\| '_ \\/ __| |  _ <| | | | |  __| | '_ \\ / _` | | |  | |/ _` | __/ _ \\\n" +
                    " | |    | | | | | (_| | | |__| | (_) | |_) \\__ \\ | |_) | |_| | | |____| | | | (_| | | |__| | (_| | ||  __/\n" +
                    " |_|    |_|_| |_|\\__,_|  \\____/ \\___/|_.__/|___/ |____/ \\__, | |______|_| |_|\\__,_| |_____/ \\__,_|\\__\\___|\n" +
                    "                                                         __/ |                                            \n" +
                    "                                                        |___/                                             ");
            printList(companyService.findJobsByEndDate(LocalDate.now()));
            System.out.println("  ______ _           _        _       _           ____       _                             _____        _            \n" +
                    " |  ____(_)         | |      | |     | |         |  _ \\     | |                           |  __ \\      | |           \n" +
                    " | |__   _ _ __   __| |      | | ___ | |__  ___  | |_) | ___| |___      _____  ___ _ __   | |  | | __ _| |_ ___  ___ \n" +
                    " |  __| | | '_ \\ / _` |  _   | |/ _ \\| '_ \\/ __| |  _ < / _ \\ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\  | |  | |/ _` | __/ _ \\/ __|\n" +
                    " | |    | | | | | (_| | | |__| | (_) | |_) \\__ \\ | |_) |  __/ |_ \\ V  V /  __/  __/ | | | | |__| | (_| | ||  __/\\__ \\\n" +
                    " |_|    |_|_| |_|\\__,_|  \\____/ \\___/|_.__/|___/ |____/ \\___|\\__| \\_/\\_/ \\___|\\___|_| |_| |_____/ \\__,_|\\__\\___||___/\n" +
                    "                                                                                                                     \n" +
                    "                                                                                                                     ");
            printList(companyService.findByEndDateBetween(
                        LocalDate.now().minusDays(1),
                        LocalDate.now().plusDays(51)));
            System.out.println("========================================================================================");

        }
    }
}
