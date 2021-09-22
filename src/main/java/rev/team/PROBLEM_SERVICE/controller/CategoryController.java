package rev.team.PROBLEM_SERVICE.controller;

import org.springframework.web.bind.annotation.*;
import rev.team.PROBLEM_SERVICE.domain.entity.Category;
import rev.team.PROBLEM_SERVICE.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping("")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

}
