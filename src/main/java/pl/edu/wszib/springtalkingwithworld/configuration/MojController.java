package pl.edu.wszib.springtalkingwithworld.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/moj")
public class MojController {

    //localhost/moj
    @GetMapping
    public ResponseEntity get() {
        ResponseEntity entity = new ResponseEntity("Hello World", HttpStatus.OK);
        return entity;
    }

    //localhost/moj/json
    @GetMapping(value = "/json", produces = "application/json")
    public ResponseEntity getJson() {
            String json = "{\n" +
                    "\"imie\" : \"Adam\",\n" +
                    "\"szkoła\" : {\n" +
                    "\"nazwa\" : \"SP nr 11\",\n" +
                    "\"adres\" : \"Polna 2\"\n" +
                    "},\n" +
                    "\"oceny\" : [5, 5, 2] \n" +
                    "\n" +
                    "}";

        ResponseEntity entity = new ResponseEntity(json, HttpStatus.OK);
        return entity;
    }
}