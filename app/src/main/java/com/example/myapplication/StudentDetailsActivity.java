package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    private int studentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        TextView name = findViewById(R.id.student_details_name_tv);
        TextView id = findViewById(R.id.student_details_id_tv);
        TextView phone = findViewById(R.id.student_details_phone_tv);
        TextView address = findViewById(R.id.student_details_address_tv);
        CheckBox checked = findViewById(R.id.student_details_cb);
        Button editBtn = findViewById(R.id.student_details_edit_btn);

        studentPos = getIntent().getIntExtra("StudentPOS", -1);

        Student student = Model.instance().getStudentByPosition(studentPos);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checked.setChecked(student.getCb());

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditStudentActivity.class);
            intent.putExtra("StudentPOS", studentPos);
            startActivity(intent);
        });
    }
}