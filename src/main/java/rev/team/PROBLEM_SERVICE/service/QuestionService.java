package rev.team.PROBLEM_SERVICE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.team.PROBLEM_SERVICE.domain.entity.*;
import rev.team.PROBLEM_SERVICE.domain.repository.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final MultipleChoiceRepository multipleChoiceRepository;
    private final AnswerMainRepository answerMainRepository;
    private final AnswerDetailRepository answerDetailRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository
            , MultipleChoiceRepository multipleChoiceRepository
            , AnswerMainRepository answerMainRepository
            , AnswerDetailRepository answerDetailRepository){

        this.questionRepository = questionRepository;
        this.multipleChoiceRepository = multipleChoiceRepository;
        this.answerMainRepository = answerMainRepository;
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

    @Transactional
    public AnswerMain submitQuestions(SubmitDTO submit) {
        List<Submit> submits = submit.getSubmitList();
        List<AnswerDetail> details = new ArrayList<>();

        AnswerMain main = AnswerMain.builder()
            .userId(submit.getUserId())
            .date(LocalDateTime.now())
            .totalCount(submits.size())
            .build();
        answerMainRepository.save(main);

        boolean nowCorrect;
        Set<AnswerChoice> answerChoiceHashSet;
        for(Submit nowSubmit : submits) {
            answerChoiceHashSet = new HashSet<>();
            nowCorrect = true;
            AnswerDetail detail = AnswerDetail.builder()
                    .questionId(nowSubmit.getQuestionId())
                    .answerMainId(main.getId())
                    .build();
            answerDetailRepository.save(detail);
            for(Long choiceId : nowSubmit.getMultipleChoiceIds()){
                System.out.println(choiceId + ", " + nowSubmit.getQuestionId());
                MultipleChoice choice = multipleChoiceRepository.findByIdAndQuestionId(choiceId, nowSubmit.getQuestionId()).orElse(null);
                if(choice == null){
                    nowCorrect = false;
                    break;
                }
                nowCorrect = nowCorrect && choice.getIsCorrect();
                answerChoiceHashSet.add(AnswerChoice.builder()
                        .answerDetailId(detail.getId())
                        .multipleChoiceId(choiceId)
                        .build());
            }
            detail.setCorrect(nowCorrect);
            detail.setChoices(answerChoiceHashSet);
            details.add(detail);
        }
        answerMainRepository.updateCorrect((int)details.stream().filter(AnswerDetail::isCorrect).count(), main.getId());
        answerDetailRepository.saveAll(details);
        return main;
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
