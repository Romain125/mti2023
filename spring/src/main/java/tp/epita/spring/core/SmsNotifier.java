package tp.epita.spring.core;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("sms")
public class SmsNotifier implements Notifier{
    @Override
    public void notify(User user) {
        //...
    }
}
