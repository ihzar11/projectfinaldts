package org.android.jplas.finalprojectdts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.android.jplas.finalprojectdts.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> fotoMakanan, ArrayList<String> namaMakanan, Context context) {
        this.fotoMakanan = fotoMakanan;
        this.namaMakanan = namaMakanan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(fotoMakanan.get(position)).into(holder.imageViewFotoMakanan);

        holder.textViewNamaMakanan.setText(namaMakanan.get(position));
    }

    @Override
    public int getItemCount() {
        return namaMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageViewFotoMakanan;
        TextView textViewNamaMakanan;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFotoMakanan = itemView.findViewById(R.id.imageViewFotoMakanan);
            textViewNamaMakanan = itemView.findViewById(R.id.textViewNamaMakanan);
            constraintLayout = itemView.findViewById(R.id.constraintlayout);
        }
    }
}
