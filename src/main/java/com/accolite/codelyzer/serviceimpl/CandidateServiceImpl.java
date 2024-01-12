package com.accolite.codelyzer.serviceimpl;

import com.accolite.codelyzer.model.Candidate;
import com.accolite.codelyzer.repository.CandidateRepo;
import com.accolite.codelyzer.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepo candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
    public Candidate createAndAddCandidate(String Cname, String candidateEmail, String phoneNo, Integer YOE) {
        Candidate newCandidate = new Candidate();
        newCandidate.setCname(Cname);
        newCandidate.setCandidateEmail(candidateEmail);
        newCandidate.setPhoneNo(phoneNo);
        newCandidate.setYOE(YOE);

        return candidateRepository.save(newCandidate);
    }

//    public void deleteCandidate(Long id) {
//        candidateRepository.deleteById(id);
//    }
}

