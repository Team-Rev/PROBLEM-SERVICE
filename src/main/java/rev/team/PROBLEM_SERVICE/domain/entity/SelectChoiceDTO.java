package rev.team.PROBLEM_SERVICE.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class SelectChoiceDTO {
    private Set<Long> ids;
}
