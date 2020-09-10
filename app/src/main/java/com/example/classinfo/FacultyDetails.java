package com.example.classinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {

    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName,phoneNumber,email,faculty_subject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
        setupUIViews();
        initToolBar();
    }

    private void setupUIViews()
    {
        toolbar=(androidx.appcompat.widget.Toolbar) findViewById(R.id.ToolbarFacultyDetails);
        facultyImage= (CircleImageView) findViewById(R.id.ivCircle);
        facultyName= (TextView) findViewById(R.id.FacultyName);
        phoneNumber=(TextView) findViewById(R.id.tvPhonenumber);
        email=(TextView) findViewById(R.id.tvEmail);
        faculty_subject=(TextView) findViewById(R.id.faculty_sub);

    }
    private void initToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}