package com.testpack.cleanarchitecture.Presentation;

import android.view.View;
import android.widget.TextView;

import com.testpack.cleanarchitecture.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsViewHolder extends RecyclerView.ViewHolder {

        public TextView commentsName, commentsMessage;
        public CommentsViewHolder(@NonNull View itemView) {
            super(itemView);
            init(itemView);
        }

        private void init(View itemView)
        {
            commentsMessage = (TextView) itemView.findViewById(R.id.commentsmessage);
            commentsName = (TextView) itemView.findViewById(R.id.commentsname);


        }
    }

