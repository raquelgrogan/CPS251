package com.ebookfrenzy.buttonsnavigation.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebookfrenzy.buttonsnavigation.R;

import android.widget.Button;
import android.widget.ImageView;

import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        // initialize buttons
        Button flowerButton = getView().findViewById(R.id.flowerButton);
        Button mushroomButton = getView().findViewById(R.id.mushroomButton);
        Button yoshiButton = getView().findViewById(R.id.yoshiButton);


        flowerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView flowerImage = getView().findViewById(R.id.fireFlowerImage);
                flowerImage.setTag(R.drawable.fireflower);
                int id1 = getDrawableId(flowerImage);

                MainFragmentDirections.MainToSecond action =
                        MainFragmentDirections.mainToSecond();
                action.setImage(id1);

                Navigation.findNavController(view).navigate(
                        action);
            }
        });

        mushroomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView mushroomImage = getView().findViewById(R.id.mushroomImage);
                mushroomImage.setTag(R.drawable.mushroom);
                int id2 = getDrawableId(mushroomImage);
                MainFragmentDirections.MainToThird action =
                        MainFragmentDirections.mainToThird();
                action.setImage(id2);

                Navigation.findNavController(view).navigate(
                        action);
            }
        });

        yoshiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView yoshiImage = getView().findViewById(R.id.yoshiImage);
                yoshiImage.setTag(R.drawable.yoshi);
                int id3 = getDrawableId(yoshiImage);
                MainFragmentDirections.MainToFourth action =
                        MainFragmentDirections.mainToFourth();
                action.setImage(id3);

                Navigation.findNavController(view).navigate(
                        action);
            }
        });


    }

    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }

}
