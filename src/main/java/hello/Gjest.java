package hello;

public class Gjest {

    private String fornavn;
    private String etternavn;
    private Transport transport;
    private Aktivitetsdeltagelse aktivitetsdeltagelse;
    private Rom rom;


    public Gjest(String fornavn, String etternavn, Transport transport, Aktivitetsdeltagelse deltagelse, Rom rom) {

        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.transport = transport;
        this.aktivitetsdeltagelse = deltagelse;
        this.rom = rom;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public Transport getTransport() {
        return transport;
    }

    public Aktivitetsdeltagelse getAktivitetsdeltagelse() {
        return aktivitetsdeltagelse;
    }

    public Rom getRom() {
        return rom;
    }
}
