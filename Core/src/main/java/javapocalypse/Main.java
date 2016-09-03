package javapocalypse;

import javapocalypse.repositories.AuthorRepository;
import model.response.BooleanResponse;
import model.response.OffersResponse;
import model.response.ResponseBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@SpringBootApplication
@ComponentScan({"javapocalypse"})
@RestController
public class Main {

    @Inject
    AuthorRepository authorRepository;

    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }

    @PostMapping(path = "/repo/")
    public ResponseBase saveOffers(@RequestBody ResponseBase author){
        // TODO generating the entities
        // TODO save entities into database
        boolean result = true;

        return new BooleanResponse(result);
    }

    @PostMapping(path = "/offers/{operation}")
    public ResponseBase muAutthor(@RequestBody ResponseBase request, @PathVariable("operation") String operation){
        // TODO getting the operation
        // TODO prepare the result

        return new OffersResponse();
    }

}
