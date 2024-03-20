package elements.spring.explore.services;

import elements.spring.explore.model.CreditCard;
import elements.spring.explore.remotes.CardRepository;
import elements.spring.explore.remotes.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CreditRepository creditRepository;

    public CreditCard callSave(CreditCard creditCard){
        return cardRepository.save(creditCard);
    }

    public List<CreditCard> callFindAll(){
        return (List<CreditCard>) cardRepository.findAll();
    }

    public List<CreditCard> callFindAllLimit(Integer limit){
        return cardRepository.findAllByCardLimit(limit);
    }

    public List<CreditCard> callFindAllLimitRange(Integer limit1,Integer limit2){
        return cardRepository.findAllByCardLimitBetween(limit1,limit2);
    }

    public Optional<CreditCard> callFindById(Long cardNumber){
        return cardRepository.findById(cardNumber);
    }

    public void callDelete(CreditCard creditCard){
        cardRepository.delete(creditCard);
    }

    public List<CreditCard> callLookUp(String name){
        return creditRepository.lookUpByName(name);
    }

    public List<CreditCard> callLookUpDate(String date1,String date2){
        return creditRepository.lookUpByDate(date1,date2);
    }
}
