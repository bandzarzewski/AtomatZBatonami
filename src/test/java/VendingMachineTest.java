import org.junit.Test;
import org.mockito.Mock;

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
}
}


