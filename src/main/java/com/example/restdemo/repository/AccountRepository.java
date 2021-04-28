package com.example.restdemo.repository;

import com.example.restdemo.dto.AccountDto;
import com.example.restdemo.model.Account;

public interface AccountRepository extends CrudRepository<Account, AccountDto> {



}
