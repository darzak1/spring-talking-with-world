package pl.edu.wszib.springtalkingwithworld.model;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

// /restauracja/koszt?imię=Adam&reszta opcjaonalnie

@Controller
@RequestMapping("/restauracja")
public class RestauracjaKontr {


    @GetMapping("/koszt")
    public ResponseEntity koszt(@RequestParam String imie,
                                @RequestParam(required = false) String osobaTowarzysząca,
                                @RequestParam(required = false) String dziecko,
                                @RequestParam(required = false) String zwierze
                                ){
    Klient klient = new Klient();
    klient.imie = imie;
    klient.osobaTowarzysząca = osobaTowarzysząca !=null;
    klient.dziecko = dziecko !=null;
    klient.zwierze = zwierze !=null;



    Restauracja.koszt(klient);
    return ResponseEntity.ok(Restauracja.koszt(klient));
    }

}
