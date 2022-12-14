package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.add_student_name_et);
        EditText idEt = findViewById(R.id.add_student_id_et);
        EditText phoneEt = findViewById(R.id.add_student_phone_et);
        EditText addressEt = findViewById(R.id.add_student_address_et);
        CheckBox checkBox = findViewById(R.id.add_student_cb);
        Button saveBtn = findViewById(R.id.add_student_save_btn);
        Button cancelBtn = findViewById(R.id.add_student_cancel_btn);

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            Boolean cb = checkBox.isChecked();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();

            Model.instance().addStudent(new Student(name, id, cb, phone, address));
            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}