package elements.spring.explore.services;

import elements.spring.explore.model.CreditCard;
import elements.spring.explore.remotes.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public CreditCard callSave(CreditCard creditCard){
        return cardRepository.save(creditCard);
    }
}
