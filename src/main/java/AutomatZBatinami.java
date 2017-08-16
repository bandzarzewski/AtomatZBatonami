
public class AutomatZBatinami {

    private final Kasa kasa;
    private final Produkty produkty;

    public AutomatZBatinami(Kasa kasa, Produkty produkty) {
        this.kasa = kasa;
        this.produkty = produkty;
    }

    public String execute(String input) {
       if(input.contains("D"))
       { kasa.insertDollar();
       }
       if(input.contains("Q")) {
       kasa.insertQuarter();}

        if(input.contains("N"))
        { kasa.insertNikiel();
        }
        if(input.contains("d")) {
            kasa.insertCent();}

        return null;
        
        
    }
}
