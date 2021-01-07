import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import registration.RegistrationRestController;

@ComponentScan(basePackages = {"eu.bambz.hexagonal.jpa-persistence"}, basePackageClasses = {RegistrationRestController.class, JpaConfig.class})
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
