package rev.team.PROBLEM_SERVICE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.AnswerMain;
import rev.team.PROBLEM_SERVICE.domain.entity.Question;
import rev.team.PROBLEM_SERVICE.domain.entity.Submit;
import rev.team.PROBLEM_SERVICE.domain.entity.SubmitDTO;
import rev.team.PROBLEM_SERVICE.domain.repository.QuestionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    //한 문제 가져오기
    public Question getQuestion(Long id){
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> getRandomQuestions(){
        //TODO: 랜덤으로 하나씩 문제 풀꺼 범위 가져오기(풀었던 문제 억제, 취약점 반영)
        return new ArrayList<>();
    }
    public List<Question> getKeywordQuestions() {
        //TODO: 원하는 키워드 문제 가져오기(풀었던 문제 억제)
        return new ArrayList<>();
    }

    public List<Question> getTestQuestion() {
        //TODO: 처음 진단 평가(?)용 문제 가져오기
        return new ArrayList<>();
    }

    public String submitQuestions(SubmitDTO submit) {
        List<Submit> submits = submit.getSubmitList();
        AnswerMain main = AnswerMain.builder()
            .userId(submit.getUserId())
            .date(LocalDateTime.now())
            .totalCount(submits.size())
            .build();


        return "200";
    }


    public void submitQuestion(Long id, Question question) {
        //TODO: 해당 문제 정답 체크해서 기록하기
    }

    //문제 ID 범위로 가져오기
    public List<Question> rangeQuestions(Long start ,Long end){
        return questionRepository.findByIdIsBetween(start,end);
    }
}
