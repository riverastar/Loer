package com.example.loer.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.loer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardFragment extends Fragment {
    EditText et_n;
    BottomNavigationView n_v;
    Button btn_i;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

                et_n = (EditText) root.findViewById(R.id.et_nombre);




                et_n.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        n_v = (BottomNavigationView) getActivity().findViewById(R.id.nav_view);
                        switch (view.getId()){
                            case R.id.et_nombre:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }
                                break;
                            case R.id.et_documento:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }
                                break;
                            case R.id.et_celular:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }
                                break;
                            case R.id.et_edad:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }
                                break;
                            case R.id.et_posicion:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }
                                break;
                            case R.id.et_equipo:
                                if(n_v.getVisibility()== view.VISIBLE){
                                    n_v.setVisibility(view.GONE);
                                }else {

                                }
                                break;
                        }
                    }
                });
            }
        });

        return root;
    }


}