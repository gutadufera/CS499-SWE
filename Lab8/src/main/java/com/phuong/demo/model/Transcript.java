package com.phuong.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transcriptID;
    private String degreeTitle;

    public long getTranscriptID() {
        return transcriptID;
    }

    public void setTranscriptID(long transcriptID) {
        this.transcriptID = transcriptID;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript() {
    }
    @OneToOne(mappedBy = "transcript", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Student student;
    public Transcript(String degreeTitle){
        this.degreeTitle = degreeTitle;
    }
    public Transcript(Long transcriptID, String degreeTitle){
        this.transcriptID = transcriptID;
        this.degreeTitle = degreeTitle;
    }
    public Transcript(Long transcriptID, String degreeTitle, Student student){
        this.degreeTitle = degreeTitle;
        this.transcriptID = transcriptID;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Transcript id: " +transcriptID+ "Degree title: "+degreeTitle +"Student Name: "+student;
    }
}
