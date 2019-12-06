package com.testpack.cleanarchitecture.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.testpack.cleanarchitecture.R;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment();
    }

    private void loadFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new HotelDetailsFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
