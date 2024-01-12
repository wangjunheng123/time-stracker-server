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
@Table(name = "friendship")
public class Friendship {
    @Id
    @Column(name = "friendship_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String friendshipId;

    @Column(name = "friend_description")
    private String friendDescription;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "friend_id", nullable = false)
    private String friendId;
}
