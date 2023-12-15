package com.example.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mySubjectAdapter extends RecyclerView.Adapter<mySubjectAdapter.ViewHolder> {

    private List<String> myList;
    private int rowLayout;
    private Context sContext;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mySubject;
        public ImageView pic;

        public ViewHolder(View itemView){
            super(itemView);
            mySubject=(TextView) itemView.findViewById(R.id.NameSubject);
            pic=(ImageView) itemView.findViewById(R.id.picture);
        }
    }

    public mySubjectAdapter(List<String> myList, int rowLayout, Context context){
        this.myList=myList;
        this.rowLayout=rowLayout;
        this.sContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int i){
        String entry=myList.get(i);
        viewHolder.mySubject.setText(entry);
        viewHolder.mySubject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv=(TextView) v;
                Toast.makeText(sContext,tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.pic.setImageResource(R.drawable.cover1);
    }

    @Override
    public int getItemCount(){
        return myList==null ? 0 : myList.size();
    }
}
