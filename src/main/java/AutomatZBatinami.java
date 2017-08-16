
public class AutomatZBatinami {

    private final Kasa kasa;
    private final Produkty produkty;

    public AutomatZBatinami(Kasa kasa, Produkty produkty) {
        this.kasa = kasa;
        this.produkty = produkty;
    }

    public String execute(String input) {
        for (int i = 0; i <input.length() ; i++) {

       if(input.charAt(i)=='D') // spradzamy co jest na i-pozycji
       { kasa.insertDollar();
       }
       if(input.charAt(i)=='Q') {
       kasa.insertQuarter();}

        if(input.charAt(i)=='N')
        { kasa.insertNikiel();
        }
        if(input.charAt(i)=='d') {
            kasa.insertCent();}
    }
        return kasa.getChange();
        
        
    }
}
