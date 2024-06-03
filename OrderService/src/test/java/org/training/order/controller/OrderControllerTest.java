package org.training.order.controller;

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
import org.training.order.model.dto.OrderDto;
import org.training.order.model.dto.Response;
import org.training.order.service.OrderService;
import org.training.order.utills.MasterData;

import java.util.List;

import static org.training.order.utills.TestUtils.*;

@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
class OrderControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;


    @Test
    void addOrder() throws Exception {
        Response expectedResult = new Response("200", "order successfully added.");
        Mockito.when(orderService.addOrder(MasterData.getOrderDto())).thenReturn(expectedResult);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/orders/create")
                .content(MasterData.asJsonString(MasterData.getOrderDto())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(expectedResult), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(Response.builder().message("Order created successfully").responseCode("200").build())),
                businessTestFile);
    }

    @Test
    void getOrderListByOwnerId() throws Exception {
        List<OrderDto> orderDto = List.of(MasterData.getOrderDto());
        Mockito.when(orderService.getOrderDetailsByUserId(1L)).thenReturn(orderDto);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/orders/1")
                .content(MasterData.asJsonString(MasterData.getOrderDto())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(orderDto), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(Response.builder()
                                .message("Order created successfully").responseCode("200").build())),
                businessTestFile);
    }

}