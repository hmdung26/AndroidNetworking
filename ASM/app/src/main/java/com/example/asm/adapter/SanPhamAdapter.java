package com.example.asm.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.MainActivity;
import com.example.asm.R;
import com.example.asm.api.apiService;
import com.example.asm.model.SanPham;
import com.example.asm.model.DeleteSp;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder>{


    private List<SanPham> ltsSP;
    private Context context;


    public SanPhamAdapter(List<SanPham> ltsSP) {
        this.ltsSP = ltsSP;
    }
    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = ltsSP.get(position);
        if (sanPham == null){
            return;
        }
        String _id = ltsSP.get(position).get_id();
        String imgSrc = ltsSP.get(position).getImage();
        holder.txtTenSp.setText(sanPham.getNameproduct());
        holder.txtMoTaSP.setText(sanPham.getDescription());
        //holder.txtSoLuongSP.setText(sanPham.getImage());
        holder.txtGiaSP.setText(sanPham.getPrice());
        Picasso.get().load(Uri.parse(imgSrc)).into(holder.imgSP);


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                callApiXoaSP(_id,adapterPosition);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (ltsSP != null){
            return ltsSP.size();

        }
        return 0;
    }

    class SanPhamViewHolder extends RecyclerView.ViewHolder{

        TextView txtTenSp,txtMoTaSP,txtGiaSP,txtSoLuongSP;
        ImageView imgSP;
        Button btnEdit,btnDelete;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTenSp = itemView.findViewById(R.id.idTenSanPham);
            txtMoTaSP = itemView.findViewById(R.id.idMoTaSanPham);
            txtGiaSP = itemView.findViewById(R.id.idGiaSanPham);

            imgSP = itemView.findViewById(R.id.imgSanPham);
            btnEdit = itemView.findViewById(R.id.btnSua);
            btnDelete = itemView.findViewById(R.id.btnXoa);
        }
    }
    private void callApiXoaSP(String _id, int position){

        DeleteSp deleteSp = new DeleteSp(_id);
        apiService.Apiservice.xoaSP(deleteSp).enqueue(new Callback<DeleteSp>() {
            @Override
            public void onResponse(Call<DeleteSp> call, Response<DeleteSp> response) {
                if (response.isSuccessful()) {
                    ltsSP.remove(position);
                    notifyDataSetChanged();

                } else {
                    Log.e("API_CALL_ERROR", "Error code: " + response.code());

                }
            }

            @Override
            public void onFailure(Call<DeleteSp> call, Throwable t) {
                Log.e("API_CALL_ERROR", "Error: " + t.getMessage());


            }
        });
    }
}
