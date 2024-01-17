package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonTaskDao extends JpaRepository<Task,String> {
}
