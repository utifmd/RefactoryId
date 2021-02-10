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
        LinearLayout baseHorizontalView; // TextView dotSign, textDay, textDate;

        public HorizonViewHolder(@NonNull View itemView) {
            super(itemView);
            baseHorizontalView = itemView.findViewById(R.id.baseHorizontalView);

//            horizonItem = itemView.findViewById(R.id.horizon_item);
//            dotSign = itemView.findViewById(R.id.dot_sign);
//            textDay = itemView.findViewById(R.id.text_day);
//            textDate = itemView.findViewById(R.id.text_date);
        }

        public void bind(Context context, List<HorizonTodoModel> modelList, int position) {
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(33, 83);
            param.setMargins(5, 5, 5, 5);

            for (int i = 0; i < modelList.size(); i++){
                // Log.d("HorizonViewHolder", "modelList size: "+i);
                View itemInner = View.inflate(context, R.layout.item_inner_horizontal, null);
                itemInner.setLayoutParams(param);
                ((TextView)itemInner.findViewById(R.id.text_day)).setText(modelList.get(i).getDay());
                ((TextView)itemInner.findViewById(R.id.text_date)).setText(modelList.get(i).getDate());
                if (modelList.get(i).isDot()) itemInner.findViewById(R.id.dot_sign).setVisibility(View.VISIBLE);

                baseHorizontalView.addView(itemInner);
            }

//            textDay.setText(model.getDay());
//            textDay.setText(model.getDate());
//            if (model.isDot()) dotSign.setVisibility(View.VISIBLE);
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
