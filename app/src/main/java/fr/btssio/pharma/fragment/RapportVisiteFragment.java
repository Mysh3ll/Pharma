package fr.btssio.pharma.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.RapportVisite;
import fr.btssio.pharma.orm.gen.RapportVisiteDAO;
import fr.btssio.pharma.orm.gen.RapportVisiteDAOImpl;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.orm.runtime.query.OrderByDirection;
import fr.btssio.pharma.recyclerview.RapportVisiteRecyclerViewAdapter;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RapportVisiteFragment extends Fragment {
    // the fragment initialization parameters, e.g. VIS_MAT
    private static final String VIS_MAT = "vis_mat";

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RapportVisiteDAO rapportVisiteDAO;
    private VisiteurDAO visiteurDAO;
    private Visiteur visiteur;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RapportVisiteFragment() {
    }

    @SuppressWarnings("unused")
    public static RapportVisiteFragment newInstance(int columnCount, String vis_mat) {
        RapportVisiteFragment fragment = new RapportVisiteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putString(VIS_MAT, vis_mat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            String mVis_mat = getArguments().getString(VIS_MAT);
            //Récupération du visiteur connecté
            visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            visiteur = visiteurDAO.getByVisMat(mVis_mat);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rapport_visite_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // Récupération des rapports de visite en BDD
            rapportVisiteDAO = new RapportVisiteDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            List<RapportVisite> rapportVisites = rapportVisiteDAO.getRapportVisiteList(RapportVisiteDAO.VISITEUR_VIS_MAT.eq(visiteur.getVisMat()));
            recyclerView.setAdapter(new RapportVisiteRecyclerViewAdapter(rapportVisites, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(RapportVisite rapportVisite);
    }
}
