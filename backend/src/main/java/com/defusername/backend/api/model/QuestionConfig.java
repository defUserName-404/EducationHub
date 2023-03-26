package com.defusername.backend.api.model;

public class QuestionConfig {

	enum ClassLevel {
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
	}

	enum Subject {
		BANGLA, ENGLISH, MATH, PHYSICS, CHEMISTRY, BIOLOGY, RELIGION
	}

	enum Chapter {
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN
	}

	enum DifficultyLevel {
		EASY, MEDIUM, HARD
	}

	enum QuestionType {
		KNOWLEDGE_BASED, MCQ, WRITTEN
	}

	enum Answer {
		A, B, C, D
	}

}
