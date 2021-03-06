package com.androidevelopers.cs5540.businessexchange.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidevelopers.cs5540.businessexchange.R;
import com.androidevelopers.cs5540.businessexchange.models.ProfessionalData;
import com.firebase.client.Firebase;

import java.util.ArrayList;

/**
 * Created by rohangoel on 8/4/17.
 */

public class UserDashboardAdpater extends RecyclerView.Adapter<UserDashboardAdpater.UserDashboardViewHolder> {
    ArrayList<ProfessionalData> professionals = new ArrayList<ProfessionalData>();
    Context context;
    public UserDashboardAdpater(ArrayList<ProfessionalData> professionals, Context context){
        this.professionals=professionals;
        this.context=context;
    }
    @Override
    public UserDashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        boolean shouldAttachToParentImmediately= false;
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_dashboard_item, parent, shouldAttachToParentImmediately);
        return new UserDashboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserDashboardViewHolder holder, int position) {
        holder.professionalName.setText(professionals.get(position).getFirstName()+" "+professionals.get(position).getLastName());
        holder.professionalProfession.setText(professionals.get(position).getProfession());
        holder.professionalCity.setText(professionals.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return professionals.size();
    }

    public class UserDashboardViewHolder extends RecyclerView.ViewHolder {
        ImageView professionalImage;
        TextView professionalName;
        TextView professionalCity;
        TextView professionalProfession;
//        ArrayList<ProfessionalData> professionals = new ArrayList<>();
//        Context context;
        public UserDashboardViewHolder(View itemView) {
            super(itemView);
//            this.context=context;
//            this.professionals=professionals;
            professionalImage=(ImageView) itemView.findViewById(R.id.professional_image_item_view);
            professionalName=(TextView) itemView.findViewById(R.id.professional_name_item_view);
            professionalCity=(TextView) itemView.findViewById(R.id.professional_city_item_view);
            professionalProfession=(TextView) itemView.findViewById(R.id.professional_profession_item_view);
        }
    }
}
