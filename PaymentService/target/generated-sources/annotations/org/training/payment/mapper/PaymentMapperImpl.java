package org.training.payment.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.entity.Payment;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-03T15:19:22+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentDto.getPaymentId() );
        payment.setCreditCardNumber( paymentDto.getCreditCardNumber() );
        payment.setOrderId( paymentDto.getOrderId() );
        payment.setPaymentMethod( paymentDto.getPaymentMethod() );
        payment.setTotalAmount( paymentDto.getTotalAmount() );
        payment.setUserId( paymentDto.getUserId() );

        return payment;
    }

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setPaymentId( payment.getId() );
        paymentDto.setCreditCardNumber( payment.getCreditCardNumber() );
        paymentDto.setOrderId( payment.getOrderId() );
        paymentDto.setPaymentMethod( payment.getPaymentMethod() );
        paymentDto.setTotalAmount( payment.getTotalAmount() );
        paymentDto.setUserId( payment.getUserId() );

        return paymentDto;
    }
}
