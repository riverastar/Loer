package com.example.loer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.loer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    EditText et_d;
    BottomNavigationView n_v;
    Button btn_c;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                et_d = (EditText) root.findViewById(R.id.etxt_documento);
                btn_c = (Button) root.findViewById(R.id.btn_consultar);

                et_d.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        n_v = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
                        switch (v.getId()){
                            case R.id.etxt_documento:

                                if (n_v.getVisibility()== v.VISIBLE){
                                    n_v.setVisibility(v.GONE);

                                }else{
                                    n_v.setVisibility(v.VISIBLE);

                                }
                                break;
                            case R.id.nav_view:
                        }
                        return false;
                    }
                });
                btn_c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(n_v.getVisibility()== v.GONE){
                            n_v.setVisibility(v.VISIBLE);
                        }
                    }
                });
            }
        });
        return root;
    }
}