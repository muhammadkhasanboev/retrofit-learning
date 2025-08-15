package com.android.retrofit_learning;

import java.util.List;

public class DataClass {
    List<ResultsClass> results;

    public List<ResultsClass> getResults() {
        return results;
    }

    public void setResults(List<ResultsClass> results) {
        this.results = results;
    }
}

 class ResultsClass {
    String type, difficulty, question, correct_answer;
    String category; // category is a string in JSON, not int

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getCorrect_answer() { return correct_answer; }
    public void setCorrect_answer(String correct_answer) { this.correct_answer = correct_answer; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
