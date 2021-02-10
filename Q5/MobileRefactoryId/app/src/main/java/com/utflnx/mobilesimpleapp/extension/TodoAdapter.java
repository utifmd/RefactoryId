package com.utflnx.mobilesimpleapp.extension;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utflnx.mobilesimpleapp.R;
import com.utflnx.mobilesimpleapp.model.HeaderCalendarModel;
import com.utflnx.mobilesimpleapp.model.HeaderTitleModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModel;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModelObject;
import com.utflnx.mobilesimpleapp.model.TodoModel;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = getClass().getSimpleName();
    private List<ListObject> listObjectList;
    private final Context mContext;

    public void setData(List<ListObject> objectList){
        listObjectList = objectList;

        notifyDataSetChanged();
    }

    public TodoAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ListObject.TYPE_TITLE) {
            return new TitleViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.item_title, parent, false)
            );
        } else if (viewType == ListObject.TYPE_CALENDAR) {
            return new CalendarViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.item_calendar, parent, false)
            );
        } else if (viewType == ListObject.TYPE_GENERAL){
            return new GeneralViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.item_general, parent, false)
            );
        } else if(viewType == ListObject.TYPE_HORIZONTAL) {
            return new HorizonViewHolder(
                    LayoutInflater.from(mContext).inflate(R.layout.item_horizontal, parent, false)
            );
        }else throw new IllegalStateException("Unexpected viewType: "+viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case ListObject.TYPE_TITLE:
                HeaderTitleModel headerTitleModel = ((HeaderTitleModel)listObjectList.get(position));
                ((TitleViewHolder) holder).bind(headerTitleModel, position);
                break;
            case ListObject.TYPE_CALENDAR:
                HeaderCalendarModel headerCalendarModel = ((HeaderCalendarModel) listObjectList.get(position));
                ((CalendarViewHolder) holder).bind(headerCalendarModel, position);
                break;
            case ListObject.TYPE_GENERAL:
                TodoModel todoModel = ((TodoModel) listObjectList.get(position));
                ((GeneralViewHolder) holder).bind(todoModel, position);
                break;
            case ListObject.TYPE_HORIZONTAL:
                List<HorizonTodoModel> horizonTodoModel = ((HorizonTodoModelObject) listObjectList.get(position)).getModelList();

                ((HorizonViewHolder) holder).bind(mContext, horizonTodoModel, position);
                break;
            default:
                throw new IllegalStateException("Unexpected viewType: " + holder.getItemViewType());
        }
    }

    @Override
    public int getItemCount() {
        return listObjectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listObjectList.get(position).getViewType();
    }

    static class GeneralViewHolder extends RecyclerView.ViewHolder {
        TextView title, subTitle, time, complete;
        View backgroundComplete;
        ImageView ivComplete;

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textItemTitle);
            subTitle = itemView.findViewById(R.id.textItemSubtitle);
            time = itemView.findViewById(R.id.textTime);
            complete = itemView.findViewById(R.id.textComplete);
            backgroundComplete = itemView.findViewById(R.id.backgroundComplete);
            ivComplete = itemView.findViewById(R.id.ivComplete);
        }

        @SuppressLint("ResourceAsColor")
        public void bind(TodoModel model, int position) {
            title.setText(model.getTitle());
            subTitle.setText(model.getSubtitle());
            time.setText(model.getTime());

            if (model.isComplete()) {
                complete.setTextColor(R.color.tx_complete);
                ivComplete.setColorFilter(R.color.tx_complete);
                backgroundComplete.setBackgroundResource(R.color.bg_complete);
            }
        }
    }

    static class HorizonViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewHor;

        public HorizonViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewHor = itemView.findViewById(R.id.rv_horizon);
        }

        public void bind(Context context, List<HorizonTodoModel> modelList, int position) {
            HorizonAdapter horAdapter = new HorizonAdapter(context);
            recyclerViewHor.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            recyclerViewHor.setHasFixedSize(true);

            horAdapter.setData(modelList);
            recyclerViewHor.setAdapter(horAdapter);
        }
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
        }

        public void bind(HeaderTitleModel model, int position) {
            title.setText(model.getTitle());
        }
    }

    static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
        }

        public void bind(HeaderCalendarModel model, int position) {
            title.setText(model.getTitle());
        }
    }
}
