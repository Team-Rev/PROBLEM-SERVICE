package rev.team.PROBLEM_SERVICE.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rev.team.PROBLEM_SERVICE.domain.entity.RelationCategory;
import rev.team.PROBLEM_SERVICE.domain.entity.RelationCategoryId;

@Repository
public interface RelationCategoryRepository extends JpaRepository<RelationCategory, RelationCategoryId> {
}
