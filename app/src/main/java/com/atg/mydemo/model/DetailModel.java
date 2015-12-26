package com.atg.mydemo.model;

/**
 * Created by Mr_TT on 2015/12/26 0026.
 */
public class DetailModel extends BaseModel {

    private String context = "";
    private String detail = "";

    public DetailModel(int type) {
        super(type);
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
