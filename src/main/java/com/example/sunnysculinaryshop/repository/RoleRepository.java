package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Role;
import com.example.sunnysculinaryshop.model.entity.enums.RolesNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleByRole(RolesNameEnum role);
}
