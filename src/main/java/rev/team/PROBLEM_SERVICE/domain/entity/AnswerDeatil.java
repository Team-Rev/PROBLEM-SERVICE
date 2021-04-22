package rev.team.PROBLEM_SERVICE.domain.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name="answer_deatil")
public class AnswerDeatil {
    //기록 상세
    //한 문제씩 푸는것도 여기다가 저장할 예정

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long questionId; // 문제 ID

    private Long answerMainId; // 시험 ID

    private String choose; // 선택한 답

    private boolean isCorrect; //정답 여부 필요할 것 같음
}
