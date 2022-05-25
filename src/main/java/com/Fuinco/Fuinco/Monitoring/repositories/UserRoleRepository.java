package com.Fuinco.Fuinco.Monitoring.repositories;

import com.Fuinco.Fuinco.Monitoring.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query(value = "SELECT * FROM tc_user_roles INNER JOIN tc_users ON tc_users.roleId = tc_user_roles.roleId "
            + "WHERE tc_users.id = :userId AND tc_users.delete_date IS NULL AND tc_user_roles.delete_date IS NULL"
            ,nativeQuery = true)
    List<UserRole> getUserRole(@Param("userId")Long userId);

}
