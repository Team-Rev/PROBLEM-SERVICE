package rev.team.PROBLEM_SERVICE.domain.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String exam;

    @Column(columnDefinition = "TEXT")
    private String wrong_answer;

    @Column(columnDefinition = "TEXT")
    private String answer;
}
