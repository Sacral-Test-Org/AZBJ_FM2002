package com.azbj.fm2002.dto;

import java.util.Date;

public class NomineeDetailsDTO {
    private String nomineeName;
    private String nomineeBirthplace;
    private Date nomineeDob;
    private String nomineeRelation;
    private String nomineeGender;

    // Getters and Setters
    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeBirthplace() {
        return nomineeBirthplace;
    }

    public void setNomineeBirthplace(String nomineeBirthplace) {
        this.nomineeBirthplace = nomineeBirthplace;
    }

    public Date getNomineeDob() {
        return nomineeDob;
    }

    public void setNomineeDob(Date nomineeDob) {
        this.nomineeDob = nomineeDob;
    }

    public String getNomineeRelation() {
        return nomineeRelation;
    }

    public void setNomineeRelation(String nomineeRelation) {
        this.nomineeRelation = nomineeRelation;
    }

    public String getNomineeGender() {
        return nomineeGender;
    }

    public void setNomineeGender(String nomineeGender) {
        this.nomineeGender = nomineeGender;
    }
}