package com.expert_coder.repository;

import com.expert_coder.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findUserByUsername(String username);
}
