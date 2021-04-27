package rev.team.PROBLEM_SERVICE.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "answer_choice")
public class AnswerChoice implements Serializable{

    @Id
    private Long answerDetailId;

    @Id
    private Long multipleChoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answerDetailId", insertable=false, updatable=false)
    @JsonIgnore
    private AnswerDetail detail;
}
