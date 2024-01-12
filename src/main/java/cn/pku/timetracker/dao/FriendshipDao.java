package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipDao extends JpaRepository<Friendship,String> {
}
