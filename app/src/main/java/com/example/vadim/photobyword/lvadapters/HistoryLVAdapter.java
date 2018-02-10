package com.example.vadim.photobyword.lvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vadim.photobyword.R;
import com.example.vadim.photobyword.pojo.DBFilePojo;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import io.realm.RealmResults;
import static com.example.vadim.photobyword.MainActivity.mRealm;

public class HistoryLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<HistoryListItem> historyList;

    public HistoryLVAdapter(Context c){
        context = c;
        historyList = new ArrayList<HistoryListItem>();

        RealmResults<DBFilePojo> dbFilePojos = mRealm.where(DBFilePojo.class).findAll();
        if (!dbFilePojos.isEmpty()){
            for (int i = 0; i < dbFilePojos.size(); i++){
                historyList.add(new HistoryListItem(dbFilePojos.get(i).getUrl(), dbFilePojos.get(i).getTitle()));
            }
        }
    }

    @Override
    public int getCount() {
        return historyList.size();
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

        HistoryListItem historyItem = historyList.get(i);

        Picasso.with(context)
                .load(historyItem.photo)
                .into(image);
        title.setText(historyItem.title);

        return view;
    }

    class HistoryListItem{

        String photo;
        String title;

        public HistoryListItem(String photo, String title) {
            this.photo = photo;
            this.title = title;
        }
    }
}
