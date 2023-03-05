package com.defusername.backend.controller;

import com.defusername.backend.model.Question;
import com.defusername.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "/api/v1/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping(path = "/all")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping
	public Question getQuestion(@RequestParam Long id) {
		return questionService.getQuestion(id);
	}

	@PostMapping
	public ResponseEntity<Question> addNewQuestion(@RequestBody Question question) {
		return new ResponseEntity<>(questionService.addNewQuestion(question), HttpStatus.OK);
	}


	@DeleteMapping
	public ResponseEntity<Long> deleteQuestion(@RequestParam Long id) {
		questionService.removeQuestion(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Question> updateQuestion(@RequestParam Long id, @RequestBody Question question) {
		return new ResponseEntity<>(questionService.updateQuestion(id, question), HttpStatus.OK);
	}

}
