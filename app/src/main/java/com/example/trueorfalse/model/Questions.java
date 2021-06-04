package com.example.trueorfalse.model;

public class Questions {
    private int questionResId;
    private boolean isTrue;

    public Questions(int questionResId, boolean isTrue) {
        this.questionResId = questionResId;
        this.isTrue = isTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
