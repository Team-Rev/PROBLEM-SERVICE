package rev.team.PROBLEM_SERVICE.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class RelationCategoryId implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="question_id")
    private Question question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="category_id")
    private Category category;

}
