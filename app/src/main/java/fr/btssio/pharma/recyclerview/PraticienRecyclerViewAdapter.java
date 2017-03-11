package fr.btssio.pharma.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.btssio.pharma.R;
import fr.btssio.pharma.fragment.PraticienFragment.OnListFragmentInteractionListener;
import fr.btssio.pharma.orm.gen.Praticien;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Praticien} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PraticienRecyclerViewAdapter extends RecyclerView.Adapter<PraticienRecyclerViewAdapter.ViewHolder> {

    private final List<Praticien> mPraticiens;
    private final OnListFragmentInteractionListener mListener;

    public PraticienRecyclerViewAdapter(List<Praticien> praticiens, OnListFragmentInteractionListener listener) {
        mPraticiens = praticiens;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_praticien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mPraticien = mPraticiens.get(position);
        holder.mPraticienNomView.setText(mPraticiens.get(position).getPraNom());
        holder.mPraticienPrenomView.setText(mPraticiens.get(position).getPraPrenom());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mPraticien);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPraticiens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mPraticienNomView;
        public final TextView mPraticienPrenomView;
        public Praticien mPraticien;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPraticienNomView = (TextView) view.findViewById(R.id.tvPraticienNom);
            mPraticienPrenomView = (TextView) view.findViewById(R.id.tvPraticienPrenom);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPraticienPrenomView.getText() + "'";
        }
    }
}
