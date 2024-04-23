package elements.spring.explore.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web")
public class MyBankWebController {

    List<String> myProducts = Stream.of("Credit card","debit card","loans","deposits","funds","stocks").collect(Collectors.toList());

    ResourceBundle bundle=ResourceBundle.getBundle("mybank");

//    @GetMapping("/")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String myTemplate(Model model){
//        model.addAttribute("greet","Welcome to My Bank");
        model.addAttribute("greet",bundle.getString("simple.greet"));
        return "index";
    }

    @RequestMapping(value="/{index}",method = RequestMethod.GET)
    public String myRead(@PathVariable int index, Model model){
        if(myProducts.size()>index&&index>=0){
            model.addAttribute("selectedProduct",myProducts.get(index));
            return "selected";
        }
        else{
            model.addAttribute("error","Invalid index");
            return "index";
        }
    }
}
