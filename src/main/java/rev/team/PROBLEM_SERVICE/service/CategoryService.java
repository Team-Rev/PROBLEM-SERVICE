package rev.team.PROBLEM_SERVICE.service;

import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.Category;
import rev.team.PROBLEM_SERVICE.domain.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
