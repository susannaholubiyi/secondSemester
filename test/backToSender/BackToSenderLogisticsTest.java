package backToSender;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BackToSenderLogisticsTest {
    @Test
    public void riderDelivers25Parcels_functionCalculatePaymentAs9000Test(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertEquals(9000, btsLogistics.paymentCalculator(25));

    }
    @Test
    public void riderDelivers80Parcels_functionCalculatesPaymentAs45000Test(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertEquals(45000, btsLogistics.paymentCalculator(80));
    }
    @Test
    public void riderDelivers50Parcels_functionCalculatesPaymentAs15000Test(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertEquals(15000, btsLogistics.paymentCalculator(50));
    }
    @Test
    public void riderDelivers62Parcels_functionCalculatesPaymentAs20500Test(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertEquals(20500, btsLogistics.paymentCalculator(62));
    }
    @Test
    public void riderDelivers0Parcels_functionCalculatesPaymentAs5000Test(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertEquals(5000, btsLogistics.paymentCalculator(0));
    }
    @Test
    public void riderDeliversMinus10Parcels_illegalArgumentExceptionIsThrownTest(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertThrows(IllegalArgumentException.class, ()->btsLogistics.paymentCalculator(-10));
    }
    @Test
    public void riderDeliversMoreThan100Parcels_illegalArgumentExceptionIsThrownTest(){
        BackToSenderLogistics btsLogistics = new BackToSenderLogistics();
        assertThrows(IllegalArgumentException.class, ()->btsLogistics.paymentCalculator(105));
    }


}
