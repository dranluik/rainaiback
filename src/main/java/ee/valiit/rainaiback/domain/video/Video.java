package ee.valiit.rainaiback.domain.video;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Size(max = 1000)
    @NotNull
    @Column(name = "link", nullable = false, length = 1000)
    private String link;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

}