package com.example.vietvan.freestory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by VietVan on 04/03/2018.
 */

public class StoryAdapter extends BaseAdapter {

    List<Story> list;
    Context context;

    public StoryAdapter(Context context) {
        this.context = context;
        list = DataBaseManager.get(context).getListStory();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.item_layout, null);

        TextView title = view.findViewById(R.id.tv_title);
        TextView content = view.findViewById(R.id.tv_content);
        ImageView image = view.findViewById(R.id.iv_des);

        title.setText(list.get(i).title);
        content.setText(list.get(i).author);
        Picasso.with(context).load(list.get(i).image).into(image);

        return view;

    }
}
