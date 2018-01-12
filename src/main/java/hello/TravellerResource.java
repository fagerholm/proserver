package hello;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
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

        // Storskogen 1. etg
        Rom klatrer = new Rom("Klatrer'n", "Storskogen 1.etg", 4);
        Rom klatrer2 = new Rom("Nye Klatrer'n", "Storskogen 1.etg", 4);

        // Storskogen 2. etg
        Rom revehiet = new Rom("Revehiet", "Storskogen 2.etg", 4);
        Rom jervehiet = new Rom("Jervehiet", "Storskogen 2.etg", 4);
        Rom ulvehiet = new Rom("Ulvehiet", "Storskogen 2.etg", 4);
        Rom gaupehiet = new Rom("Gaupehiet", "Storskogen 2.etg",4);
        Rom bjornehiet = new Rom("Bjørnehiet", "Storskogen 2.etg", 4);
        Rom einar = new Rom("Einar", "Storskogen 2.etg", 4);
        Rom halldis = new Rom("Halldis", "Storskogen 2.etg", 4);
        Rom gjermund = new Rom("Gjermund", "Storskogen 2.etg", 4);
        Rom ingrid = new Rom("Ingrid", "Storskogen 2.etg", 4);
        Rom sigurd = new Rom("Sigurd", "Storskogen 2.etg", 4);
        Rom hallgeir = new Rom("Hallgeir", "Storskogen 2.etg", 4);
        Rom elling = new Rom("Elling", "Storskogen 2.etg", 4);
        Rom kaare = new Rom("Kåre", "Storskogen 2.etg", 4);

        // Vesleskogen 1. etg
        Rom knetta = new Rom("Knetta", "Vesleskogen 1.etg", 4);
        Rom ugla = new Rom("Ugla", "Vesleskogen 1.etg", 4);
        Rom andoren = new Rom("Andoren", "Vesleskogen 1.etg", 4);
        Rom pulken = new Rom("Pulken", "Vesleskogen 1.etg", 4);


        // Vesleskogen 2. etg
        Rom sov1 = new Rom("Sov 1", "Vesleskogen 2.etg", 4);
        Rom sov2 = new Rom("Sov 2", "Vesleskogen 2.etg", 4);
        Rom sov3 = new Rom("Sov 3", "Vesleskogen 2.etg", 4);
        Rom sov4 = new Rom("Sov 4", "Vesleskogen 2.etg", 4);
        Rom sov5 = new Rom("Sov 5", "Vesleskogen 2.etg", 4);
        Rom sov6 = new Rom("Sov 6", "Vesleskogen 2.etg", 4);
        Rom sov7 = new Rom("Sov 7", "Vesleskogen 2.etg", 4);
        Rom sov8 = new Rom("Sov 8", "Vesleskogen 2.etg", 4);


        List<Gjest> gjester = new ArrayList<Gjest>();

        // Klatrer'n
        gjester.add(new Gjest("Daniel", "Tafjord", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, klatrer));
        gjester.add(new Gjest("Adam", "Asskali", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, klatrer));
        gjester.add(new Gjest("Martin", "Laupet", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, klatrer));
        gjester.add(new Gjest("Paul Pacoma", "Sørensen", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, klatrer));

        // Nye Klatrer'n
        gjester.add(new Gjest("Vidar Lie", "Johannesen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, klatrer2));
        gjester.add(new Gjest("Vidar", "Methi", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, klatrer2));
        gjester.add(new Gjest("Tor Arne", "Rudlende", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, klatrer2));

        // Revehiet
        gjester.add(new Gjest("Ørjan", "Johansen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, revehiet));
        gjester.add(new Gjest("Fredrik", "Bjørnøy", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, revehiet));
        gjester.add(new Gjest("Jørgen", "Ringen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, revehiet));
        gjester.add(new Gjest("Kjell Olav", "Dale", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, revehiet));

        // Jervehiet
        gjester.add(new Gjest("Stian", "Neverdal", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, jervehiet));
        gjester.add(new Gjest("Lars", "Skjæveland", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, jervehiet));
        gjester.add(new Gjest("Magnus", "Brurås", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, jervehiet));

        // Ulvehiet
        gjester.add(new Gjest("Espen", "Moen", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, ulvehiet));
        gjester.add(new Gjest("Mayurathan", "Thiruchelvam", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, ulvehiet));
        gjester.add(new Gjest("Jacob", "Meidell", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, ulvehiet));

        // Gaupehiet
        gjester.add(new Gjest("Hans Fredrik", "Fahle", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, gaupehiet));
        gjester.add(new Gjest("Ole C.", "Hansrud", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, gaupehiet));
        gjester.add(new Gjest("Ole", "Schreuder", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, gaupehiet));

        // Bjørnehiet
        gjester.add(new Gjest("Hans", "Hallaråker", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, bjornehiet));
        gjester.add(new Gjest("Michael L.", "Magnussen", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, bjornehiet));
        gjester.add(new Gjest("Morten", "Normann", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, bjornehiet));

        // Einar
        gjester.add(new Gjest("Giridhar", "Srinivasan", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, einar));
        gjester.add(new Gjest("Dejan", "Maric", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, einar));
        gjester.add(new Gjest("Martin", "Almvik", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, einar));

        // Halldis
        gjester.add(new Gjest("Neringa", "Altanaite", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, halldis));
        gjester.add(new Gjest("Heidi", "Bernhoff", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, halldis ));
        gjester.add(new Gjest("Gabriella", "Elvin", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, halldis));
        gjester.add(new Gjest("Eva Maria", "Dahlø", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, halldis));

        // Gjermund
        gjester.add(new Gjest("Vijay", "Shanmugappirabu", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, gjermund));
        gjester.add(new Gjest("Joakim", "Jacobsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, gjermund));
        gjester.add(new Gjest("Tony", "Chau", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, gjermund));

        // Ingrid
        gjester.add(new Gjest("Delshad", "Faraj", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, ingrid));
        gjester.add(new Gjest("Ivar", "Gjessing", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, ingrid));
        gjester.add(new Gjest("Entri", "Kontra", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, ingrid));
        gjester.add(new Gjest("Knut Erik", "Berg", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, ingrid));

        // Sigurd
        gjester.add(new Gjest("Rune A.", "Magnusson", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, sigurd));
        gjester.add(new Gjest("Martin", "Eskerud", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sigurd));
        gjester.add(new Gjest("Magne", "Nordås", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, sigurd));

        // Hallgeir
        gjester.add(new Gjest("Ingleiv", "Johansen", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, hallgeir));
        gjester.add(new Gjest("Anders", "Langset", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, hallgeir));
        gjester.add(new Gjest("Martin Kowalick", "Gran", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, hallgeir));

        // Elling
        gjester.add(new Gjest("Greger Siem", "Knudsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, elling));
        gjester.add(new Gjest("Andreas", "Næss", Transport.BIL, Aktivitetsdeltagelse.NEI, elling));
        gjester.add(new Gjest("Shahariar K.", "Bhuiyan", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, elling));
        gjester.add(new Gjest("Anders", "Kolstad", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, elling));

        // Kåre
        gjester.add(new Gjest("Shilpi J.", "Tomar", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kaare));
        gjester.add(new Gjest("Radha", "Rajagopalan", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kaare));
        gjester.add(new Gjest("Marte", "Jørgensen", Transport.BIL, Aktivitetsdeltagelse.JA, kaare));
        gjester.add(new Gjest("Unni", "Vørrang", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, kaare));

        // Sov 1
        gjester.add(new Gjest("Aleksander", "Nybakk", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sov1));
        gjester.add(new Gjest("Marcus André", "Ramberg", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, sov1));
        gjester.add(new Gjest("Håvard", "Andersen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sov1));

        // Sov 2
        gjester.add(new Gjest("Jan Frode", "Langtangen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, sov2));

        // Sov 3
        gjester.add(new Gjest("Hulda", "Seterås Fadnes", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, sov3));
        gjester.add(new Gjest("Kamilla", "Feyling", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, sov3));
        gjester.add(new Gjest("Lise Falch", "Monsen", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, sov3));

        // Sov 4
        gjester.add(new Gjest("Karin", "Rustenberg", Transport.BUSS_SEN, Aktivitetsdeltagelse.NEI, sov4));
        gjester.add(new Gjest("Anniken", "Nordby", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, sov4));
        gjester.add(new Gjest("Thea", "Udnes", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, sov4));

        // Sov 5
        gjester.add(new Gjest("Irene", "Mønnesland", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, sov5));
        gjester.add(new Gjest("Shkurte", "Olluri", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, sov5));

        // Sov 6
        gjester.add(new Gjest("Pia", "Lindstrøm", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, sov6));
        gjester.add(new Gjest("Petra", "Hatalová", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, sov6));

        // Sov 7
        gjester.add(new Gjest("Ingvard", "Olsen", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, sov7));
        gjester.add(new Gjest("Thomas R.", "Gabrielsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, sov7));

        // Sov 8
        gjester.add(new Gjest("Tor Erik", "Kvisle", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, sov8));
        gjester.add(new Gjest("Fredric", "Vallin", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, sov8));

        // Knetta
        gjester.add(new Gjest("Gry", "Skårbø", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, knetta));
        gjester.add(new Gjest("Ekaterina", "Orlova", Transport.BUSS_SEN, Aktivitetsdeltagelse.KANSKJE, knetta));
        gjester.add(new Gjest("Nina", "Kylstad", Transport.BIL, Aktivitetsdeltagelse.KANSKJE, knetta));

        // Ugla
        gjester.add(new Gjest("Jon André", "Fagerholm", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, ugla));
        gjester.add(new Gjest("Knut-Erik", "Johnsen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, ugla));

        // Andoren
        gjester.add(new Gjest("Inger", "Hansen", Transport.BUSS_SEN, Aktivitetsdeltagelse.JA, andoren));
        gjester.add(new Gjest("Liv", "Vestvik", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.KANSKJE, andoren));

        // Pulken
        gjester.add(new Gjest("Tonny", "Gundersen", Transport.BUSS_TIDLIG, Aktivitetsdeltagelse.JA, pulken));

        return gjester;
    }
}
