package com.softengine.accountservice.api;


import com.softengine.accountservice.entity.Account;
import com.softengine.accountservice.services.AccountService;
import com.softengine.contract.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * localhost:8080/account
 *
 * @author AB266391
 */
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable("id") String id) {
        AccountDTO account = accountService.get(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> save(@RequestBody Account account) {
        AccountDTO savedAccount = accountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable("id") String id, @RequestBody AccountDTO account) {
        Account savedAccount = accountService.updateAccound(id, account);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(String id) {
        accountService.delete(id);
        Account account = null;
    }

    @GetMapping("/getPageable")
    public ResponseEntity<List<AccountDTO>> pagination(Pageable pageable) {
        List<AccountDTO> response = accountService.paginationa(pageable);
        return new ResponseEntity<List<AccountDTO>>(response, HttpStatus.OK);
    }
}
