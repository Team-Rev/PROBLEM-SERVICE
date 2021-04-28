package rev.team.PROBLEM_SERVICE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.AnswerMain;
import rev.team.PROBLEM_SERVICE.domain.repository.AnswerMainRepository;

@Service
public class AnswerService {

    private final AnswerMainRepository answerMainRepository;

    @Autowired
    public AnswerService(AnswerMainRepository answerMainRepository){
        this.answerMainRepository = answerMainRepository;
    }

    public AnswerMain getAnswerRecord(Long id){
        return answerMainRepository.findById(id).orElse(null);
    }
}
