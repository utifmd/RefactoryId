package com.utflnx.mobilesimpleapp.extension;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utflnx.mobilesimpleapp.R;
import com.utflnx.mobilesimpleapp.model.HorizonTodoModel;

import java.util.List;

public class HorizonAdapter extends RecyclerView.Adapter<HorizonAdapter.GeneralViewHolder> {
    private final String TAG = getClass().getSimpleName();
    private final Context mContext;
    private List<HorizonTodoModel> mHorizonTodoModels;

    public HorizonAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<HorizonTodoModel> horizonTodoModels){
        mHorizonTodoModels = horizonTodoModels;
    }

    @NonNull @Override
    public GeneralViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GeneralViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.item_inner_horizontal, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralViewHolder holder, int position) {
       HorizonTodoModel model = mHorizonTodoModels.get(position);
       holder.bind(model, position);
    }

    @Override
    public int getItemCount() {
        return mHorizonTodoModels.size();
    }

    static class GeneralViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvDate, tvSign;

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.text_day);
            tvDate = itemView.findViewById(R.id.text_date);
            tvSign = itemView.findViewById(R.id.dot_sign);
        }

        public void bind(HorizonTodoModel model, int position) {
            tvDay.setText(model.getDay());
            tvDate.setText(model.getDate());
            if (model.isDot()) tvSign.setVisibility(View.VISIBLE);
        }
    }
}
