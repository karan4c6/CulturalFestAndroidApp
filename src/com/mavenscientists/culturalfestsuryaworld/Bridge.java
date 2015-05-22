package com.mavenscientists.culturalfestsuryaworld;

import java.util.ArrayList;

class Bridge
{
    private Bridge()
    {
    }

    static Bridge obj = null;
    public static Bridge instance()
    {
         if (obj == null) 
        	 obj = new Bridge();
         return obj;
    }
    public ArrayList<String> allEmail;
    public ArrayList<String> allEmailName;
    public ArrayList<String> allPhoneName;
    public ArrayList<String> allPhoneNumber;

 }