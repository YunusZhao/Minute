package com.example.yunus.minute.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yunus.minute.R;
import com.example.yunus.minute.entity.Thing;

import java.util.List;

/**
 * Created by yun on 2017/10/13.
 */

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ViewHolder> {

    private List<Thing> mThingList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pic;
        TextView time;
        TextView content;
        TextView point;
        LinearLayout thing;

        public ViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.item_thing_pic);
            time = (TextView) itemView.findViewById(R.id.item_thing_time);
            content = (TextView) itemView.findViewById(R.id.item_thing_content);
            point = (TextView) itemView.findViewById(R.id.item_thing_point);
            thing = (LinearLayout) itemView.findViewById(R.id.item_thing_layout);
        }
    }
    public ThingsAdapter(List<Thing> thingList) {
        mThingList = thingList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_thing, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Thing thing = mThingList.get(position);
        //holder.pic.setImageResource(thing.getCategoryId());
        holder.content.setText(thing.getContent());
        holder.point.setText("*" + thing.getPoint());
        holder.time.setText(thing.getEnd());
        //holder.thing.setBackgroundColor(thing.getCategoryId());
    }

    @Override
    public int getItemCount() {
        return mThingList.size();
    }


}
