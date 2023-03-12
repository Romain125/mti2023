package tp.epita.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
//N'est plus nécessaire grâce à Spring-boot
//@PropertySource("chemin_vers_votre_fichier")
public class NotificationTracer {

    private final String traceFilePath;

    public NotificationTracer(@Value("${trace.file.path}") String traceFilePath) {
        this.traceFilePath = traceFilePath;
    }

    public void trace(User user){
        Path of = Path.of(traceFilePath);
        try {
            Files.writeString(of, "User notified : "+user.getName());
        } catch (IOException e) {
            //Do something...
            throw new RuntimeException(e);
        }
    }
}
