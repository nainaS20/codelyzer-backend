package com.accolite.codelyzer.serviceimpl;

import com.accolite.codelyzer.model.*;
import com.accolite.codelyzer.repository.GroupRepo;
import com.accolite.codelyzer.repository.QuestionRepo;
import com.accolite.codelyzer.repository.TagRepo;
import com.accolite.codelyzer.repository.UserRepo;
import com.accolite.codelyzer.requestbody.QuestionBody;
import com.accolite.codelyzer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TagRepo tagRepo;
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void createTag(String tagName) {
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagRepo.save(tag);
    }

    @Override
    public void createQuestion(QuestionBody questionBody) {
        Question question = new Question();
        Group group = groupRepo.findByGroupName(questionBody.getGroupName());
        question.setGroup(group);
        System.out.println(group);
        question.setQuestionType(questionBody.getQuestionType());
        question.setDescription(questionBody.getDescription());

        List<Tag> tagSet = tagRepo.findByTagNameIn(questionBody.getTagSet());
        List<Option> options = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        for(String curOption: questionBody.getOptions()){
            Option option = new Option();
            option.setOptionText(curOption);
            option.setQuestion((question));
            options.add(option);
        }
        for(String curAnswer: questionBody.getAnswers()){
            Answer answer = new Answer();
            answer.setSelectedAnswer(curAnswer);
            answer.setQuestion(question);
            answers.add(answer);
        }
        question.setOptions(options);
        question.setAnswers(answers);
        question.setTagSet(new HashSet<>(tagSet));
        for(Tag tag: tagSet){
            tag.getQuestionSet().add(question);
            tagRepo.save(tag);
        }
        questionRepo.save(question);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
