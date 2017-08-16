import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.mockito.runners.MockitoJUnitRunner;

import java.nio.channels.Pipe;

//@RunWith(MockitoJUnitRunner.class)
public class VendingMachineTest {

Kasa kasa;
Produkty produkty;
AutomatZBatinami testObject=new AutomatZBatinami(kasa,produkty);



@Before
public void init(){
    kasa=Mockito.mock(Kasa.class);
    produkty=Mockito.mock(Produkty.class);
    testObject=new AutomatZBatinami(kasa,produkty); // recznie stworzyslismy obiekt
}

    @Test
    public void kiedWkladamyDolaraKasaGoPrzyjmie(){
    testObject.execute("D");
    Mockito.verify(kasa).insertDollar(); // Mockito sprawdz czy w klasie "kasa" został wlozony dollar

        Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);

    }

    @Test
    public void kiedWkladamyQuarterKasaGoPrzyjmie(){
        testObject.execute("Q");
        Mockito.verify(kasa).insertQuarter();
                Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
    }

    // N
    // d
    @Test
    public void kiedyWloze2RozneMonetyKasaJePrzyjela(){
        testObject.execute("DQ");
        Mockito.verify(kasa).insertQuarter();
        Mockito.verify(kasa).insertDollar();

        Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
    }
    @Test
    public void kiedyWloze2RozneMonetyNdKasaJePrzyjela(){
        testObject.execute("Nd");
        Mockito.verify(kasa).insertNikiel();
        Mockito.verify(kasa).insertCent();

        Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
    }

    @Test
    public void kiedyWloze2DollaryKasaMaJePrzyjac(){
        testObject.execute("DD");
        Mockito.verify(kasa,Mockito.times(2)).insertDollar();// w tym miejscu sprawdzamy czy zostala wywolana dwa razy

        Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
    }

    // (DDQNdQDNd -> czy metoda zadziała  )

    @Test
    public void kiedyWłozeDolaraIWybioreProduktNaKotregoMnieNieStacDostaneGoSpwrotem(){
        Mockito.when(kasa.getChange()).thenReturn("D"); // kiedy warunke sie pojawi to wykonaj ... // kiedy poajwi sie polecenie zwroc reszte to zwroc kase
        String result=testObject.execute("DA");
        // sprawdzamy do dostalimsy na wyjsciu z funkcji
        Mockito.verify(kasa).insertDollar();
        Mockito.verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
        Assert.assertEquals("D",result);

    }

}




