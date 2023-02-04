package com.news.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Newsmodel> retrievedResponses;
    private Context context;

    public RecyclerViewAdapter(List<Newsmodel> retrievedResponses, Context context) {
        this.retrievedResponses = retrievedResponses;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

//        private TextView id_field;
//        private TextView email_field;
//        private TextView first_name_field;
//        private TextView last_name_field;

        private final ImageView player_imageView;
        private final ImageView source_logo;


        private TextView id;
        private TextView pid;
        private final TextView time;
        private TextView time_pst;
        private final TextView pname;
        private TextView is_favorite;
        private final TextView position;
        private TextView title;
        private final TextView details;
        private TextView source;
        private TextView source_name;
        private TextView source_url;
        private TextView hash_url;
        private TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pname = itemView.findViewById(R.id.pname);
            details = itemView.findViewById(R.id.textView4);
            position = itemView.findViewById(R.id.textView2);
            time = itemView.findViewById(R.id.textView5);
            player_imageView = itemView.findViewById(R.id.player_imageView);
            source_logo = itemView.findViewById(R.id.imageView2);
            title=itemView.findViewById(R.id.textView3);
        }

        public void setId_pname(String id) {
            pname.setText(id);
        }
        public void setId_details(String id) {
            details.setText(id);
        }
        public void setId_position(String id) {
            position.setText(id);
        }
        public void setId_time(String id) {
            time.setText(id);
        }
        public void setId_title(String id) {
            title.setText(id);
        }

//        public void player_imageView(String id) {
//            position.setText(id);
//        }
//        public void player_image_url(String id) {
//            position.setText(id);
//        }




//        public void setId_pname(String id) {
//            pname.setText(id);
//        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newslayout1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Newsmodel courses = retrievedResponses.get(position);

        holder.setId_pname(retrievedResponses.get(position).getPname());
//
        holder.setId_details(retrievedResponses.get(position).getDetails());
        holder.setId_position(retrievedResponses.get(position).getPosition());
        holder.setId_time(retrievedResponses.get(position).getTime());







        holder.setId_title(retrievedResponses.get(position).getTitle());

        Picasso.with(context).load(courses.getPlayer_image_url()).into(holder.player_imageView);


        Picasso.with(context).load(courses.getSource_logo()).into(holder.source_logo);



//        holder.player_imageView(retrievedResponses.get(position).getPlayer_image_url());
//        holder.player_image_url(retrievedResponses.get(position).getPlayer_image_url());
//
//        Context context = holder.player_imageView.getContext();
//        Picasso.with(context).load(holder.player_imageView(retrievedResponses.get(position)).into(holder.player_imageView);
    }

    @Override
    public int getItemCount() {

        return retrievedResponses.size();
    }
}
