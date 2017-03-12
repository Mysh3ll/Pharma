package fr.btssio.pharma.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.btssio.pharma.R;
import fr.btssio.pharma.fragment.MedicamentFragment.OnListFragmentInteractionListener;
import fr.btssio.pharma.orm.gen.Medicament;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Medicament} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MedicamentRecyclerViewAdapter extends RecyclerView.Adapter<MedicamentRecyclerViewAdapter.ViewHolder> {

    private final List<Medicament> mMedicaments;
    private final OnListFragmentInteractionListener mListener;

    public MedicamentRecyclerViewAdapter(List<Medicament> medicaments, OnListFragmentInteractionListener listener) {
        mMedicaments = medicaments;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_medicament, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mMedicament = mMedicaments.get(position);
        holder.mMedicamentNomView.setText(mMedicaments.get(position).getMedNomcom());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mMedicament);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMedicaments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mMedicamentNomView;
        public Medicament mMedicament;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mMedicamentNomView = (TextView) view.findViewById(R.id.tvMedicamentNom);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMedicamentNomView.getText() + "'";
        }
    }
}
