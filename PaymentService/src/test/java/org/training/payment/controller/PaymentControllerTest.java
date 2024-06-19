package org.training.payment.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.training.payment.model.dto.PaymentDto;
import org.training.payment.model.dto.Response;
import org.training.payment.service.PaymentService;

import org.training.payment.utills.MasterData;
import java.util.List;

import static org.training.payment.utills.TestUtils.*;

@WebMvcTest(PaymentController.class)
@AutoConfigureMockMvc
class PaymentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;


    @Test
    void getPaymentListByOwnerId() throws Exception {
        List<PaymentDto> paymentDtoList = List.of(MasterData.getPaymentDto());
        Mockito.when(paymentService.getPaymentDetailsByUserId(1L)).thenReturn(paymentDtoList);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/payments/1")
                .content(MasterData.asJsonString(MasterData.getPaymentDto())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(paymentDtoList), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(List.of(MasterData.getPaymentDto()))),
                businessTestFile);
    }

}