package com.everdigitio.beans;

public class ScoreCardDetails {
    private String subjectName;
    private double totalMarks;
    private double marksObtained;

    public ScoreCardDetails(String subjectName, double totalMarks, double marksObtained) {
        this.subjectName = subjectName;
        this.totalMarks = totalMarks;
        this.marksObtained = marksObtained;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }
}
