package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
//    public User findByAccountType()
//
//    Optional<User> findByUsername(String username);
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);

    Optional<User> findById(Long id);
    @Query(value = "SELECT tc_users.* FROM tc_user_user inner join tc_users on tc_user_user.manageduserid=tc_users.id where tc_user_user.userid = :userId ", nativeQuery = true)
    public List<User> getActiveAndInactiveChildrenOfUser(@Param("userId") Long userId);

}