package tp.epita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringWeb {
    public static void main(String[] args) {
        SpringApplication.run(SpringWeb.class, args);
    }
}

@RestController
@RequestMapping(path="/wrestle")
class WrestleController {

    private Map<String, Game> games;

    public WrestleController() {
        games = new HashMap<>();
        games.put("0", new Game());
    }

    @GetMapping("/{id}")
    public Game display(String id){
        return games.get(id);
    }

    @DeleteMapping("/{id}")
    public void raz(String id){
        games.get(id).raz();
    }

    @PostMapping("/{id}")
    public void create(@RequestBody Game game, String id){
        games.put(id, game);
    }

    @PutMapping("/{id}")
    public void push(@RequestParam int player, String id, HttpServletRequest request){
        Game game = games.get(id);
        String navigator = request.getHeader("user-agent");
        game.incrementForce(player);
        game.addNavigatorToStats(navigator);

    }
}

@JsonRootName(value = "Game")
class Game{
    private int force = 0;
    private int force2 = 0;

    @JsonIgnore
    private Map<String, Integer> stats = new HashMap<>();

    public Game() {
    }

    public void incrementForce(int force) {
        this.force = force+1;
    }

    public void incrementForce2(int force) {
        this.force = force2+1;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setForce2(int force2) {
        this.force2 = force2;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    public int getForce() {
        return force;
    }

    public int getForce2() {
        return force2;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "Game{" +
                "force=" + force +
                ", force2=" + force2 +
                '}';
    }

    public void raz() {
        force = 0;
        force2 = 0;
    }

    public void addNavigatorToStats(String navigator) {
        stats.merge(navigator, 1, Integer::sum);
    }
}