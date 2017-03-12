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
import fr.btssio.pharma.orm.gen.Medicament;
import fr.btssio.pharma.orm.gen.MedicamentDAO;
import fr.btssio.pharma.orm.gen.MedicamentDAOImpl;
import fr.btssio.pharma.orm.runtime.query.OrderByDirection;
import fr.btssio.pharma.recyclerview.MedicamentRecyclerViewAdapter;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MedicamentFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String FAM_CODE = "fam_code";

    // TODO: Customize parameters
    private int mColumnCount = 1;
    private String mFam_code;
    private OnListFragmentInteractionListener mListener;
    private MedicamentDAO medicamentDAO;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MedicamentFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MedicamentFragment newInstance(int columnCount, String famCode) {
        MedicamentFragment fragment = new MedicamentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putString(FAM_CODE, famCode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mFam_code = getArguments().getString(FAM_CODE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicament_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //Récupération des familles de médicaments en BDD
            medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            List<Medicament> medicaments = medicamentDAO.getMedicamentList(MedicamentDAO.FAMILLE_FAM_CODE.eq(mFam_code));
            recyclerView.setAdapter(new MedicamentRecyclerViewAdapter(medicaments, mListener));
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
        void onListFragmentInteraction(Medicament medicament);
    }
}
