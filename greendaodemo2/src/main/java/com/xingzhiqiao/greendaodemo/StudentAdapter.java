package com.xingzhiqiao.greendaodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.xingzhiqiao.greendaodemo.bean.Student;

import java.util.List;


/**
 * Created by xingzhiqiao on 2016/12/22.
 */

public class StudentAdapter extends BaseAdapter {

    private List<Student> persons;
    private Context context;

    public DeleteListener getmDeleteListener() {
        return mDeleteListener;
    }

    public void setmDeleteListener(DeleteListener mDeleteListener) {
        this.mDeleteListener = mDeleteListener;
    }

    private DeleteListener mDeleteListener;


    public StudentAdapter(Context context, List<Student> persons) {
        this.context = context;
        this.persons = persons;
    }


    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);


        final Student person = persons.get(position);
        TextView name = (TextView) convertView.findViewById(R.id.item_name);
        TextView age = (TextView) convertView.findViewById(R.id.item_age);
        Button delete = (Button) convertView.findViewById(R.id.delete);


        name.setText(person.getName());
        age.setText(person.getAge());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDeleteListener.deletePerson(person);
            }
        });


        return convertView;
    }

    public interface DeleteListener {
        void deletePerson(Student person);
    }

}
