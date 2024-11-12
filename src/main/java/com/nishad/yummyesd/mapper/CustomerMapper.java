package com.nishad.yummyesd.mapper;

import com.nishad.yummyesd.dto.CustomerRequest;
import com.nishad.yummyesd.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
}
