package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/calcTest")
public class Calc {


    @GetMapping("/suma")
    public ResponseEntity get(@RequestParam("liczba") int[] liczby) {
        return ResponseEntity.ok(Arrays.stream(liczby).sum());
    }

    @GetMapping("/srednia")
    public ResponseEntity get2(@RequestParam("liczba") int[] liczbySrednia) {
        return ResponseEntity.ok(Arrays.stream(liczbySrednia).average());
    }
    @GetMapping("/roznica")
    public ResponseEntity get3(@RequestParam("liczba") int[] liczbyRoznica) {
        return ResponseEntity.ok(Arrays.stream(liczbyRoznica).reduce((x, y) -> x-y));
    }
    @GetMapping("/iloczyn")
    public ResponseEntity get4(@RequestParam("liczba") int[] liczbyIloczyn) {
        final int[] a = new int[]{1};
        Arrays.stream(liczbyIloczyn).forEach(liczba -> a[0] *= liczba);
        return ResponseEntity.ok(a);
    }

}
