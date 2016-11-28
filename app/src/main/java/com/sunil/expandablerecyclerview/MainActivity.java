package com.sunil.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String imageUrl[] = Constant.image;
    String names[] = Constant.name;
    String subNames[] = Constant.subName;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Title> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    private List<Title> getList() {
        List<Title> list = new ArrayList<>();
        for (int i = 0; i < imageUrl.length; i++) {
            List<SubTitle> subTitles = new ArrayList<>();
            for (int j = 0; j< subNames.length; j++){
                SubTitle subTitle = new SubTitle(subNames[j]);
                subTitles.add(subTitle);
            }
            Title model = new Title(names[i],subTitles, imageUrl[i]);
            list.add(model);
        }
        return list;
    }
}
