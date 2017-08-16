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
}

    @Test
    public void kiedWkladamyQuarterKasaGoPrzyjmie(){
        testObject.execute("Q");
        Mockito.verify(kasa).insertQuarter();
        Mockito.verifyNoMoreInteractions(kasa);
    }

}


