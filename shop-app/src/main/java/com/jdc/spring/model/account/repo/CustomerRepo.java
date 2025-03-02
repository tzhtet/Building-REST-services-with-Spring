package com.jdc.spring.model.account.repo;

import java.util.UUID;

import com.jdc.spring.model.BaseRepository;
import com.jdc.spring.model.account.entity.Customer;

public interface CustomerRepo extends BaseRepository<Customer, UUID> {

}
