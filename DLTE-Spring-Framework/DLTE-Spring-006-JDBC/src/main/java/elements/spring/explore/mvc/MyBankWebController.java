package elements.spring.explore.mvc;

import elements.spring.explore.CardException;
import elements.spring.explore.CreditCard;
import elements.spring.explore.MyBankController;
import elements.spring.explore.MyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web")
public class MyBankWebController {
    @Autowired
    MyBankService myBankService;

    Logger logger= LoggerFactory.getLogger(MyBankWebController.class);

//    List<String> myProducts = Stream.of("Credit card","debit card","loans","deposits","funds","stocks").collect(Collectors.toList());

    ResourceBundle bundle=ResourceBundle.getBundle("mybank");

    @RequestMapping(value="/apply", method = RequestMethod.GET)
    public String requestToSubmission(Model model){
        CreditCard creditCard=new CreditCard();
        model.addAttribute("creditCard",creditCard);
        return "newapply";
    }

    @GetMapping("/")
    public String landing(){
        return "index";
    }

    @RequestMapping(value="/review",method = RequestMethod.POST)
    public String approveOrReject(@Valid CreditCard creditCard, BindingResult bindingResult,Model model ){
        try{
            if(!bindingResult.hasErrors()){
                creditCard = myBankService.apiSave(creditCard);
                model.addAttribute("status",creditCard.getCreditcardNumber()+" has inserted");
            }
        }
        catch (CardException cardException){
            logger.warn(cardException.toString());
            model.addAttribute("error",cardException.toString());
        }
        return "newapply";
    }

    @RequestMapping(value="/view", method = RequestMethod.GET)
    public String availableCards(Model model){
        try {
            List<CreditCard> cards = myBankService.apiFindAll();
            model.addAttribute("cards",cards);
            return "customers";
        } catch (SQLSyntaxErrorException e) {
            throw new RuntimeException(e);
        }

    }

//    @GetMapping("/")
//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String myTemplate(Model model){
////        model.addAttribute("greet","Welcome to My Bank");
//        model.addAttribute("greet",bundle.getString("simple.greet"));
//        CreditCard creditCard=new CreditCard();
//        model.addAttribute("creditCard",creditCard);
//        return "index";
//    }

//    @RequestMapping(value="/{index}",method = RequestMethod.GET)
//    public String myRead(@PathVariable int index, Model model){
//        if(myProducts.size()>index&&index>=0){
//            model.addAttribute("selectedProduct",myProducts.get(index));
//            return "selected";
//        }
//        else{
//            model.addAttribute("error","Invalid index");
//            return "index";
//        }
//    }

//    @RequestMapping(value="/send",method = RequestMethod.POST)
//    public String myPost(@RequestParam("productName1") String productName1,@RequestParam("productName2") String productName2,@RequestParam("productName3") String productName3, Model model){
//        myProducts.add(productName1);myProducts.add(productName2);myProducts.add(productName3);
//        model.addAttribute("added","Products are added");
//        return "selected";
//    }
}
