package com.testpack.cleanarchitecture.Presentation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.R;
import com.testpack.cleanarchitecture.StaticData;

public class GetCommentsFragment extends Fragment {

    private EditText userName, userComments;
    private Button submitBtn;
    private HotelViewModel viewModel;
    public GetCommentsFragment() {
        // Required empty public constructor
    }

//

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_get_comments, container, false);
        setUpView(view);
        return view;
    }

    public void setUpView(View view) {

        submitBtn = (Button) view.findViewById(R.id.submitBtn);
        userComments = (EditText) view.findViewById(R.id.userComments);
        userName = (EditText) view.findViewById(R.id.userName);
        viewModel = ViewModelProviders.of(this).get(HotelViewModel.class);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               uploadComments();
            }
        });

    }

    private void uploadComments() {
        String name = userName.getText().toString();
        String comments = userComments.getText().toString();

        HotelComment hotelComment = new HotelComment();
        hotelComment.setComment(comments);
        hotelComment.setUser(name);

        viewModel.updateComments(hotelComment);

    }

}
