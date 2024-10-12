package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.Account;
import java.util.*;

//workspace/dshane1903-pep-spring-project/src/main/java/com/example/entity/Account.java
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    public Optional<Account> findByUsernameAndPassword(String username, String password);
    public Optional<Account> findByUsername(String username);
}
