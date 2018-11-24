package com.jhoanes.example.websitedata.utils;

import static com.jhoanes.example.websitedata.utils.WebEndsPoint.DIARY;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.FULL_URL;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.BIDDING;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.CONTRACTS;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.DAILY;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.DECREES;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.LAWS;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.NFSE;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.NFSE_FULL_URL;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.ORDINANCES;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.PERSONAL_SECTOR;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.PERSONAL_SECTOR_FULL_URL;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.TRANSPARENCY;
import static com.jhoanes.example.websitedata.utils.WebEndsPoint.TRANSPARENCY_FULL_URL;

public class UrlGenerator {

    public static String getOrdinances(){
        return FULL_URL + ORDINANCES;
    }
    public static String getLaws(){
        return FULL_URL + LAWS;
    }

    public static String getDaily(){
        return FULL_URL + DAILY;
    }

    public static String getContracts(){
        return FULL_URL + CONTRACTS;
    }

    public static String getDecrees(){
        return FULL_URL + DECREES;
    }

    public static String getBidding() { return FULL_URL + BIDDING; }

    public static String getCounterCheck(){
        return PERSONAL_SECTOR_FULL_URL + PERSONAL_SECTOR;
    }

    public static String getTransparency() { return TRANSPARENCY_FULL_URL + TRANSPARENCY; }

    public static String getNFSE() {
        return NFSE_FULL_URL + NFSE;
    }

    public static String getDiary() {
        return FULL_URL + DIARY;
    }

}
