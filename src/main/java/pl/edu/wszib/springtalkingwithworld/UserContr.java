package pl.edu.wszib.springtalkingwithworld;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContr {

    List<String> usersList = new ArrayList<String>();

    @GetMapping("/{imie}/{nazwisko}")
    public ResponseEntity user(@PathVariable String imie,
                               @PathVariable String nazwisko) {
        ResponseEntity entity = new ResponseEntity(imie + " " + nazwisko, HttpStatus.OK);
        return entity;
    }
    @GetMapping("/istnieje/{imie}/{nazwisko}")
    public ResponseEntity istnieje(@PathVariable String imie,
                                   @PathVariable String nazwisko) {
        if (usersList.contains(imie + nazwisko)) {
            ResponseEntity entity = new ResponseEntity(HttpStatus.ALREADY_REPORTED);
            return entity;
        }
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/zapisz/{imie}/{nazwisko}")
    public ResponseEntity zapisz(@PathVariable String imie,
                                 @PathVariable String nazwisko) {
         if (usersList.contains(imie + nazwisko)) {
            ResponseEntity entity = new ResponseEntity(HttpStatus.ALREADY_REPORTED);
            return entity;
        }
        else {
             usersList.add(imie + nazwisko);
             return  new ResponseEntity(HttpStatus.OK);
         }


    }
}
