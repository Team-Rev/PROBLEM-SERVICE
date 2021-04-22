package rev.team.PROBLEM_SERVICE.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="answer_main")
public class AnswerMain {
    //기록 메인

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId; // 푼 사용자 ID

    private LocalDateTime date; // 문제 푼 날

    private int totalCount;// 총 문제 갯수

    private int correctCount; // 맞힌 문제 갯수

}
