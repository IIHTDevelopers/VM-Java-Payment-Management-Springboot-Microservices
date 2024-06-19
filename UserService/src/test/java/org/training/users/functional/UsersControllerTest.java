package org.training.users.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
import org.training.users.configuration.CustomUserDetailsService;
import org.training.users.controller.UserController;
import org.training.users.model.dto.Response;
import org.training.users.model.dto.UserDto;
import org.training.users.service.JwtService;
import org.training.users.service.UserService;
import org.training.users.testutils.MasterData;

import java.util.List;

import static org.training.users.testutils.TestUtils.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @MockBean
    private JwtService jwtService;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @Test
    @Disabled
    void createUser() throws Exception {
        UserDto userDto = MasterData.getUserDto();
        Response response = new Response("200","User created successfully");
        Mockito.when(userService.createUser(userDto)).thenReturn(response);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/users/register")
                .content(MasterData.asJsonString(userDto)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder).andReturn();

        Assertions.assertEquals(MasterData.asJsonString(response), mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(response)),
                businessTestFile);
    }

    @Test
    @Disabled
    void shouldGetList() throws Exception {
        Mockito.when(userService.getAllUsers()).thenReturn(List.of(MasterData.getUserDto()));
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/users/list")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString(),
                MasterData.asJsonString(List.of(MasterData.getUserDto())));
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(List.of(MasterData.getUserDto()))),
                businessTestFile);
    }


    @Test
    @Disabled
    void shouldGetUserProductInfoByUserId() throws Exception {
        Mockito.when(userService.getUserProductInfoByUserId(1L)).thenReturn(MasterData.getUserDto());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/users/productInfo/" + 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        Assertions.assertEquals(MasterData.asJsonString(MasterData.getUserDto()),
                mvcResult.getResponse().getContentAsString());
        yakshaAssert(currentTest(),
                mvcResult.getResponse().getContentAsString().contentEquals(
                        MasterData.asJsonString(List.of(MasterData.getUserDto()))),
                businessTestFile);
    }

}
