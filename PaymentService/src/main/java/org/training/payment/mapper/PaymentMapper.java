package org.training.payment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.entity.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "paymentId", target = "id")
    Payment toEntity(PaymentDto paymentDto);

    @Mapping(source = "id", target = "paymentId")
    PaymentDto toDto(Payment payment);

}
