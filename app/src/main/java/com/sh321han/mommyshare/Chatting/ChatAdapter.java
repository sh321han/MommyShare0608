package com.sh321han.mommyshare.Chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-06-09.
 */
public class ChatAdapter extends BaseAdapter{

    List<ChatMessage> items = new ArrayList<ChatMessage>();

    private static final int VIEW_TYPE_COUNT = 3;
    private static final int TYPE_SEND = 0;
    private static final int TYPE_RECEIVE = 1;
    private static final int TYPE_DATE = 2;


    public void add(ChatMessage item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage message = items.get(position);
        if (message instanceof Send) {
            return TYPE_SEND;
        } else if (message instanceof Receive) {
            return TYPE_RECEIVE;
        }
        return TYPE_DATE;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_SEND: {
                SendView view;
                if (convertView != null && convertView instanceof SendView) {
                    view = (SendView)convertView;
                } else {
                    view = new SendView(parent.getContext());
                }
                view.setData((Send)items.get(position));
                return view;
            }
            case TYPE_RECEIVE: {
                ReceiveView view;
                if (convertView != null && convertView instanceof ReceiveView) {
                    view = (ReceiveView)convertView;
                } else {
                    view = new ReceiveView(parent.getContext());
                }
                view.setData((Receive) items.get(position));
                return view;
            }
            default : {
                DateView view;
                if (convertView != null && convertView instanceof DateView) {
                    view = (DateView)convertView;
                } else {
                    view = new DateView(parent.getContext());
                }
                view.setData((Date)items.get(position));
                return view;
            }

        }
    }


}
