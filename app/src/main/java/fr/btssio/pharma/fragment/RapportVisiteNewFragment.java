package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.btssio.pharma.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RapportVisiteNewFragment extends Fragment {


    public RapportVisiteNewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rapport_visite_new, container, false);
    }

}
