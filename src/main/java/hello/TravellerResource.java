package hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TravellerResource {

    @RequestMapping("/gjesteliste")
    public List<Gjest> getHtml() {

        return createGuestList();
    }

    @RequestMapping("/tidligbuss")
    public List<String> getEarlyBusParticipants() {

        return onlyNames(createGuestList().stream().filter(p -> p.getTransport().equals(Transport.BUSS_TIDLIG)).collect(Collectors.toList()));
    }

    @RequestMapping("/senbuss")
    public List<String> getLateBusParticipants() {

        return onlyNames(createGuestList().stream().filter(p -> p.getTransport().equals(Transport.BUSS_SEN)).collect(Collectors.toList()));
    }

    @RequestMapping("/bil")
    public List<String> getCarParticipants() {

        return onlyNames(createGuestList().stream().filter(p -> p.getTransport().equals(Transport.BIL)).collect(Collectors.toList()));
    }

    @RequestMapping("/potensielleaktvitetsdeltagere")
    public List<String> getActivityParticipants() {

        return onlyNames(createGuestList().stream().filter(p -> p.getAktivitetsdeltagelse().equals(Aktivitetsdeltagelse.JA) || p.getAktivitetsdeltagelse().equals(Aktivitetsdeltagelse.KANSKJE)).collect(Collectors.toList()));
    }

    private List<String> onlyNames(List<Gjest> guests) {
        List<String> nameList = new ArrayList<>();

        for (Gjest guest : guests) {
            nameList.add(guest.getEtternavn() + ", " + guest.getFornavn());
        }

        return nameList;
    }

    private List<Gjest> createGuestList() {

        Rom revehiet = new Rom("Revehiet", "Høydehuset 2.etg", 5);
        Rom jervehiet = new Rom("Jervehiet", "Høydehuset 2.etg", 5);
        Rom ulvehiet = new Rom("Ulvehiet", "Høydehuset 2.etg", 5);
        Rom gaupehiet = new Rom("Gaupehiet", "Høydehuset 2.etg", 5);
        Rom bjornehiet = new Rom("Bjørnehiet", "Høydehuset 2.etg", 5);
        Rom einar = new Rom("Einar", "Høydehuset 2.etg", 4);
        Rom halldis = new Rom("Halldis", "Høydehuset 2.etg", 4);
        Rom gjermund = new Rom("Gjermund", "Høydehuset 2.etg", 4);
        Rom ingrid = new Rom("Ingrid", "Høydehuset 2.etg", 4);
        Rom sigurd = new Rom("Sigurd", "Høydehuset 2.etg", 4);
        Rom hallgeir = new Rom("Hallgeir", "Høydehuset 2.etg", 4);
        Rom elling = new Rom("Elling", "Høydehuset 2.etg", 4);
        Rom kaare = new Rom("Kåre", "Høydehuset 2.etg", 4);
        Rom klatrer = new Rom("Klatrer'n", "Høydehuset 1.etg", 4);
        Rom klatrer2 = new Rom("Klatrer'n 2", "Høydehuset 1.etg", 4);
        Rom kvisten = new Rom("Kvisten", "Høydehuset 3.etg", 2);
        Rom kammerset = new Rom("Kammerset", "Høydehuset 3.etg", 1);
        Rom trevet = new Rom("Trevet", "Høydehuset 3.etg", 2);
        Rom vogga = new Rom("Vogga", "Høydehuset 3.etg", 1);
        Rom stuggua = new Rom("Stuggua", "Høydehuset 3.etg", 3);
        Rom stallen = new Rom("Stallen", "Høydehuset 3.etg", 3);
        Rom kvilsten = new Rom("Kvilsten", "Bygget på andre siden av tunet", 5);
        Rom risbiten = new Rom("Risbiten", "Bygget på andre siden av tunet", 5);

        List<Gjest> gjester = new ArrayList<Gjest>();

        // Revehiet
        gjester.add(new Gjest("Jørgen", "Ringen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, revehiet));
        gjester.add(new Gjest("Ørjan", "Johansen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, revehiet));
        gjester.add(new Gjest("Aasmund", "Nordstoga", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, revehiet));
        gjester.add(new Gjest("Fredrik", "Bjørnøy", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, revehiet));

        // Jervehiet
        gjester.add(new Gjest("Thomas", "Johansen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, jervehiet));
        gjester.add(new Gjest("Knut-Erik", "Johnsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, jervehiet));
        gjester.add(new Gjest("Marius", "Torsrud", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, jervehiet));
        gjester.add(new Gjest("Jon André", "Fagerholm", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, jervehiet));

        // Ulvehiet
        gjester.add(new Gjest("Kristian", "Haugene", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, ulvehiet));
        gjester.add(new Gjest("Stian", "Neverdal", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, ulvehiet));
        gjester.add(new Gjest("Håvard", "Andersen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.NEI, ulvehiet));
        gjester.add(new Gjest("Dejan", "Maric", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, ulvehiet));

        // Gaupehiet
        gjester.add(new Gjest("Adriano", "Stewart", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, gaupehiet));
        gjester.add(new Gjest("David", "Emanuelsen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, gaupehiet));
        gjester.add(new Gjest("Ramesh", "Shiraddi", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, gaupehiet));

        // Elling
        gjester.add(new Gjest("Denis", "Ligonja", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, elling));
        gjester.add(new Gjest("Jacob", "Meidell", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, elling));
        gjester.add(new Gjest("Jan F.", "Langtangen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, elling));
        gjester.add(new Gjest("Espen", "Moen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, elling));

        // Einar
        gjester.add(new Gjest("Artur", "Barczynski", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, einar));
        gjester.add(new Gjest("Giridhar C.", "Srinivasan", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, einar));
        gjester.add(new Gjest("Ivar Olav", "Tryti", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, einar));
        gjester.add(new Gjest("Nicola", "Muneratto", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, einar));

        // Halldis
        gjester.add(new Gjest("Anders", "Langseth", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, halldis));
        //gjester.add(new Gjest("Lars Henrik", "Nordli", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, halldis ));
        gjester.add(new Gjest("Kristian", "Haugen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, halldis));
        gjester.add(new Gjest("Carl Erik", "Hauge", Transport.BIL, Aktivitetsdeltagelse.NEI, halldis));

        // Gjermund
        gjester.add(new Gjest("Helene", "Kristiansen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, gjermund));
        gjester.add(new Gjest("Simone", "Andersson", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, gjermund));
        gjester.add(new Gjest("Gry", "Skårbø", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, gjermund));

        // Ingrid
        gjester.add(new Gjest("Anniken", "Nordby", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, ingrid));
        gjester.add(new Gjest("Hilde", "Bakkemyr", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, ingrid));
        gjester.add(new Gjest("Ekaterina", "Orlova", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.NEI, ingrid));
        gjester.add(new Gjest("Jenny", "Le", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, ingrid));

        // Sigurd
        gjester.add(new Gjest("Igor", "Erokhin", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sigurd));
        gjester.add(new Gjest("Ingleiv", "Johansen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, sigurd));
        gjester.add(new Gjest("Petter B.", "Hannevold", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sigurd));
        gjester.add(new Gjest("Aleksander", "Nybakk", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.NEI, sigurd));

        // Hallgeir
        gjester.add(new Gjest("Karl Jørgen", "Overå", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, hallgeir));
        gjester.add(new Gjest("Henning", "Ringerike", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, hallgeir));
        gjester.add(new Gjest("Martin", "Almvik", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, hallgeir));
        gjester.add(new Gjest("Hans Fredrik", "Brastad", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, hallgeir));

        // Bjørnehiet
        gjester.add(new Gjest("Vijay", "Shanmugappirabu", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, bjornehiet));
        gjester.add(new Gjest("Daniel", "Meinecke", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, bjornehiet));
        gjester.add(new Gjest("Stefan", "Jøines", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, bjornehiet));
        gjester.add(new Gjest("Johan E.", "Larsson", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, bjornehiet));
        gjester.add(new Gjest("Tommy", "Ballestad", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, bjornehiet));

        // Kåre
        gjester.add(new Gjest("Espen", "Gudmundsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, kaare));
        gjester.add(new Gjest("Magnus", "Brurås", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, kaare));
        gjester.add(new Gjest("Lars", "Skjæveland", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.NEI, kaare));

        // Klatrer'n
        gjester.add(new Gjest("Trine", "Grønvold", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, klatrer));
        gjester.add(new Gjest("Kosovare", "Olluri", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, klatrer));
        gjester.add(new Gjest("Berit", "Hatten", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, klatrer));
        gjester.add(new Gjest("Unni", "Vørrang", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, klatrer));

        // Klatrer'n 2
        gjester.add(new Gjest("Ramon", "Arellano", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, klatrer2));
        gjester.add(new Gjest("Erik", "Gjerdrum", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, klatrer2));
        gjester.add(new Gjest("Daniel", "Ham", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, klatrer2));

        // Kvisten
        gjester.add(new Gjest("Aleksander", "Gjermundsen", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, kvisten));
        gjester.add(new Gjest("Delshad", "Faraj", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, kvisten));

        // Kammerset
        gjester.add(new Gjest("Tonny", "Gundersen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, kammerset));

        // Trevet
        gjester.add(new Gjest("Therese", "Børter", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, trevet));
        gjester.add(new Gjest("Inger", "Hansen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, trevet));

        // Vogga
        gjester.add(new Gjest("Morten", "Meyer", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, vogga));

        // Stuggua
        gjester.add(new Gjest("Ivar", "Gjessing", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, stuggua));
        gjester.add(new Gjest("Jan Erik", "Skogsfjord", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, stuggua));
        gjester.add(new Gjest("Erik", "Hidle", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, stuggua));

        // Stallen
        gjester.add(new Gjest("Shahariar K.", "Bhuiyan", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, stallen));
        gjester.add(new Gjest("Greger Siem", "Knudsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, stallen));
        gjester.add(new Gjest("Andreas", "Næss", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, stallen));

        // Kvilsten
        gjester.add(new Gjest("Anita", "Opheim", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kvilsten));
        gjester.add(new Gjest("Anisha", "Kejriwal", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, kvilsten));
        gjester.add(new Gjest("Karin", "Rustenberg", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, kvilsten));
        //gjester.add(new Gjest("Radha", "Rajagopalan", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kvilsten ));
        //gjester.add(new Gjest("Heidi-Christin", "Bernhoff-Jacobsen", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kvilsten ));

        // Risbiten
        gjester.add(new Gjest("Ismar", "Slomic", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, risbiten));
        gjester.add(new Gjest("Tor Arne", "Rudlende", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, risbiten));
        gjester.add(new Gjest("Vidar", "Methi", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, risbiten));
        gjester.add(new Gjest("Rafael", "Trzaskowski", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, risbiten));
        gjester.add(new Gjest("Vidar Lie", "Johansen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, risbiten));

        return gjester;
    }
}
