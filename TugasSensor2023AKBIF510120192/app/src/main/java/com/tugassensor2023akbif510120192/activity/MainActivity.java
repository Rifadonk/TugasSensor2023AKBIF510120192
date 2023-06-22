package com.tugassensor2023akbif510120192.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.tugassensor2023akbif510120192.R;
import com.tugassensor2023akbif510120192.databinding.ActivityMainBinding;
import com.tugassensor2023akbif510120192.fragment.InfoFragment;
import com.tugassensor2023akbif510120192.fragment.LocationFragment;
import com.tugassensor2023akbif510120192.fragment.NearbyPlacesFragment;
import com.tugassensor2023akbif510120192.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InfoFragment());

        binding.bottomNavigationView2.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new InfoFragment());
                    break;
                case R.id.location:
                    replaceFragment(new LocationFragment());
                    break;
                case R.id.resto:
                    replaceFragment(new NearbyPlacesFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }

            return true;
        });
    }



    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}

// 10120192 - Rifa Said Aqil Hammam - IF5