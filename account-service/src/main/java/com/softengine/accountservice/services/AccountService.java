package com.softengine.accountservice.services;

import com.softengine.accountservice.entity.Account;
import com.softengine.accountservice.repository.AccountRepository;
import com.softengine.contract.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDTO get(String id){
        Optional<Account> account = accountRepository.findByUsername(id);
        AccountDTO accountDTO = new AccountDTO();
        account.ifPresent((a)->{
            modelMapper.map(a,accountDTO);
        });
        account.orElseThrow(()->new IllegalArgumentException());

        return accountDTO;
    }

    public AccountDTO save(Account accountDTO){
        AccountDTO account = new AccountDTO();
        Account savedAccount = accountRepository.save(accountDTO);
        modelMapper.map(savedAccount,account);
//        accountDTO.setId(savedAccount.getId());
        return account;
    }

    public Account updateAccound(String id, AccountDTO accountDTO){
        get(id);
        Account account = new Account();
        modelMapper.map(accountDTO,account);
        return accountRepository.save(account);
    }

    public void delete(String id){
        AccountDTO accountDTO = get(id);
        Account account = new Account();
        modelMapper.map(accountDTO,account);
        accountRepository.delete(account);
    }

    public List<AccountDTO> paginationa(Pageable pageable){
        List<AccountDTO> returnPage = new ArrayList<>();
        AccountDTO accountDTO = new AccountDTO();
        Slice<Account> account = accountRepository.findAll(pageable);
        account.stream().forEach(i->{
            modelMapper.map(i,accountDTO);
            returnPage.add(accountDTO);
        });
        return returnPage;
    }

}
