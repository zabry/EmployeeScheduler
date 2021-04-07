package com.sabarinath.employeeScheduler;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Frequency {
    Weekdays("Weekdays"), Daily("Daily"), Monthly("Monthly"), Weekly("Weekly"), NULL("NULL");

    public String text;

    Frequency(String text){
        this.text=text;
    }

    @JsonValue
    public String getText() {
        return text;
    }

    @JsonCreator
    public static Frequency fromText(String text){
        for (Frequency f: Frequency.values()){
            if (f.getText().equals(text))
                return f;
        }
        throw new IllegalArgumentException();
    }


    @Override
    public String toString() {
        return text;
    }
}
