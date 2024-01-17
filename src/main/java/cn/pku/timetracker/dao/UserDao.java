package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {

    boolean existsByUsername(String username);

    User findByUsername(String username);

    boolean existsByEmail(String email);
    

}
