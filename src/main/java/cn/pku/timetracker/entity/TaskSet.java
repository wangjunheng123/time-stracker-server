package cn.pku.timetracker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
public class Tag extends BaseEntity<Tag> implements Serializable {
    private static final long serialVersionUID = -1459660400121009230L;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @Column(name = "user_id", nullable = false)
    private String userId;

}
