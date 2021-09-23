package Popular;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthomestay.R;

import java.util.List;


public class PopularAdaptor extends  RecyclerView.Adapter<PopularAdaptor.PopularViewHolder>{

    private List<Popular> populars;

    public  void setData(List<Popular> populars){
        this.populars = populars;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return  new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {
        Popular popular = populars.get(position);
        if(popular == null) return;
        holder.imgPopular.setImageResource(popular.getResourceId());
        holder.titlePopular.setText(popular.getTitle());
        holder.descPopular.setText(popular.getDesc());
    }

    @Override
    public int getItemCount() {
        if(populars != null) return populars.size();
        return 0;
    }

    public class  PopularViewHolder extends RecyclerView.ViewHolder{
        TextView titlePopular;
        TextView descPopular;
        ImageView imgPopular;
        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            titlePopular = itemView.findViewById(R.id.title_popular);
            descPopular = itemView.findViewById(R.id.desc_popular);
            imgPopular = itemView.findViewById(R.id.img_popular);
        }
    }
}
