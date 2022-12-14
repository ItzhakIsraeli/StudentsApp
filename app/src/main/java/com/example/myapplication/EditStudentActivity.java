package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;

public class EditStudentActivity extends AppCompatActivity {
    private int studentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        EditText nameEt = findViewById(R.id.edit_student_name_et);
        EditText idEt = findViewById(R.id.edit_student_id_et);
        EditText phoneEt = findViewById(R.id.edit_student_phone_et);
        EditText addressEt = findViewById(R.id.edit_student_address_et);
        CheckBox checkBox = findViewById(R.id.edit_student_cb);

        Button saveBtn = findViewById(R.id.edit_student_save_btn);
        Button cancelBtn = findViewById(R.id.edit_student_cancel_btn);
        Button deleteBtn = findViewById(R.id.edit_student_delete_btn);

        studentPos = getIntent().getIntExtra("StudentPOS", -1);

        Student student = Model.instance().getStudentByPosition(studentPos);

        nameEt.setText(student.getName());
        idEt.setText(student.getId());
        phoneEt.setText(student.getPhone());
        addressEt.setText(student.getAddress());
        checkBox.setChecked(student.getCb());

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            Boolean cb = checkBox.isChecked();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();

            Model.instance().editStudent(new Student(name, id, cb, phone, address), studentPos);
            finish();
        });

        cancelBtn.setOnClickListener(view -> {
            finish();
        });

        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(studentPos);
            Intent intent = new Intent(this, StudentRecyclerList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}