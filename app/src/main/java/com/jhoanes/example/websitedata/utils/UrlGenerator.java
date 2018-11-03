package com.jhoanes.example.websitedata.utils;

import static com.jhoanes.example.websitedata.utils.WebEndsPoint.BASE_URL;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.CONTRACTS;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.DAILY;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.LAWS;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.ORDINANCES;

public class UrlGenerator {

    public static String getOrdinances(){
        return BASE_URL + ORDINANCES;
    }
    public static String getLaws(){
        return BASE_URL + LAWS;
    }

    public static String getDaily(){
        return BASE_URL + DAILY;
    }

    public static String getContracts(){
        return BASE_URL + CONTRACTS;
    }

}
