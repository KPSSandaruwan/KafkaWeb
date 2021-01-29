package com.example.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FeedbackModel {
    public String feedback;

    public FeedbackModel () {}

    public FeedbackModel(String feedback) {
        this.feedback = feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
}