package com.sunil.expandablerecyclerview;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by kuliza-195 on 11/28/16.
 */

public class Title extends ExpandableGroup<SubTitle> {

    private String imageUrl;

    public Title(String title, List<SubTitle> items, String imageUrl) {
        super(title, items);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

