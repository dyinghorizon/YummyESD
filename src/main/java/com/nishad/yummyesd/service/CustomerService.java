package com.nishad.yummyesd.service;

import com.nishad.yummyesd.dto.CustomerRequest;
import com.nishad.yummyesd.dto.CustomerResponse;
import com.nishad.yummyesd.entity.Customer;
import com.nishad.yummyesd.mapper.CustomerMapper;
import com.nishad.yummyesd.repo.CustomerRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }
}

