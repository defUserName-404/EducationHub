package com.defusername.backend.service;

import com.defusername.backend.model.Question;
import com.defusername.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Question getQuestion(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new IllegalStateException("ID Not Found"));
	}

	public Question addNewQuestion(Question question) {
		return questionRepository.save(question);
	}

	public void removeQuestion(Long id) {
		questionRepository.deleteById(id);
	}

	public Question updateQuestion(Long id, Question updatedQuestion) {
		Question questionToBeUpdated = questionRepository.findById(id).orElseThrow(() -> new IllegalStateException("ID Not Found"));
		if (updatedQuestion.getClassLevel() != null)
			questionToBeUpdated.setClassLevel(updatedQuestion.getClassLevel());
		if (updatedQuestion.getSubject() != null)
			questionToBeUpdated.setSubject(updatedQuestion.getSubject());
		if (updatedQuestion.getQuestionText() != null)
			questionToBeUpdated.setQuestionText(updatedQuestion.getQuestionText());
		if (updatedQuestion.getQuestionType() != null)
			questionToBeUpdated.setQuestionType(updatedQuestion.getQuestionType());
		if (updatedQuestion.getAnswer() != null)
			questionToBeUpdated.setAnswer(updatedQuestion.getAnswer());
		if (updatedQuestion.getChapter() != null)
			questionToBeUpdated.setChapter(updatedQuestion.getChapter());
		if (updatedQuestion.getOptions() != null)
			questionToBeUpdated.setOptions(updatedQuestion.getOptions());
		if (updatedQuestion.getDifficultyLevel() != null)
			questionToBeUpdated.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
		return questionRepository.save(questionToBeUpdated);
	}

}
