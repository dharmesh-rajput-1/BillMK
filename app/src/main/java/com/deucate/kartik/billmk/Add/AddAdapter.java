package com.deucate.kartik.billmk.Add;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.deucate.kartik.billmk.R;

import java.util.List;

class AddAdapter extends ArrayAdapter<AddGS> {

    private String type;

    AddAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<AddGS> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.add_list, parent, false);
        }

        TextView rsTv = convertView.findViewById(R.id.listAddRS);
        TextView dateTv = convertView.findViewById(R.id.listAddDate);
        TextView timeTv = convertView.findViewById(R.id.listAddTime);
        TextView typeTv = convertView.findViewById(R.id.listAddType);
        ImageView imageView = convertView.findViewById(R.id.listAddImage);

        AddGS listView = getItem(position);

        assert listView != null;

        switch (listView.getCategory()){
            case 0:{
                type = "Salary";
                imageView.setImageResource(R.drawable.salary);
            }break;
            case 1:{
                type = "Relative";
                imageView.setImageResource(R.drawable.reletive);
            }break;
            case 2:{
                type = "Sell";
                imageView.setImageResource(R.drawable.sell);
            }break;
            case 3:{
                type = "Other";
                imageView.setImageResource(R.drawable.other);
            }break;
        }

        rsTv.setText(listView.getRs()+"");
        dateTv.setText(listView.getDate());
        timeTv.setText(listView.getTime());
        typeTv.setText(type);


        return convertView;
    }
}
