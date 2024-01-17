package cn.pku.timetracker.dao;

import cn.pku.timetracker.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordDao extends JpaRepository<Record,String> {
    List<Record> findByUserId(String userId);
    List<Record> findByTaskId(String taskId);

}
