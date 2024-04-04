package layer.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface BankersRepository {
    String deleteOne(int id);
    String updateOne(Bankers bankers);
    List<Bankers> readNames(String name);
    String insertion(Bankers bankers);
    Optional<Bankers> listOne(int id);
    List<Bankers> listAll();
}
