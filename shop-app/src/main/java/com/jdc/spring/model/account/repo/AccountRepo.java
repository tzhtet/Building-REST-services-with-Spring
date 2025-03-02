package com.jdc.spring.model.account.repo;

import java.util.Optional;
import java.util.UUID;

import com.jdc.spring.model.BaseRepository;
import com.jdc.spring.model.account.entity.Account;

public interface AccountRepo extends BaseRepository<Account, UUID> {
	
	Optional<Account> findOneByEmail(String email);

}
