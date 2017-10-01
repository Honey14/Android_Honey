package com.example.honeysonwani.threepanefragment;

import android.content.Context;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    public List<Crime> mCrimes; //4 objects in a list
    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for(int i =0;i<100;i++){
            Crime crime = new Crime();
            crime.setMtitle("# crime no" + i);
            crime.setSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }
    public Crime getCrime(UUID id){
        for(Crime crime: mCrimes){
            if(crime.getMid().equals(id)) {
                return crime;
            }
        }return null;
    }
}
