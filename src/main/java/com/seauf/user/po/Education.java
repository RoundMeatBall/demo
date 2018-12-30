package com.seauf.user.po;

import org.springframework.context.annotation.Bean;

/**
 * @author: Mr.lynn
 * @create: 2018-12-28 21:00
 **/

public class Education {

    private String school;

    private Integer graduationTime;

    @Override
    public String toString() {
        return "Education{" +
                "school='" + school + '\'' +
                ", graduationTime=" + graduationTime +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Integer graduationTime) {
        this.graduationTime = graduationTime;
    }
}
