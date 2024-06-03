package org.training.product.controller;

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
import org.training.product.model.dto.ProductDto;
import org.training.product.model.dto.Response;
import org.training.product.service.ProductService;
import org.training.product.utills.MasterData;

import java.util.List;

import static org.training.product.utills.TestUtils.*;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    @Test
    void addProduct() throws Exception {
        Response expectedResult = new Response("200", "Product successfully added.");
        Mockito.when(productService.addProduct(MasterData.getProductDto())).thenReturn(expectedResult);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/products/create")
                .content(MasterData.asJsonString(MasterData.getProductDto())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(expectedResult), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(Response.builder()
                                .message("Product created successfully").responseCode("200").build())),
                businessTestFile);
    }

    @Test
    void getProductListByOwnerId() throws Exception {
        List<ProductDto> productDto = List.of(MasterData.getProductDto());
        Mockito.when(productService.getProductByOwnerId(1L)).thenReturn(productDto);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/products/owner/1")
                .content(MasterData.asJsonString(MasterData.getProductDto())).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(productDto), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(Response.builder()
                                .message("User created successfully").responseCode("200").build())),
                businessTestFile);
    }

}