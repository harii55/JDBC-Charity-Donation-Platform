package test;

import main.java.com.charityapp.dto.PaymentMethodDTO;
import main.java.com.charityapp.enums.PaymentMethodType;
import main.java.com.charityapp.service.PaymentMethodService;

import java.util.List;

public class PaymentMethodTest {
    public static void main(String[] args) throws Exception {
        PaymentMethodService service = new PaymentMethodService();

        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setDonorId(1);
        dto.setMethodType(PaymentMethodType.valueOf("CARD"));

        dto.setDetails("{\"UPI NUMBER\":\"**** **** 1234\"}");
        dto.setActive(true);

        boolean created = service.addPaymentMethod(dto);
        System.out.println("Created: " + created);

        List<PaymentMethodDTO> list = service.getPaymentMethodsByDonorId(1);
        list.forEach(pm -> System.out.println(pm.getMethodType() + " → " + pm.getDetails()));

        if (!list.isEmpty()) {
            boolean deactivated = service.deactivatePaymentMethod(list.get(0).getPaymentMethodId());
            System.out.println("Deactivated: " + deactivated);
        } else {
            System.out.println("No payment methods found for donor.");
        }

    }
}
