package com.atg.mydemo.model;

/**
 * Created by Mr_TT on 2015/12/26 0026.
 */
public class HeaderModel extends BaseModel {
    private String header="";
    public HeaderModel(int type) {
        super(type);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
