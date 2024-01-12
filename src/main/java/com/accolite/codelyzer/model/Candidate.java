package com.accolite.codelyzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Use the correct annotation from jakarta.persistence

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Cname;
    private String candidateEmail;
    private String phoneNo;

    public Long getId() {
        return id;
    }
    public Candidate(){
        //default;
    }

    public Candidate(Long id, String cname, String candidateEmail, String phoneNo, Integer YOE) {
        this.id = id;
        Cname = cname;
        this.candidateEmail = candidateEmail;
        this.phoneNo = phoneNo;
        this.YOE = YOE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getYOE() {
        return YOE;
    }

    public void setYOE(Integer YOE) {
        this.YOE = YOE;
    }

    private Integer YOE;

    // Constructors, getters, and setters...

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", Cname='" + Cname + '\'' +
                ", candidateEmail='" + candidateEmail + '\'' +
                ", phoneNo=" + phoneNo +
                ", YOE=" + YOE +
                '}';
    }
}
