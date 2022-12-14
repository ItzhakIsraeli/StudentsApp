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
    private TextView name;
    private TextView id;
    private TextView phone;
    private TextView address;
    private CheckBox checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        name = findViewById(R.id.student_details_name_tv);
        id = findViewById(R.id.student_details_id_tv);
        phone = findViewById(R.id.student_details_phone_tv);
        address = findViewById(R.id.student_details_address_tv);
        checked = findViewById(R.id.student_details_cb);
        Button editBtn = findViewById(R.id.student_details_edit_btn);

        studentPos = getIntent().getIntExtra("StudentPOS", -1);
        updateChanges();

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditStudentActivity.class);
            intent.putExtra("StudentPOS", studentPos);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateChanges();
    }

    private void updateChanges() {
        Student student = Model.instance().getStudentByPosition(studentPos);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checked.setChecked(student.getCb());
    }
}