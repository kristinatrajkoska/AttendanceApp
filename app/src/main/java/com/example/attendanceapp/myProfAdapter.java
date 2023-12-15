package com.example.attendanceapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class myProfAdapter extends RecyclerView.Adapter<myProfAdapter.ViewHolder> {

    private List<String> myList;
    private int rowLayout;
    private Context pContext;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView myStuff;
        public ImageView pict;

        public ViewHolder(View itemView){
            super(itemView);
            myStuff=(TextView) itemView.findViewById(R.id.ListStuff);
            pict=(ImageView) itemView.findViewById(R.id.pictureP);
        }
    }

    public myProfAdapter(List<String> myList, int rowLayout, Context context){
        this.myList=myList;
        this.rowLayout=rowLayout;
        this.pContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int i){
        String entry=myList.get(i);
        viewHolder.myStuff.setText(entry);
        viewHolder.myStuff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv1=(TextView) v;
                Intent intent=new Intent(pContext, Subjects.class);
                pContext.startActivity(intent);
            }
        });
        viewHolder.pict.setImageResource(R.drawable.green);
    }

    @Override
    public int getItemCount(){
        return myList == null ? 0 : myList.size();
    }
}
