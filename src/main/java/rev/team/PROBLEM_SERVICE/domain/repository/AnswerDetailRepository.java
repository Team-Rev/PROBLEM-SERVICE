package rev.team.PROBLEM_SERVICE.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rev.team.PROBLEM_SERVICE.domain.entity.AnswerDeatil;

@Repository
public interface AnswerDetailRepository extends JpaRepository<AnswerDeatil, Long> {

}
