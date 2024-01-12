package cn.pku.timetracker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name = "tag_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tagId;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @Column(name = "user_id", nullable = false)
    private String userId;
}
