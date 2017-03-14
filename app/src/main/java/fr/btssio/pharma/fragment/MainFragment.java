package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.btssio.pharma.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. VIS_MAT
    private static final String VIS_MAT = "vis_mat";
    private String mVis_mat;


    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param vis_mat Matricule du visiteur.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String vis_mat) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(VIS_MAT, vis_mat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVis_mat = getArguments().getString(VIS_MAT);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_main, container, false);

        Button btnNewRapport = (Button) view.findViewById(R.id.btnNewRapport);
        btnNewRapport.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        RapportVisiteNewFragment rapportVisiteNewFragment = RapportVisiteNewFragment.newInstance(mVis_mat);
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        rapportVisiteNewFragment,
                        rapportVisiteNewFragment.getTag()
                ).commit();
    }
}
