package rev.team.PROBLEM_SERVICE.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rev.team.PROBLEM_SERVICE.domain.entity.RelationCategory;
import rev.team.PROBLEM_SERVICE.service.RelationCategoryService;

@RestController
@RequestMapping("/relation-category")
public class RelationCategoryController {

    private final RelationCategoryService relationCategoryService;

    public RelationCategoryController(RelationCategoryService relationCategoryService) {
        this.relationCategoryService = relationCategoryService;
    }

    @PostMapping("")
    public ResponseEntity<RelationCategory> createRelationCategory(@RequestBody RelationCategory relationCategory){
        return relationCategoryService.createRelationCategory(relationCategory);
    }
}
