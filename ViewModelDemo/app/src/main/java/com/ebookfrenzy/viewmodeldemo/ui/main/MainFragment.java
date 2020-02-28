package com.ebookfrenzy.viewmodeldemo.ui.main;

//import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import com.ebookfrenzy.viewmodeldemo.databinding.MainFragmentBinding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;

import com.ebookfrenzy.viewmodeldemo.R;
import static com.ebookfrenzy.viewmodeldemo.BR.myViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    public MainFragmentBinding binding;
//    private EditText dollarText;
//    private TextView resultText;
//    private Button convertButton;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
        //return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setVariable(myViewModel, mViewModel);
        // TODO: Use the ViewModel
//        dollarText = getView().findViewById(R.id.dollarText);
//        resultText = getView().findViewById(R.id.resultText);
//        convertButton = getView().findViewById(R.id.convertButton);

        //resultText.setText(mViewModel.getResult().toString());

//        final Observer<Float> resultObserver = new Observer<Float>() {
//            @Override
//            public void onChanged(@Nullable final Float result) {
//                resultText.setText(result.toString());
//            }
//        };

        //mViewModel.getResult().observe(this, resultObserver);

//        convertButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if (!dollarText.getText().toString().equals("")){
//                    mViewModel.setAmount(dollarText.getText().toString());
//                    //resultText.setText(mViewModel.getResult().toString());
//                }
//                else{
//                    resultText.setText("No Value :(");
//                }
//            }
//        });
    }

}
