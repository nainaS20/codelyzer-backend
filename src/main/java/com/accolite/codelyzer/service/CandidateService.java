package com.accolite.codelyzer.service;
import com.accolite.codelyzer.model.Candidate;
import java.util.List;
import java.util.Optional;

public interface CandidateService {

    List<Candidate> getAllCandidates();

    Optional<Candidate> getCandidateById(Long id);

    Candidate saveCandidate(Candidate candidate);

    Candidate createAndAddCandidate(String Cname, String candidateEmail, String phoneNo, Integer YOE);
}

