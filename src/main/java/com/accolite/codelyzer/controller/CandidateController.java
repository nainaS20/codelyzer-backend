package com.accolite.codelyzer.controller;
import com.accolite.codelyzer.model.Candidate;
import com.accolite.codelyzer.serviceimpl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateServiceImpl candidateService;

    @Autowired
    public CandidateController(CandidateServiceImpl candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();

        if (candidates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Optional<Candidate> candidate = candidateService.getCandidateById(id);
        return candidate.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }


    @PostMapping("/create")
    public ResponseEntity<Candidate> createAndAddCandidate(@RequestParam String Cname,
                                                           @RequestParam String candidateEmail,
                                                           @RequestParam String phoneNo,
                                                           @RequestParam Integer YOE) {
        Candidate newCandidate = new Candidate();
        newCandidate.setCname(Cname);
        newCandidate.setCandidateEmail(candidateEmail);
        newCandidate.setPhoneNo(phoneNo);
        newCandidate.setYOE(YOE);

        Candidate savedCandidate = candidateService.createAndAddCandidate(Cname, candidateEmail, phoneNo, YOE);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
//        candidateService.deleteCandidate(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
