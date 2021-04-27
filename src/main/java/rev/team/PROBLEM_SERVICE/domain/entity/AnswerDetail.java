package rev.team.PROBLEM_SERVICE.domain.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table(name="answer_detail")
public class AnswerDetail {
    //기록 상세
    //한 문제씩 푸는것도 여기다가 저장할 예정

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long questionId; // 문제 ID

    private boolean isCorrect; //정답 여부 필요할 것 같음

    private Long answerMainId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answerMainId", insertable=false, updatable=false)
    @JsonIgnore
    private AnswerMain answerMain;

    @OneToMany(mappedBy = "detail", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AnswerChoice> choices; // 선택한 답안
}
