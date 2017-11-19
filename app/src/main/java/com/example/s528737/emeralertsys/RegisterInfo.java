package com.example.s528737.emeralertsys;

import java.util.Date;


public class RegisterInfo {
    public String F_Name;
    public String L_Name;
    public String Email;
    public String Password;
    public String MobileNumber;
    public String objectId;
    public Date created;
    public Date updated;



    @Override
    public String toString() {
        return  "Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", F_Name='" + F_Name + '\'' +
                ", L_Name='" + L_Name + '\'' +
                ", MobileNumber=" + MobileNumber +
                ", objectId='" + objectId + '\'' +
                ", created=" + created +
                ", updated=" + updated
                ;
    }
}
