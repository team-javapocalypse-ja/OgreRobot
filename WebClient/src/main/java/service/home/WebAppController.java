package service.home;

import model.response.EBooksResponse;
import model.response.ResponseBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/service")
public class WebAppController {

    @ResponseBody@RequestMapping(method = RequestMethod.GET, path = "/crawler")
    public ResponseBase getData(@RequestParam(name = "category") String categories) {
        RestTemplate template = new RestTemplate();
        EBooksResponse responseBase = template.getForObject("http://localhost:1223/robot/find/"+categories, EBooksResponse.class);

        return responseBase;
    }
}

