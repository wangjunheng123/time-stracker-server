package cn.pku.timetracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task extends BaseEntity<Task> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;

    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "is_self_add")
    private Boolean isSelfAdd;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
