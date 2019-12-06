package com.testpack.cleanarchitecture.Presentation;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;
import com.testpack.cleanarchitecture.R;

import java.util.List;


public class HotelDetailsFragment extends Fragment {

    HotelViewModel hotelViewModel;

    private TextView hotelName,hotelLocation,hotelDescription,
    hotelRating;
    private RecyclerView mRecyclerView;
//    private SharedPreferences sharedPreferences = ;

    SharedPreferences.Editor editor ;


    public HotelDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelDetailsFragment newInstance(String param1, String param2) {
        HotelDetailsFragment fragment = new HotelDetailsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hotel_details, container, false);

        editor = getActivity().getSharedPreferences("testpref", 0).edit();
        setUpViews(view);
        setUpData();
        return view;
    }

    public void setUpViews(View view) {

        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        hotelName = (TextView) view.findViewById(R.id.hotelName);
        hotelLocation  = (TextView) view.findViewById(R.id.hotelLocation);
        hotelDescription  = (TextView) view.findViewById(R.id.hotelDescription);
        hotelRating  = (TextView) view.findViewById(R.id.hotelRating);
    }

    private void setUpData() {
        hotelViewModel = ViewModelProviders.of(this).get(HotelViewModel.class);

        hotelViewModel.getHotelDetailsLiveData().observe(this, new Observer<HotelDetails>() {
            @Override
            public void onChanged(HotelDetails hotelDetails) {
                populateUI(hotelDetails);
               editor.putString("data",new Gson().toJson(hotelDetails));
            }
        });

        hotelViewModel.getHotelCommentsLiveData().observe(this, new Observer<List<HotelComment>>() {
            @Override
            public void onChanged(List<HotelComment> hotelComments) {
                populateComments(hotelComments);
            }
        });

            hotelViewModel.getHotelDetailsFromApi();

        hotelViewModel.getHotelCommentsFromApi();
    }

    private void populateComments(List<HotelComment> hotelcomments) {
        CommentsAdpater commentsAdpater = new CommentsAdpater(getActivity(),hotelcomments);
        mRecyclerView.setAdapter(commentsAdpater);
        commentsAdpater.notifyDataSetChanged();

    }

    private void populateUI(HotelDetails hotelDetails) {
        hotelName.setText(hotelDetails.getName());
        hotelLocation.setText(hotelDetails.getLocation());
        hotelDescription.setText(hotelDetails.getDescription());
        hotelRating.setText(hotelDetails.getRating().toString());
    }


}
