package fr.btssio.pharma.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.btssio.pharma.R;
import fr.btssio.pharma.fragment.VisiteurFragment.OnListFragmentInteractionListener;
import fr.btssio.pharma.orm.gen.Visiteur;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Visiteur} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class VisiteurRecyclerViewAdapter extends RecyclerView.Adapter<VisiteurRecyclerViewAdapter.ViewHolder> {

    private final List<Visiteur> mVisiteurs;
    private final OnListFragmentInteractionListener mListener;

    public VisiteurRecyclerViewAdapter(List<Visiteur> visiteurs, OnListFragmentInteractionListener listener) {
        mVisiteurs = visiteurs;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_visiteur, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mVisiteur = mVisiteurs.get(position);
        holder.mVisiteurNomView.setText(mVisiteurs.get(position).getVisNom());
        holder.mVisiteurPrenomView.setText(mVisiteurs.get(position).getVisPrenom());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mVisiteur);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVisiteurs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mVisiteurNomView;
        public final TextView mVisiteurPrenomView;
        public Visiteur mVisiteur;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mVisiteurNomView = (TextView) view.findViewById(R.id.tvVisiteurNom);
            mVisiteurPrenomView = (TextView) view.findViewById(R.id.tvVisiteurPrenom);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mVisiteurPrenomView.getText() + "'";
        }
    }
}
