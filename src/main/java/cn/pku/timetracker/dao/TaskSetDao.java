package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag,String> {

}
