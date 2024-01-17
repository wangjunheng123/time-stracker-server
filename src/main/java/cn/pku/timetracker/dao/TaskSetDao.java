package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.TaskSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskSetDao extends JpaRepository<TaskSet,String> {

}
