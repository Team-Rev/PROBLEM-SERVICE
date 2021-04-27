package rev.team.PROBLEM_SERVICE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.*;
import rev.team.PROBLEM_SERVICE.domain.repository.AnswerDetailRepository;
import rev.team.PROBLEM_SERVICE.domain.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerDetailRepository answerDetailRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository
            , AnswerDetailRepository answerDetailRepository){
        this.questionRepository = questionRepository;
        this.answerDetailRepository = answerDetailRepository;
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

    public AnswerMain submitQuestions(SubmitDTO submit) {
        System.out.println(submit.toString());
//        List<Submit> submits = submit.getSubmitList();
//        List<AnswerDeatil> details = new ArrayList<>();
//        AnswerMain main = AnswerMain.builder()
//            .userId(submit.getUserId())
//            .date(LocalDateTime.now())
//            .totalCount(submits.size())
//            .build();
//
//        for(Submit s : submits){
//            Optional<Question> temp = questionRepository.findById(s.getQuestionId());
//
//            temp.ifPresent(question -> details.add(this.grading(s, question, main.getUserId())));
//        }
//
//
//        main.setCorrectCount( (int)details.stream().filter(AnswerDeatil::isCorrect).count() );
//        answerDetailRepository.saveAll(details);
        return AnswerMain.builder().build();//main;
    }


    public void submitQuestion(Long id, Question question) {
        //TODO: 해당 문제 정답 체크해서 기록하기
    }

    //문제 ID 범위로 가져오기
    public List<Question> rangeQuestions(Long start ,Long end){
        return questionRepository.findByIdIsBetween(start,end);
    }

    public AnswerDetail grading(Submit submit, Question question, Long answerMainId){
//        Boolean isCorrect = true;
//
//        Set<String> answers = submit.getAnswer();
//        Set<MultipleChoice> choiceSet = question.getChoices();
//
//        for(String answer : answers){
//            isCorrect = isCorrect && choiceSet.stream().filter(e -> e.getChoice().equals(answer)).findFirst().orElse(new MultipleChoice()).getIsCorrect();
//        }
        return AnswerDetail.builder()
//                .questionId(submit.getQuestionId())
//                .answerMainId(answerMainId)
//                .choose(submit.getAnswer())
//                .isCorrect(isCorrect)
                .build();
    }
}
