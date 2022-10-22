package com.sreviewonly.board.entites.enums;

public enum PREFERSEX {
    MMT,WMT,CPT;

    public static PREFERSEX changeStringToPreferSex(String sex){
        PREFERSEX prefersex;
        if(sex.equals("mmt")||sex.equals("MMT")){
            prefersex = MMT;
        }else if(sex.equals("wmt")||sex.equals("WMT")){
            prefersex=WMT;
        }else if (sex.equals("cpt")||sex.equals("CPT")){
            prefersex=CPT;
        }else{
            prefersex=WMT;
        }
        return prefersex;
    }

    public static String changePreferSexToString(PREFERSEX prefersex){
        if(prefersex==WMT)
            return "wmt";
        if(prefersex==MMT)
            return "mmt";
        if(prefersex==CPT)
            return "cpt";

        return "wmt";
    }
}
