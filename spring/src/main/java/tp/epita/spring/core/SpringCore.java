package tp.epita.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringCore {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringCore.class);
        // En théorie, il faut trouver un moyen pour exécuter l'application avec un profile.
        // Le mieux est de gérer ça avec un plugin Spring ou un argument en ligne de commande.
        application.setAdditionalProfiles("sms"); //Bonus, astuce pour mettre un profile programmatiquement
        ConfigurableApplicationContext context = application.run();

        //...
        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
        notificationService.notify(new User("Romain"));
    }

}
