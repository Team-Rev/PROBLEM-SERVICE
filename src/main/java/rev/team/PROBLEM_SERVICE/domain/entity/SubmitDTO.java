package rev.team.PROBLEM_SERVICE.domain.entity;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SubmitDTO {

    private Long userId;

    List<Submit> submitList;
}
