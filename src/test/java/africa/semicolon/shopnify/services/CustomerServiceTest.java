package africa.semicolon.shopnify.services;

import africa.semicolon.shopnify.Dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.shopnify.Dtos.requests.UpdateCustomerRequest;
import africa.semicolon.shopnify.Dtos.responses.ApiResponse;
import africa.semicolon.shopnify.Dtos.responses.CustomerRegistrationResponse;
import africa.semicolon.shopnify.Dtos.responses.UpdateCustomerResponse;
import africa.semicolon.shopnify.Exceptions.CustomerNotFoundException;
import africa.semicolon.shopnify.Service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    public void registerTest(){
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        CustomerRegistrationResponse response = customerService.register(request);

        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testUpdate() throws CustomerNotFoundException {
         UpdateCustomerRequest updateRequest = new UpdateCustomerRequest();
        updateRequest.setEmail("basseytoro@gmail.com");
        updateRequest.setAddress("312 hebert macaulay");
        updateRequest.setPhoneNumber("07034467923");

        ApiResponse<UpdateCustomerResponse> response = customerService.updateCustomer(1L,updateRequest);

        assertThat(response).isNotNull();
        assertThat(response.getData().getMessage()).isNotNull();


    }


}
