package rev.team.PROBLEM_SERVICE.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.RelationCategory;
import rev.team.PROBLEM_SERVICE.domain.repository.RelationCategoryRepository;

@Service
public class RelationCategoryService {

    private final RelationCategoryRepository relationCategoryRepository;

    public RelationCategoryService(RelationCategoryRepository relationCategoryRepository) {
        this.relationCategoryRepository = relationCategoryRepository;
    }

    public ResponseEntity<RelationCategory> createRelationCategory(RelationCategory relationCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(relationCategoryRepository.save(relationCategory));
    }
}
