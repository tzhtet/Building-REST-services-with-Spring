package com.jdc.spring.model.repo;

import java.util.Optional;

import com.jdc.spring.model.BaseRepo;
import com.jdc.spring.model.entity.Account;

public interface AccountRepo extends BaseRepo<Account, Integer>{

	Optional<Account> findOneByLoginId(String username);

}
