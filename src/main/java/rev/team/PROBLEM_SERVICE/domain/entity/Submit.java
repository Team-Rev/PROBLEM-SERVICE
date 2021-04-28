package rev.team.PROBLEM_SERVICE.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Submit {

    private Long questionId;
    private List<Long> multipleChoiceIds;
}
