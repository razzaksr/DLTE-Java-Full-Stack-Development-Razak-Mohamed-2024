package soap.rest.wsdl.thyme;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository {
    Loans save(Loans loans);
    List<Loans> findAll();
    Loans findById(int id);
    String deleteById(int id);
    Loans update(Loans loans);
}
