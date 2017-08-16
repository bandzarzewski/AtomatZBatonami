import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.nio.channels.Pipe;

public class VendingMachineTest {
@Mock
Kasa kasa;

@Mock
Produkty produkty;

AutomatZBatinami testObject=new AutomatZBatinami(kasa,produkty);

@Test

public void kiedWkladamyDolaraKasaGoPrzyjmie(){
testObject.execute("D");
    Mockito.verify(kasa).insertDollar(); // Mockito sprawdz czy w klasie "kasa" został wlozony dollar

}
}


