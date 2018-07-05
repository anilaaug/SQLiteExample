package com.example.anila.sqliteexample;

public class Contacts {

    public String mName;
    public String mPhoneNumber;
    public int mId;
    public Contacts(int id,String name,String phoneNumber)
    {
        mName=name;
        mPhoneNumber=phoneNumber;
        mId=id;
    }
    public Contacts()
    {}
    public Contacts(String name,String phoneNumber)
    {
        mName=name;
        mPhoneNumber=phoneNumber;

    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
