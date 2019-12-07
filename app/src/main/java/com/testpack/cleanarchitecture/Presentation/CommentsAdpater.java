package com.testpack.cleanarchitecture.Presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsAdpater extends RecyclerView.Adapter<CommentsViewHolder> {

    private List<HotelComment> hotelCommentsList;
    private Context mContext;
    public CommentsAdpater(Context context, List<HotelComment> commentsList) {
        hotelCommentsList = commentsList;
        mContext = context;
    }


    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listitem,parent,false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder( CommentsViewHolder holder, int position) {

        holder.commentsMessage.setText(hotelCommentsList.get(position).getComment());
        holder.commentsName.setText(hotelCommentsList.get(position).getUser());
    }


    @Override
    public int getItemCount() {
        return hotelCommentsList.size();
    }


}
