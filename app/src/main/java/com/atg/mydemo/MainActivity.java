package com.atg.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.atg.mydemo.model.BaseModel;
import com.atg.mydemo.model.HeaderModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BaseModel> models;
    private MyAdapter adapter;
    private ListView listView;
    private TextView textView;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models = Repos.getData();
        adapter = new MyAdapter(this,models);
        listView = (ListView) findViewById(R.id.listview);
        textView = (TextView) findViewById(R.id.textview);
        listView.setAdapter(adapter);
        textView1 = (TextView) findViewById(R.id.textview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object dataObj=adapter.getItem(position);
                if(dataObj.getClass()== HeaderModel.class){
                    textView.setText(String.format("第%s行被点触,其标题为：%s",position,
                            ((HeaderModel)dataObj).getHeader()));
                }else{
                    textView.setText(String.format("第%s行被点触",position));
                }
            }
        });
    }


}
