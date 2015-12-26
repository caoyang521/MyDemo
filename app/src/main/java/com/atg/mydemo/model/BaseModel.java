package com.atg.mydemo.model;

/**
 * Created by Mr_TT on 2015/12/26 0026.
 */
public class BaseModel {
    private final int type;

    public BaseModel(int type) {
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
