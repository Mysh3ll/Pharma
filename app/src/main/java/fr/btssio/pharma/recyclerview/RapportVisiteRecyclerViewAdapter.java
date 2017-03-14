package fr.btssio.pharma.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.btssio.pharma.R;
import fr.btssio.pharma.fragment.RapportVisiteFragment.OnListFragmentInteractionListener;
import fr.btssio.pharma.orm.gen.RapportVisite;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link RapportVisite} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RapportVisiteRecyclerViewAdapter extends RecyclerView.Adapter<RapportVisiteRecyclerViewAdapter.ViewHolder> {

    private final List<RapportVisite> mRapportsVisites;
    private final OnListFragmentInteractionListener mListener;

    public RapportVisiteRecyclerViewAdapter(List<RapportVisite> rapportVisites, OnListFragmentInteractionListener listener) {
        mRapportsVisites = rapportVisites;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_rapport_visite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mRapportVisite = mRapportsVisites.get(position);
        holder.mRapportVisiteNumView.setText("Numéro de rapport : " + mRapportsVisites.get(position).getRapNum().toString());
        holder.mRapportVisiteDateView.setText("fait le : " + mRapportsVisites.get(position).getRapDate());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mRapportVisite);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRapportsVisites.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mRapportVisiteNumView;
        public final TextView mRapportVisiteDateView;
        public RapportVisite mRapportVisite;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mRapportVisiteNumView = (TextView) view.findViewById(R.id.tvRapportVisiteNum);
            mRapportVisiteDateView = (TextView) view.findViewById(R.id.tvRapportVisiteDate);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mRapportVisiteDateView.getText() + "'";
        }
    }
}
