package elements.spring.explore.controllers;

import elements.spring.explore.model.CreditCard;
import elements.spring.explore.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardRestApi {
    @Autowired
    CardService cardService;
    @PutMapping(value="/",consumes = "application/xml")
    public CreditCard apiUpdate(@RequestBody CreditCard creditCard){
        return cardService.callSave(creditCard);
    }
    @PostMapping("/")
    public CreditCard apiSave(@RequestBody CreditCard creditCard){
        return cardService.callSave(creditCard);
    }

    @GetMapping("/")
    public List<CreditCard> apiAll(){
        return cardService.callFindAll();
    }

    @GetMapping(value="/{limit}",produces = "application/xml")
    public List<CreditCard> apiLimit(@PathVariable("limit") Integer limit){
        return cardService.callFindAllLimit(limit);
    }

    @GetMapping("/{limit1}/{limit2}")
    public List<CreditCard> apiRange(@PathVariable("limit1") Integer limit1,@PathVariable("limit2") Integer limit2){
        return cardService.callFindAllLimitRange(limit1,limit2);
    }

    @GetMapping("/id/{number}")
    public Optional<CreditCard> apiById(@PathVariable("number") Long number){
        return cardService.callFindById(number);
    }

    @DeleteMapping("/")
    public String apiDelete(@RequestBody CreditCard creditCard){
        cardService.callDelete(creditCard);
        return creditCard.getCardHolder()+" has suspended";
    }

    @GetMapping("/name/{phrase}")
    public List<CreditCard> apiByName(@PathVariable("phrase") String phrase){
        return cardService.callLookUp(phrase);
    }

    // Date format has to be passed through the postman is http://localhost:8082/card/date/11OCT2031/11DEC2031
    @GetMapping("/date/{date1}/{date2}")
    public List<CreditCard> apiByDate(@PathVariable("date1") String date1,@PathVariable("date2") String date2){
        return cardService.callLookUpDate(date1,date2);
    }
}
