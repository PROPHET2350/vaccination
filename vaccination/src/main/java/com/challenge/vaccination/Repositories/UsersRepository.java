package com.challenge.vaccination.Repositories;

import com.challenge.vaccination.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
