package elements.spring.explore.remotes;

import elements.spring.explore.model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<CreditCard,Long> {

}
