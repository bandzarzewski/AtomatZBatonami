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

import static org.mockito.Mockito.verify;

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
    verify(kasa).insertDollar(); // Mockito sprawdz czy w klasie "kasa" został wlozony dollar

        checkIfRetrunChangeandNoMoreInteraction();

    }

    private void checkIfRetrunChangeandNoMoreInteraction() {
        verify(kasa).getChange();
        Mockito.verifyNoMoreInteractions(kasa);
    }

    @Test
    public void kiedWkladamyQuarterKasaGoPrzyjmie(){
        testObject.execute("Q");
        verify(kasa).insertQuarter();
        checkIfRetrunChangeandNoMoreInteraction();
    }

    // N
    // d
    @Test
    public void kiedyWloze2RozneMonetyKasaJePrzyjela(){
        testObject.execute("DQ");
        verify(kasa).insertQuarter();
        verify(kasa).insertDollar();

        checkIfRetrunChangeandNoMoreInteraction();
    }
    @Test
    public void kiedyWloze2RozneMonetyNdKasaJePrzyjela(){
        testObject.execute("Nd");
        verify(kasa).insertNikiel();
        verify(kasa).insertCent();

        checkIfRetrunChangeandNoMoreInteraction();
    }

    @Test
    public void kiedyWloze2DollaryKasaMaJePrzyjac(){
        testObject.execute("DD");
        verify(kasa,Mockito.times(2)).insertDollar();// w tym miejscu sprawdzamy czy zostala wywolana dwa razy

        checkIfRetrunChangeandNoMoreInteraction();
    }

    // (DDQNdQDNd -> czy metoda zadziała  )

    @Test
    public void kiedyWłozeDolaraIWybioreProduktNaKotregoMnieNieStacDostaneGoSpwrotem(){
        Mockito.when(kasa.getChange()).thenReturn("D"); // kiedy warunke sie pojawi to wykonaj ... // kiedy poajwi sie polecenie zwroc reszte to zwroc kase
        String result=testObject.execute("DA");
        // sprawdzamy do dostalimsy na wyjsciu z funkcji
        verify(kasa).insertDollar();
        checkIfRetrunChangeandNoMoreInteraction();
        Assert.assertEquals("D",result);

    }

}




