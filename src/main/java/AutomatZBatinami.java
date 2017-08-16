
public class AutomatZBatinami {

    private final Kasa kasa;
    private final Produkty produkty;

    public AutomatZBatinami(Kasa kasa, Produkty produkty) {
        this.kasa = kasa;
        this.produkty = produkty;
    }

    public String execute(String input) {
       if(input.equals("D"))
       { kasa.insertDollar();
       }
       if(input.equals("Q")) {
       kasa.insertQuarter();}

        return null;
        
        
    }
}
