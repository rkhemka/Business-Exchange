package com.androidevelopers.cs5540.businessexchange.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.models.QueriesResponsesData;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/7/17.
 */

public class ProfessionalDashboardAdpater extends RecyclerView.Adapter<ProfessionalDashboardAdpater.ProfessionalDashboardViewHolder> {

    private ProfessionalDashboardItemClickListener listener;
    ArrayList<QueriesResponsesData> queries;
    Context context;

    public ProfessionalDashboardAdpater(ArrayList<QueriesResponsesData> queries, Context context, ProfessionalDashboardItemClickListener listener) {
        this.context = context;
        this.queries = queries;
        this.listener = listener;
    }

    public interface ProfessionalDashboardItemClickListener {
        void onItemClick( int clickedItemIndex);
    }

    @Override
    public ProfessionalDashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        boolean shouldAttachToParentImmediately = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_card_notification, parent, shouldAttachToParentImmediately);
        return new ProfessionalDashboardViewHolder(view, context, queries);
    }

    @Override
    public void onBindViewHolder(ProfessionalDashboardViewHolder holder, int position) {
     //   holder.QueryFromTextView.setText(queries.get(position).getUsername());
        holder.QueryTextView.setText(queries.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return queries.size();
    }

    public class ProfessionalDashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView QueryFromTextView;
        TextView QueryTextView;
        ArrayList<QueriesResponsesData> queries;
        Context context;

        public ProfessionalDashboardViewHolder(View itemView, Context context, ArrayList<QueriesResponsesData> queries) {
            super(itemView);
            QueryFromTextView = (TextView) itemView.findViewById(R.id.user_card_notification_txt_from);
            QueryTextView = (TextView) itemView.findViewById(R.id.user_card_notification_query);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            listener.onItemClick(position);
        }
    }
}
