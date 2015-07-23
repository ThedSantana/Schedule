package sandro_suladze_cc.schedule.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import sandro_suladze_cc.schedule.GeoWorkersGetter;
import sandro_suladze_cc.schedule.R;

/**
 * Created by Sandro on 14.07.2015.
 */
public class WorkersAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GeoWorkersGetter> listData;
    private LayoutInflater inflater;


    public WorkersAdapter(Context context, ArrayList<GeoWorkersGetter> data) {
        this.context = context;
        this.listData = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        ViewHolder viewHolder;

        if(convertView == null){
            itemView = View.inflate(context, R.layout.listview_item, null);
            viewHolder = new ViewHolder();

            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            TextView nameView = (TextView) itemView.findViewById(R.id.name);
            TextView numberView = (TextView) itemView.findViewById(R.id.number);

            viewHolder.imageView = imageView;
            viewHolder.nameView = nameView;
            viewHolder.numberView = numberView;

            itemView.setTag(viewHolder);
        }else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }
        GeoWorkersGetter cc = (GeoWorkersGetter) getItem(position);
        viewHolder.nameView.setText(cc.getNames());
        viewHolder.numberView.setText(cc.getPhNumbers());

        Picasso.with(context)
                .load(cc.getImages())
                .resize(190,190)
                .centerCrop()
                .into(viewHolder.imageView);



        return itemView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView nameView;
        TextView numberView;
    }
}
