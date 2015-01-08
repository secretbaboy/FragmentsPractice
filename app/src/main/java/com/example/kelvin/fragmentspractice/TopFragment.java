package com.example.kelvin.fragmentspractice;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopFragment extends Fragment {

    private static EditText topTextInput;
    private static EditText bottomTextInput;
    Button button;

    TopSectionListener activityCommander;
    public interface TopSectionListener{

        public void createMeme(String top,String bottom);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment,container,false);
        topTextInput = (EditText) view.findViewById(R.id.topInputText);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomInputText);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityCommander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        try {
            activityCommander = (TopSectionListener) activity;
            super.onAttach(activity);
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }
}
