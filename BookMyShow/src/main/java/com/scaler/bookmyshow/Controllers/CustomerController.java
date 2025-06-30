package com.scaler.bookmyshow.Controllers;

import com.scaler.bookmyshow.DTOS.CreateCustomerDTO;
import com.scaler.bookmyshow.Exceptions.InvalidCustomerException;
import com.scaler.bookmyshow.Models.BaseModel;
import com.scaler.bookmyshow.Models.Customer;
import com.scaler.bookmyshow.Services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static sun.security.util.KeyUtil.validate;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController extends BaseModel {

    private CustomerService customerService;
    //Get a customer
    // GET/customer/{id}
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
    //Create a customer
    // POST/customer
    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request){
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CreateCustomerDTO request){
        if(request.getEmail()==null){
            throw new InvalidCustomerException();
        }
    }
}
