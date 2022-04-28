package com.example.android_application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class programAdapter extends RecyclerView.Adapter <programAdapter.ViewHolder> {

    Context context;
    String[] programNameList;
    String[] programDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;
        Button enroll;
        MyClickListener listener;
        //notification
        public void sendNotification() {}

        public ViewHolder(@NonNull View itemView,MyClickListener listener) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView);
            enroll = itemView.findViewById(R.id.enrollBtn);
            this.listener = listener;
            enroll.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            listener.onEnroll(this.getLayoutPosition());
        }
        public interface    MyClickListener {
            void onEnroll(int p);



        }

        //itemView.findViewById(R.id.enrollBtn).setOnClickListener(new View.OnClickListener(){
        //@Override
        //public void onClick(View view) {
        //Intent i=new Intent(Salma.class);
        //StartActivity(i);

        //}
        //});
    }




    public programAdapter(Context context,String[]programNameList,String[]programDescriptionList,int[]images){
        this.context= context;
        this.programNameList =programNameList;
        this.programDescriptionList=programDescriptionList;
        this.images =images;
    }

    @NonNull
    @Override
    //programAdapter.ViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.single_item,parent,false);
        ViewHolder viewHolder = new ViewHolder( view ,new ViewHolder.MyClickListener() {
            @Override
            public void onEnroll(int p) {
                //Create intent getting the context of your View and the class where you want to go
                Intent intent = new Intent(view.getContext(), Courses.class);

                //start the activity from the view/context
                view.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    //programAdapter.ViewHolder holder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowDescription.setText(programDescriptionList[position]);
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {

        return programNameList.length;
    }
}
