package org.security.repository;

import org.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserNameRepository extends JpaRepository<User,String>
{
    Optional<User> findByUsername(String userName);
}
