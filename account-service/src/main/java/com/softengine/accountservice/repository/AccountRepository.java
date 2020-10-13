package com.softengine.accountservice.repository;

import com.softengine.accountservice.entity.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CassandraRepository<Account,String> {

    Optional<Account> findByUsername(String id);
}
