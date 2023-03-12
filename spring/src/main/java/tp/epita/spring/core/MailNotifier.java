package tp.epita.spring.core;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mail")
public class MailNotifier implements Notifier {

    public void notify(User user){
        System.out.println("I send a mail to "+user.getName());
    }
}
