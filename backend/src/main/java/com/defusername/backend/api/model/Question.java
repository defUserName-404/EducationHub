package com.defusername.backend.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "question")
public class Question {

	@Id
	@Column(name = "id")
	@SequenceGenerator(
			name = "question_id",
			sequenceName = "question_id"
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "question_id"
	)
	private Long id;
	@Column(name = "level")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.ClassLevel classLevel;
	@Column(name = "subject")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.Subject subject;
	@Column(name = "chapter")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.Chapter chapter;
	@Column(name = "difficulty")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.DifficultyLevel difficultyLevel;
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.QuestionType questionType;
	@Column(name = "question")
	private String questionText;
	@Column(name = "options")
	@ElementCollection
	@CollectionTable(name = "options")
	private List<String> options;
	@Column(name = "answer")
	@Enumerated(EnumType.STRING)
	private QuestionConfig.Answer answer;

}
