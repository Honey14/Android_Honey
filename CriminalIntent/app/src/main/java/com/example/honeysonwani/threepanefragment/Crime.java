package com.example.honeysonwani.threepanefragment;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mid;
    private String mtitle;
    private boolean solved;
    private Date mdate;

    public Crime() {
       mid = UUID.randomUUID();
      mdate = new Date();
    }

    public UUID getMid() {
        return mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

}
