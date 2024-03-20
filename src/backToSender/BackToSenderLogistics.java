package backToSender;
public class BackToSenderLogistics {
    int wage;
    public int paymentCalculator(Integer numberOfDeliveries) {
        validateNumberOfDeliveries(numberOfDeliveries);
        try {
            int basePay = 5000;
            wage = (getAmountPerParcel(numberOfDeliveries) * numberOfDeliveries) + basePay;
            return wage;
        }
        catch (Exception ignored){}
        return 0;
    }

    private static void validateNumberOfDeliveries(Integer numberOfDeliveries) {
        if (numberOfDeliveries < 0 || numberOfDeliveries >100){
            throw new IllegalArgumentException("Invalid input");
        }
    }

    private int getAmountPerParcel(Integer numberOfDeliveries) {
        if (numberOfDeliveries < 50) {
            return 160;
        } else if (numberOfDeliveries < 60) {
            return 200;
        } else if (numberOfDeliveries < 70) {
            return 250;
        } else {
            return 500;
        }
    }
}
