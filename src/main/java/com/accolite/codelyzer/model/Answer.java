package com.accolite.codelyzer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String selectedAnswer;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", selectedAnswer='" + selectedAnswer + '\'' +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
