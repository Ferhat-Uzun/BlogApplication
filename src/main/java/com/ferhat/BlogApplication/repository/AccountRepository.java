package com.ferhat.BlogApplication.repository;

import com.ferhat.BlogApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
