package soap.rest.wsdl.thyme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class LoansWebController {
    @GetMapping("/view")
    public String viewing(){
        return "ViewAll";
    }
}
