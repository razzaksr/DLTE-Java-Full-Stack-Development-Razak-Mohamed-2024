package soap.rest.wsdl.thyme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/{id}")
    public Loans getLoansById(@PathVariable("id") int id) {
        return loansRepository.findById(id);
    }

    @GetMapping("/")
    public List<Loans> getAllLoans(){
        return loansRepository.findAll();
    }

    @PostMapping("/")
    public Loans createLoans(@RequestBody Loans loans){
        return loansRepository.save(loans);
    }
}
