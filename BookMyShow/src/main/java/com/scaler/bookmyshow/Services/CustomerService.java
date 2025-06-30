package com.scaler.bookmyshow.Services;

import com.scaler.bookmyshow.DTOS.CreateCustomerDTO;
import com.scaler.bookmyshow.Exceptions.CustomerNotFoundException;
import com.scaler.bookmyshow.Exceptions.EmailAlreadyExistsException;
import com.scaler.bookmyshow.Models.Customer;
import com.scaler.bookmyshow.Models.User;
import com.scaler.bookmyshow.Repositories.interfaces.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(()-> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CreateCustomerDTO request) throws EmailAlreadyExistsException {

        //Validate if the email is not present
        //if present, throw an error
        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);
        if (existingCustomer.isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }

        //create the user
        User user = userService.createUser(request.getUsername(), request.getPassword());

        //create the customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .user(user)
                .build();
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerId){

        return customerRepository.getById(customerId);
    }


}
