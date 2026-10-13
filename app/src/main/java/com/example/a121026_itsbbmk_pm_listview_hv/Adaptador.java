package com.example.a121026_itsbbmk_pm_listview_hv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    Context context;
    String[] idk;
    String[] idk1;
    int[] idk2;
    LayoutInflater inflater;
    // InTERFAZ JAvA, cOMUNICACIÓN DiRECTA CoN MaIN (SaBER QUe ObJETO SE PrESIONO)
    private OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Adaptador(Context context, String[] idk, String[] idk1, int[] idk2) {
        this.context = context;
        this.idk = idk;
        this.idk1 = idk1;
        this.idk2 = idk2;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.trash, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(idk[position]);
        holder.textView1.setText(idk1[position]);
        holder.idkimg.setImageResource(idk2[position]);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return idk.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView1;
        ImageView idkimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt1);
            textView1 = itemView.findViewById(R.id.txt2);
            idkimg = itemView.findViewById(R.id.img1);
        }
    }
}