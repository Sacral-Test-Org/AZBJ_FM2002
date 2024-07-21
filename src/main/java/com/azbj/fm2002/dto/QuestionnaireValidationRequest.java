package com.azbj.fm2002.dto;

public class QuestionnaireValidationRequest {
    private int questionId;
    private String answer;

    public QuestionnaireValidationRequest() {}

    public QuestionnaireValidationRequest(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
