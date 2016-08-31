package service.home;

import model.response.EBooksResponse;
import model.response.ResponseBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/service")
public class WebAppController {

    RestTemplate restTemplate = new RestTemplate();

    @ResponseBody@RequestMapping(method = RequestMethod.GET, path = "/crawler")
    public ResponseBase getData(@RequestParam(name = "category") String categories) {
        return
                restTemplate.getForObject("http://localhost:1223/robot/find/"+categories, EBooksResponse.class);

    }
}

