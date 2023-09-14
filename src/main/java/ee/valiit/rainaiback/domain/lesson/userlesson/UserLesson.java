package ee.valiit.rainaiback.domain.lesson.userlesson;

import ee.valiit.rainaiback.business.status.UserLessonStatus;
import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_lesson")
public class UserLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    public UserLesson() {
    }

    public UserLesson(User user, Lesson lesson) {
        this.user = user;
        this.lesson = lesson;
        this.status = UserLessonStatus.UNREAD.getLetter();
    }
}