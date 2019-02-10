package pl.edu.wszib.springtalkingwithworld.model;

public class Restauracja {

    public static double koszt(Klient klient) {
        double wynik = 25;
        if (klient.osobaTowarzysząca) {
            wynik += 15;
        }

        if (klient.dziecko) {
            wynik += 40;
        }

        if (klient.zwierze) {
            wynik += 100;
        }

        return wynik;
    }


}
