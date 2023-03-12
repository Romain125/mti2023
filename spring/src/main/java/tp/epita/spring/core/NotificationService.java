package tp.epita.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private Notifier notifier;
    private NotificationTracer notificationTracer;

    @Autowired
    public NotificationService(Notifier notifier, NotificationTracer notificationTracer) {
        this.notifier = notifier;
        this.notificationTracer = notificationTracer;
    }

    public void notify(User user){
        notifier.notify(user);
        notificationTracer.trace(user);
    }

}
