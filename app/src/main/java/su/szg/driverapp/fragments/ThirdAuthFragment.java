package su.szg.driverapp.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import su.szg.driverapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdAuthFragment extends Fragment {


    public ThirdAuthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_auth, container, false);
    }

}
