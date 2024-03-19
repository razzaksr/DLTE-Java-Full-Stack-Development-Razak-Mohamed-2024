package elements.spring.explore.dltespring;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/collection")
public class Dashboard {
    private List<String> modules= Stream.of("Credit card","Accounts","Bonds","Deposits","Loans").collect(Collectors.toList());

    @GetMapping("/")
    public List<String> readEverything(){
        return modules;
    }
    @PostMapping("/")
    public String createNewOne(@RequestBody String object){
        modules.add(object);
        return object+" has added";
    }

    @DeleteMapping("/{prashant}")
    public String removeOne(@PathVariable("prashant") int prashant){
        return modules.remove(prashant);
    }

    @DeleteMapping("/del/{medhini}")
    public String removeByObject(@PathVariable("medhini") String medhini){
        modules.remove(medhini);
        return medhini+" has removed";
    }

}
