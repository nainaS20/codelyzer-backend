package com.accolite.codelyzer.requestbody;

import com.accolite.codelyzer.model.Answer;
import com.accolite.codelyzer.model.Option;
import com.accolite.codelyzer.model.Tag;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class QuestionBody {
    private String description;
    private String questionType;
    private String groupName;
    private List<String> tagSet;
    private List<String> options;
    private List<String> answers;
}
