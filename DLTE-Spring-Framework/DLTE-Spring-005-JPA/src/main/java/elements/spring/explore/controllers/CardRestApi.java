package elements.spring.explore.controllers;

import elements.spring.explore.model.CreditCard;
import elements.spring.explore.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardRestApi {
    @Autowired
    CardService cardService;
    @PostMapping("/")
    public CreditCard apiSave(@RequestBody CreditCard creditCard){
        return cardService.callSave(creditCard);
    }
}
