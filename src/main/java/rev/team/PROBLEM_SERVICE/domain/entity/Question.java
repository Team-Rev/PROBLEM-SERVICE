package rev.team.PROBLEM_SERVICE.domain.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private String mainCategory;

    @Column(columnDefinition = "TEXT")
    private String subCategory;

    @ColumnDefault("0")
    private Long totalCount;

    @ColumnDefault("0")
    private Long rightAnswerCount;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", foreignKey = @ForeignKey(name="id"))
    private Set<MultipleChoice> choices;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", updatable = false, insertable = false)
    private List<RelationCategory> relationCategories;
}
