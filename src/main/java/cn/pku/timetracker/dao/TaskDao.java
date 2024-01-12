package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task,String> {

}
