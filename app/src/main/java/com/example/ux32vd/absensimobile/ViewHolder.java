package com.example.ux32vd.absensimobile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView){
        super(itemView);

        mView = itemView;

        //item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        //item long click
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
               mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails (Context ctx, int Status, String waktuAbsensi, String namaKelas, String namaMahasiswa, int idOrtu){
        TextView mStatus = mView.findViewById(R.id.textviewStatus);
        TextView mWaktuAbsensi = mView.findViewById(R.id.textviewWaktuAbsensi);
        TextView mNamaKelas = mView.findViewById(R.id.textviewNamaKelas);
        TextView mNamaMahasiswa = mView.findViewById(R.id.textviewNamaMahasiswa);
        TextView mIdOrtu = mView.findViewById(R.id.textviewIdOrtu);

        mStatus.setText(Status);
        mWaktuAbsensi.setText(waktuAbsensi);
        mNamaKelas.setText(namaKelas);
        mNamaMahasiswa.setText(namaMahasiswa);
        mIdOrtu.setText(idOrtu);
    }

    private ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick (View view, int position);
    }

    public void setOnClickListener (ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
