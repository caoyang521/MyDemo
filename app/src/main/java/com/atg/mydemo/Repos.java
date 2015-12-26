package com.atg.mydemo;

import com.atg.mydemo.model.BaseModel;
import com.atg.mydemo.model.DetailModel;
import com.atg.mydemo.model.HeaderModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr_TT on 2015/12/26 0026.
 */
public class Repos {
    public static List<BaseModel> getData(){
        List<BaseModel> models=new ArrayList<BaseModel>();
        for (int i = 0; i <= 3; i++) {
            HeaderModel headerModel=new HeaderModel(0);
            headerModel.setHeader("第"+i+"章");
            models.add(headerModel);
            for (int j = 0; j <= 5; j++) {
                DetailModel detailModel=new DetailModel(1);
                detailModel.setContext("数据项"+j);
                detailModel.setDetail("属于第"+i+"章");
                models.add(detailModel);
            }
        }
        return models;
    }
}
