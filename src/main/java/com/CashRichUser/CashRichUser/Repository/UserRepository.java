package com.CashRichUser.CashRichUser.Repository;

import com.CashRichUser.CashRichUser.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName=:username")
    User findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u where u.email=:email")
    User findByEmail(@Param("email") String email);
}
