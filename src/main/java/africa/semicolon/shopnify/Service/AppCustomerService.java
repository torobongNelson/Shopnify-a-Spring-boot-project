package africa.semicolon.shopnify.Service;

import africa.semicolon.shopnify.Dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.shopnify.Dtos.requests.UpdateCustomerRequest;
import africa.semicolon.shopnify.Dtos.responses.ApiResponse;
import africa.semicolon.shopnify.Dtos.responses.CustomerRegistrationResponse;
import africa.semicolon.shopnify.Dtos.responses.UpdateCustomerResponse;
import africa.semicolon.shopnify.Exceptions.CustomerNotFoundException;
import africa.semicolon.shopnify.Models.Customer;
import africa.semicolon.shopnify.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppCustomerService implements CustomerService{
    private final CustomerRepository customerRepository;
    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest request) {
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setPassword(request.getPassword());
        customerRepository.save(customer);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setId(savedCustomer.getId());
        return response;
    }

    @Override
    public ApiResponse<UpdateCustomerResponse> updateCustomer(Long id, UpdateCustomerRequest updateRequest) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(String.format("Customer with id %d not found",id)));

        customer.setEmail(updateRequest.getEmail());
        customer.setAddress(updateRequest.getAddress());
        customer.setPhoneNumber(updateRequest.getPhoneNumber());

        customerRepository.save(customer);

        UpdateCustomerResponse response = new UpdateCustomerResponse();
        response.setMessage("Account updated successfully");
        return new ApiResponse<>(response);
    }
}
