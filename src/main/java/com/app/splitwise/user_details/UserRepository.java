package com.app.splitwise.user_details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SplitwiseUserDetails, String> {

    SplitwiseUserDetails findByUserName(String userName);
}
