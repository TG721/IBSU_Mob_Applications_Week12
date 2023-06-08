package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.slider.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setup();
    }

    private void setup() {
        List<SlideModel> imageList = new ArrayList< SlideModel>() ;// Create image list
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.",  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://ibsu.edu.ge/wp-content/uploads/2023/06/8906190-02-1536x865.jpg", "IBSU Summer Music Festival",  ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setImageList(imageList);

        imageSlider.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onItemSelected(int i) {

                        switch (i){
                            case 0: {
                                imageSlider.setVisibility(View.GONE);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container, new AnimalPopulationFragment()).commit();}
                            break;
                            case 1: {
                                imageSlider.setVisibility(View.GONE);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container, new ElephantFragment()).commit();
                                break;
                            }
                            case 2: {
                                imageSlider.setVisibility(View.GONE);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container, new PeopleFragment()).commit();
                                break;
                            }
                            case 3: {
                                imageSlider.setVisibility(View.GONE);
                                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.container, new IBSUSummerFragment()).commit();
                                break;
                            }
                        }
                    }

                    @Override
                    public void doubleClick(int i) {

                    }
                });

    }
    @Override
    public void onBackPressed() {
        // Handle back button click here
        // You can perform any desired action

        ImageSlider imageSlider = binding.imageSlider;
        imageSlider.setVisibility(View.VISIBLE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new EmptyFragment()).commit();
    }
}