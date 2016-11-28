package com.sunil.expandablerecyclerview;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by sunil on 11/27/16.
 */

public class TitleViewHolder extends GroupViewHolder {

    private TextView titleName;
    private ImageView arrow;
    private ImageView icon;

    public TitleViewHolder(View itemView) {
        super(itemView);
        titleName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
        icon = (ImageView) itemView.findViewById(R.id.list_item_genre_icon);
    }

    public void setGenreTitle(Context context, ExpandableGroup title) {
        if (title instanceof Title) {
            titleName.setText(title.getTitle());
            if (((Title) title).getImageUrl()!= null && !((Title) title).getImageUrl().isEmpty()){
                Glide.with(context)
                        .load(((Title) title).getImageUrl())
                        .into(icon);

            }
        }
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}