package com.diary.main;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;


import com.diary.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yarolegovich on 25.03.2017.
 */

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    private List<DrawerItem> items;
    private Map<Class<? extends DrawerItem>, Integer> viewTypes;
    private SparseArray<DrawerItem> holderFactories;

    public static final int TYPE_HOME = 0;
    public static final int TYPE_DIARY = 1;
    /*public static final int TYPE_NOTES = 2;
    public static final int TYPE_TODO_LIST = 3;
    public static final int TYPE_CALENDER = 4;*/
    public static final int TYPE_TAGS = 2;
    public static final int TYPE_TRASH = 3;
    public static final int TYPE_MOOD_STATISTICS = 4;
    public static final int TYPE_SETTINGS = 5;
    public static final int TYPE_SHARE = 6;


    private OnItemSelectedListener listener;

    public DrawerAdapter(List<DrawerItem> items) {
        this.items = items;
        this.viewTypes = new HashMap<>();
        this.holderFactories = new SparseArray<>();

        processViewTypes();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = holderFactories.get(viewType).createViewHolder(parent);
        holder.adapter = this;
        return holder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onBindViewHolder(ViewHolder holder, int position) {
        items.get(position).bindViewHolder(holder);

        if(position == items.size()-1){
            holder.view.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(items.get(position).getClass());
    }

    private void processViewTypes() {
        int type = 0;
        for (DrawerItem item : items) {
            if (!viewTypes.containsKey(item.getClass())) {
                viewTypes.put(item.getClass(), type);
                holderFactories.put(type, item);
                type++;
            }
        }
    }

    public void setSelected(int position) {
        DrawerItem newChecked = items.get(position);
        if (!newChecked.isSelectable()) {
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            DrawerItem item = items.get(i);
            if (item.isChecked()) {
                item.setChecked(false);
                notifyItemChanged(i);
                break;
            }
        }

        newChecked.setChecked(true);
        notifyItemChanged(position);

        if (listener != null) {
            listener.onItemSelected(position);
        }
    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    static abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DrawerAdapter adapter;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            view = itemView.findViewById(R.id.v);
        }

        @Override
        public void onClick(View v) {
            adapter.setSelected(getAdapterPosition());
        }
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position);
    }
}
