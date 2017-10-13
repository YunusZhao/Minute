package com.example.yunus.minute.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yunus.minute.R;
import com.example.yunus.minute.activity.thing.AddThingActivity;
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
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_thing, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Thing thing = mThingList.get(position);
                Intent intent = new Intent(view.getContext(), AddThingActivity.class);
                //intent.putExtra(thing);
                view.getContext().startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Thing thing = mThingList.get(position);
        //holder.pic.setImageResource(thing.getGenreId());
        holder.content.setText(thing.getContent());
        holder.point.setText("*" + thing.getPoint());
        holder.time.setText(thing.getEnd());
        //holder.thing.setBackgroundColor(thing.getGenreId());
    }

    @Override
    public int getItemCount() {
        return mThingList.size();
    }


}
