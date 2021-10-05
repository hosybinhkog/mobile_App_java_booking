package homestay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecthomestay.Activity.ShowDetailHomeStay;
import com.example.projecthomestay.R;

import java.util.List;

public class homestayAdapter extends RecyclerView.Adapter<homestayAdapter.HomestayHolder> {

    private List<homestay> homestays;

    public void setData(List<homestay> homestays){
        this.homestays = homestays;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomestayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_card_mathparent,parent,false);
        return  new HomestayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomestayHolder holder, @SuppressLint("RecyclerView") int position) {
        homestay homestay = homestays.get(position);
        if(homestay == null) return;

        holder.homestayImg.setImageResource(homestay.getResourceId());
        holder.homestayName.setText(homestay.getTitle());
        holder.addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailHomeStay.class);
                intent.putExtra("object",homestays.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(homestays != null) return  homestays.size();
        return 0;
    }


    public class HomestayHolder extends RecyclerView.ViewHolder{
        TextView homestayName;
        ImageView homestayImg;
        Button addProduct;

        public HomestayHolder(@NonNull View itemView) {
            super(itemView);
            homestayName = itemView.findViewById(R.id.name_category);
            homestayImg = itemView.findViewById(R.id.img_category);
            addProduct = itemView.findViewById(R.id.showDetail);
        }
    }
}
