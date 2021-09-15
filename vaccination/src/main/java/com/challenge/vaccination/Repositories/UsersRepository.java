package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Users findByUsername(String username);
    Users findByUserid(String id);
    Users findByEmployeeEmployeeid(String id);
}
