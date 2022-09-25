package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    Button button2;
    ImageButton imageButton10;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button2=(Button)getActivity().findViewById(R.id.button2);
        imageButton10 = (ImageButton) getActivity().findViewById(R.id.imagebutton10);

    }




    public void btnClickAct3(View view) {
        Intent l = new Intent(getActivity().getApplicationContext(), booktickets.class);
        startActivity(l);
//        finish();
    }

    public void btnClickAct4(View view) {
        Intent f = new Intent(getActivity().getApplicationContext(), webview.class);
        startActivity(f);
//        finish();
    }

    public void btnClickAct5(View view) {
        Intent a = new Intent(getActivity().getApplicationContext(), listview.class);
        startActivity(a);
    }
}
