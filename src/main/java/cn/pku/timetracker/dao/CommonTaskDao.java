package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.CommonTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonTaskDao extends JpaRepository<CommonTask,String> {
}
