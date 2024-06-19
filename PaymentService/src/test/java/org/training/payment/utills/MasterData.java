package org.training.payment.utills;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.training.payment.model.dto.PaymentDto;

public class MasterData {


    public static PaymentDto getPaymentDto() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderId(1L);
        paymentDto.setUserId(123L);
        paymentDto.setPaymentMethod("Order payment");
        paymentDto.setTotalAmount(1000L);
        return paymentDto;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
