package cn.pku.timetracker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commontask")
public class CommonTask extends BaseEntity<CommonTask> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;
    @Column(name = "task_name", nullable = false)
    private String taskName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "tag_id")
    private String tagId;

}
