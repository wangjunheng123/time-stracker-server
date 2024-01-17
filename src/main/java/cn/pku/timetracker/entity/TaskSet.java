package cn.pku.timetracker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_set")
public class TaskSet extends BaseEntity<TaskSet> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;

    @Column(name = "task_set_name", nullable = false)
    private String taskSetName;

    @Column(name = "user_id", nullable = false)
    private String userId;

}
