package com.sh321han.mommyshare.Setting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh321han.mommyshare.R;
import com.sh321han.mommyshare.data.SettingData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-22.
 */
public class SettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SettingData> items = new ArrayList<SettingData>();


    public void add(SettingData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    Setting2ViewHolder.OnItemClickListener mListener2;
    public void setOnItemClickListener(Setting2ViewHolder.OnItemClickListener listener) {
        mListener2 = listener;
    }
    Setting3ViewHolder.OnItemClickListener mListener3;
    public void setOnItemClickListener(Setting3ViewHolder.OnItemClickListener listener) {
        mListener3 = listener;
    }
    Setting4ViewHolder.OnItemClickListener mListener4;
    public void setOnItemClickListener(Setting4ViewHolder.OnItemClickListener listener) {
        mListener4 = listener;
    }


    private static final int VIEW_TYPE_1 = 0;
    private static final int VIEW_TYPE_2 = 1;
    private static final int VIEW_TYPE_3 = 2;
    private static final int VIEW_TYPE_4 = 3;
    private static final int VIEW_TYPE_5 = 4;

    @Override
    public int getItemViewType(int position) {
        SettingData data = items.get(position);

        if (position == 0) {
            return VIEW_TYPE_1;
        } else if (position == 1) {
            return VIEW_TYPE_2;
        } else if (position == 2) {
            return VIEW_TYPE_3;
        } else if (position == 3) {
            return VIEW_TYPE_4;
        } else {
            return VIEW_TYPE_5;
        }

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = null;

        switch (viewType) {
            case VIEW_TYPE_1:
                view = inflater.inflate(R.layout.view_setting_content1, parent, false);
                return new Setting1ViewHolder(view);
            case VIEW_TYPE_2:
                view = inflater.inflate(R.layout.view_setting_content2, parent, false);
                return new Setting2ViewHolder(view);
            case VIEW_TYPE_3:
                view = inflater.inflate(R.layout.view_setting_content3, parent, false);
                return new Setting3ViewHolder(view);
            case VIEW_TYPE_4:
                view = inflater.inflate(R.layout.view_setting_content4, parent, false);
                return new Setting4ViewHolder(view);
            case VIEW_TYPE_5:
                view = inflater.inflate(R.layout.view_setting_content5, parent, false);
                return new Setting5ViewHolder(view);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_1:
                ((Setting1ViewHolder) holder).setSettingTop(items.get(position));
                break;
            case VIEW_TYPE_2:
                ((Setting2ViewHolder) holder).setSetting(items.get(position));
                ((Setting2ViewHolder) holder).setOnItemClickListener(mListener2);
                break;
            case VIEW_TYPE_3:
                ((Setting3ViewHolder) holder).setSetting(items.get(position));
                ((Setting3ViewHolder) holder).setOnItemClickListener(mListener3);
                break;
            case VIEW_TYPE_4:
                ((Setting4ViewHolder) holder).setSetting(items.get(position));
                ((Setting4ViewHolder) holder).setOnItemClickListener(mListener4);
                break;
            case VIEW_TYPE_5:
                ((Setting5ViewHolder) holder).setSetting(items.get(position));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
