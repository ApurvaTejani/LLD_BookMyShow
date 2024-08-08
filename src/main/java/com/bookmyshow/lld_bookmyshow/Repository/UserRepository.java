package com.bookmyshow.lld_bookmyshow.Repository;


import com.bookmyshow.lld_bookmyshow.Models.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<User> findById(Integer integer);

    Optional<User> findUserByEmail(String email);
}
