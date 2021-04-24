package rev.team.PROBLEM_SERVICE.domain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.EnableMBeanExport;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String exam;

    @Column(columnDefinition = "TEXT")
    private String wrongAnswer;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @ColumnDefault("0")
    private Long totalCount;

    @ColumnDefault("0")
    private Long rightAnswerCount;
}
