package com.deucate.kartik.billmk.Spent;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.deucate.kartik.billmk.R;

import java.util.List;


public class SpentAdapter extends ArrayAdapter<SpentGs> {

    String type;

    public SpentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<SpentGs> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.spent_list,parent,false);
        }

        TextView rsTv = convertView.findViewById(R.id.listSpentRS);
        TextView dateTv = convertView.findViewById(R.id.listSpentDate);
        TextView timeTv = convertView.findViewById(R.id.listSpentTime);
        TextView reasonTv = convertView.findViewById(R.id.listSpentReason);

        ImageView imageView = convertView.findViewById(R.id.listSpentImage);

        SpentGs spentGs = getItem(position);

        assert spentGs != null;

        switch (spentGs.getCategory()){

            case 0:{
                imageView.setImageResource(R.drawable.electronic);
            }break;
            case 1:{
                imageView.setImageResource(R.drawable.food);
            }break;
            case 2:{
                imageView.setImageResource(R.drawable.cloths);
            }break;
            case 3:{
                imageView.setImageResource(R.drawable.grocery);
            }break;
            case 4:{
                imageView.setImageResource(R.drawable.bill);
            }break;
            case 5:{
                imageView.setImageResource(R.drawable.other);
            }break;

        }

        rsTv.setText(spentGs.getRs()+"");
        dateTv.setText(spentGs.getDate());
        timeTv.setText(spentGs.getTime());
        reasonTv.setText(spentGs.getReason());

        return convertView;
    }
}
