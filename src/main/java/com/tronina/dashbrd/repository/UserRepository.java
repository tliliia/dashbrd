package com.tronina.dashbrd.repository;


import com.tronina.dashbrd.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByLogin(String login);
}
