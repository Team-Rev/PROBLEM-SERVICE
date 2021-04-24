package rev.team.PROBLEM_SERVICE.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.AnswerDeatil;
import rev.team.PROBLEM_SERVICE.domain.entity.Question;
import rev.team.PROBLEM_SERVICE.domain.entity.Submit;
import rev.team.PROBLEM_SERVICE.domain.repository.AnswerDetailRepository;
import rev.team.PROBLEM_SERVICE.service.QuestionService;

@Service
public class GradingManager {

    public AnswerDeatil grading(Submit submit, Question question, Long answerMainId){
        return AnswerDeatil.builder()
                .questionId(submit.getQuestionId())
                .answerMainId(answerMainId)
                .choose(submit.getAnswer())
                .isCorrect(submit.getAnswer().equals(question.getAnswer()))
                .build();
    }
}
