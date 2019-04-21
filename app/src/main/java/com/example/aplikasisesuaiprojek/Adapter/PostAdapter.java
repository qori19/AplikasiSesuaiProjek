package com.example.aplikasisesuaiprojek.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasisesuaiprojek.R;
import com.example.aplikasisesuaiprojek.model.PostItem;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Holder> {
    private List<PostItem> postList;
    private Context context;
    public PostAdapter(Context context, List<PostItem> artikelList) {
        this.context = context;
        this.postList = artikelList;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(PostAdapter.Holder holder, final int
            position) {
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }
    class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout openEdukasi;
        private TextView tvNama;
        public Holder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama_post);
            openEdukasi = itemView.findViewById(R.id.openEdukasi);
        }
        public void bind(final int position) {
            tvNama.setText(postList.get(position).getTitle());
            openEdukasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "clicked : " +
                                    tvNama.getText().toString() + "\n Position : " + String.valueOf(position),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
