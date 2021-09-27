package rev.team.PROBLEM_SERVICE.domain.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class RelationCategory {

    @EmbeddedId
    private RelationCategoryId id;

    private float score;
}
