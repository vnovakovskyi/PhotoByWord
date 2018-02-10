package com.example.vadim.photobyword.lvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vadim.photobyword.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.vadim.photobyword.MainActivity.responsePojo;

public class ResultLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<ResultListItem> resultList;

    public ResultLVAdapter(Context c){
        context = c;

        resultList = new ArrayList<ResultListItem>();

        for (int i = 0; i<responsePojo.getImages().size(); i++){

            resultList.add(new ResultListItem(responsePojo.getImages().get(i).getDisplaySizes().get(0).getUri(), responsePojo.getImages().get(i).getTitle()));
        }
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;

        view = inflater.inflate(R.layout.result_item, viewGroup, false);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView title = (TextView) view.findViewById(R.id.title);

        ResultListItem resultItem = resultList.get(i);

        Picasso.with(context)
                .load(resultItem.photo)
                .into(image);
        title.setText(resultItem.title);

        return view;
    }

    class ResultListItem{

        String photo;
        String title;

        public ResultListItem(String photo, String title) {
            this.photo = photo;
            this.title = title;
        }
    }
}
