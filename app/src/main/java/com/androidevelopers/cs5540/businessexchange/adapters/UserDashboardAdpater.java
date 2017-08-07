package com.androidevelopers.cs5540.businessexchange.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.activity.ProfessionalViewLayout;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.squareup.picasso.Picasso;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/4/17.
 */

// Adapter for User Dash Board.. List of Professionals will be Attached to Recycler View.

public class UserDashboardAdpater extends RecyclerView.Adapter<UserDashboardAdpater.UserDashboardViewHolder> {
    ArrayList<ProfessionalData> professionals ;
    Context context;
    public UserDashboardAdpater(ArrayList<ProfessionalData> professionals, Context context){
        this.professionals=professionals;
        this.context=context;
    }

    @Override
    public UserDashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        boolean shouldAttachToParentImmediately= false;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_dashboard_item, parent, shouldAttachToParentImmediately);
        return new UserDashboardViewHolder(view,context,professionals);
    }

    @Override
    public void onBindViewHolder(UserDashboardViewHolder holder, int position) {
        holder.professionalName.setText(professionals.get(position).getFirstName()+" "+professionals.get(position).getLastName());
        holder.professionalProfession.setText(professionals.get(position).getProfession());
        holder.professionalCity.setText(professionals.get(position).getCity()+" , "+professionals.get(position).getState());
        Picasso.with(context)
                .load(professionals.get(position).getImageUrl()).resize(120,120)
                .into(holder.professionalImage);
    }

    @Override
    public int getItemCount() {
        Log.i("size from adater: ", String.valueOf(professionals.size()));
        return professionals.size();

    }

    public class UserDashboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView professionalImage;
        TextView professionalName;
        TextView professionalCity;
        TextView professionalProfession;
        ArrayList<ProfessionalData> professionals = new ArrayList<>();
        Context context;
        public UserDashboardViewHolder(View itemView, Context context, ArrayList<ProfessionalData>  professionals) {
            super(itemView);
            this.context=context;
            this.professionals=professionals;
            professionalImage=(ImageView) itemView.findViewById(R.id.professional_image_item_view);
            professionalName=(TextView) itemView.findViewById(R.id.professional_name_item_view);
            professionalCity=(TextView) itemView.findViewById(R.id.professional_city_item_view);
            professionalProfession=(TextView) itemView.findViewById(R.id.professional_profession_item_view);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            ProfessionalData professionalData = this.professionals.get(position);
            Gson gS = new Gson();
            String target = gS.toJson(professionalData);
            Intent intent = new Intent(this.context, ProfessionalViewLayout.class);
            intent.putExtra("professionalDataObject", target);
            this.context.startActivity(intent);
        }
    }
}
