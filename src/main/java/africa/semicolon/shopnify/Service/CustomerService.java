package africa.semicolon.shopnify.Service;

import africa.semicolon.shopnify.Dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.shopnify.Dtos.requests.UpdateCustomerRequest;
import africa.semicolon.shopnify.Dtos.responses.ApiResponse;
import africa.semicolon.shopnify.Dtos.responses.CustomerRegistrationResponse;
import africa.semicolon.shopnify.Dtos.responses.UpdateCustomerResponse;
import africa.semicolon.shopnify.Exceptions.CustomerNotFoundException;



public interface CustomerService {

    CustomerRegistrationResponse register(CustomerRegistrationRequest request);

    ApiResponse<UpdateCustomerResponse> updateCustomer(Long id, UpdateCustomerRequest updateRequest) throws CustomerNotFoundException;
}
