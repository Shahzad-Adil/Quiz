package com.londonappbrewery.quizzler;

public class TrueFalse {

    private int mQuestuinID;
    private boolean mTrueFalse;

    public TrueFalse(int mQuestuinID, boolean mTrueFalse) {
        this.mQuestuinID = mQuestuinID;
        this.mTrueFalse = mTrueFalse;
    }

    public int getmQuestuinID() {
        return mQuestuinID;
    }

    public void setmQuestuinID(int mQuestuinID) {
        this.mQuestuinID = mQuestuinID;
    }

    public boolean ismTrueFalse() {
        return mTrueFalse;
    }

    public void setmTrueFalse(boolean mTrueFalse) {
        this.mTrueFalse = mTrueFalse;
    }
}
