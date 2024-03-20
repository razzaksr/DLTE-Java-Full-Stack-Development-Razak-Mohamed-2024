package elements.spring.explore.remotes;

import elements.spring.explore.model.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<CreditCard,Long> {
    List<CreditCard> findAllByCardLimit(Integer limit);
    // findAllByProperty
    // findByProperty
    List<CreditCard> findAllByCardLimitBetween(Integer cardLimit, Integer cardLimit2);

}
