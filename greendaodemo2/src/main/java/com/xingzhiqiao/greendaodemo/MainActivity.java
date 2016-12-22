package com.xingzhiqiao.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.xingzhiqiao.dao.gen.DaoSession;
import com.xingzhiqiao.dao.gen.StudentDao;
import com.xingzhiqiao.greendaodemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.DeleteListener {

    private ListView mPersonLv;
    public StudentAdapter studentAdapter;
    private List<Student> persons;
    private DaoSession daoSession;
    private StudentDao personDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPersonLv = (ListView) findViewById(R.id.testList);


        View footerView = LayoutInflater.from(this).inflate(R.layout.footer_view, null, false);

        final EditText nameEdit = (EditText) footerView.findViewById(R.id.edit_name);
        final EditText ageEdit = (EditText) footerView.findViewById(R.id.edit_age);
        Button addEdit = (Button) footerView.findViewById(R.id.edit_add);

        addEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(nameEdit.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "请输入姓名", 1).show();
                    return;
                }
                if (TextUtils.isEmpty(ageEdit.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "请输入年龄", 1).show();
                    return;
                }

                Student person = new Student();
                person.setName(nameEdit.getText().toString().trim());
                person.setAge(ageEdit.getText().toString().trim());

                nameEdit.setText("");
                ageEdit.setText("");

                nameEdit.requestFocus();


                persons.add(person);
                studentAdapter.notifyDataSetChanged();
                personDao.insert(person);
            }
        });

        daoSession = App.getInstace().getDaoSession();

        personDao = daoSession.getStudentDao();


        persons = personDao.loadAll();

        if (persons == null) {
            persons = new ArrayList<>();
        }


        studentAdapter = new StudentAdapter(this, persons);

        mPersonLv.addFooterView(footerView);
        mPersonLv.setAdapter(studentAdapter);

        studentAdapter.setmDeleteListener(this);

//        Person person = new Person();
//        person.setAge("18");
//        personDao.insert(person);


    }

    @Override
    public void deletePerson(Student student) {
        persons.remove(student);
        studentAdapter.notifyDataSetChanged();
        personDao.delete(student);
    }
}
