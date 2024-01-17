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
@Table(name = "task")
public class Task extends BaseEntity<Task> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;
    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "task_set_id")
    private String taskSetId;

}
