package com.example.classinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
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
        setupFacultyDetails();
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

    private void setupFacultyDetails()
    {
        int faculty_selected=FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_Faculty,0);
        String[] faculty_names=getResources().getStringArray(R.array.Faculty_name);
        int[] faculty_images=new int[]{R.drawable.abhijit,R.drawable.palan,R.drawable.ashish,R.drawable.mcn,R.drawable.gln,R.drawable.rebekka,R.drawable.thavasi,R.drawable.kavitha};
        int[] facultyArray=new int[]{R.array.Dr_AbhijitDas,R.array.Dr_P_Palanisamy,R.array.Dr_AshishPatil,R.array.Dr_P_Muthuchidambaranathan,
                R.array.Dr_G_LakshmiNarayanan,R.array.Dr_B_Rebekka,R.array.Dr_G_ThavasiRaja,R.array.Ms_R_K_Kavitha};
        String[] facultyDetails=getResources().getStringArray(facultyArray[faculty_selected]);
        phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        faculty_subject.setText(facultyDetails[2]);
        facultyName.setText(faculty_names[faculty_selected]);
        facultyImage.setImageResource(faculty_images[faculty_selected]);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home :{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}