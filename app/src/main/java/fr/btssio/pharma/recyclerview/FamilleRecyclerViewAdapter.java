package fr.btssio.pharma.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.btssio.pharma.R;
import fr.btssio.pharma.fragment.FamilleFragment.OnListFragmentInteractionListener;
import fr.btssio.pharma.orm.gen.Famille;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Famille} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class FamilleRecyclerViewAdapter extends RecyclerView.Adapter<FamilleRecyclerViewAdapter.ViewHolder> {

    private final List<Famille> mFamilles;
    private final OnListFragmentInteractionListener mListener;

    public FamilleRecyclerViewAdapter(List<Famille> familles, OnListFragmentInteractionListener listener) {
        mFamilles = familles;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_famille, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mFamille = mFamilles.get(position);
        holder.mFamilleLibelleView.setText(mFamilles.get(position).getFamLibelle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mFamille);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFamilles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mFamilleLibelleView;
        public Famille mFamille;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mFamilleLibelleView = (TextView) view.findViewById(R.id.tvFamilleLibelle);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mFamilleLibelleView.getText() + "'";
        }
    }
}
