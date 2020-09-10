package com.example.classinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.classinfo.Utils.LetterImageView;

public class Syllabus extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String subject_selected;
    private String[] syllabus;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        setupUIViews();
        initToolBar();
        setupListView();
    }

    private void setupUIViews()
    {
        toolbar =(Toolbar) findViewById(R.id.ToolbarSyllabus);
        listView =(ListView) findViewById(R.id.lvSyllabus);
    }
    private void initToolBar()
    {
        setSupportActionBar(toolbar);
         subject_selected=SubjectActivity.subjectPreferences.getString(SubjectActivity.Sub_Pref,null);
        getSupportActionBar().setTitle(subject_selected);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView()
    {
        titles=getResources().getStringArray(R.array.titles);
        if (subject_selected.equalsIgnoreCase("Mathematics"))
        {
            syllabus=getResources().getStringArray(R.array.Mathematics);
        }
        else if(subject_selected.equalsIgnoreCase("Signals and Systems"))
        {
            syllabus=getResources().getStringArray(R.array.Signals_and_Systems);
        }
        else if(subject_selected.equalsIgnoreCase("Network Analysis and Synthesis"))
        {
            syllabus=getResources().getStringArray(R.array.Network_Analysis_and_Synthesis);
        }
        else if(subject_selected.equalsIgnoreCase("Electrodynamics and EM Waves"))
        {
            syllabus=getResources().getStringArray(R.array.Electrodynamics_and_EM_Waves);
        }
        else if(subject_selected.equalsIgnoreCase("Digital Circuits and Systems"))
        {
            syllabus=getResources().getStringArray(R.array.Digital_Circuits_and_Systems);
        }
        else
        {
            syllabus=getResources().getStringArray(R.array.Networks_and_Protocols);
        }

        SyllabusAdapter syllabusAdapter=new SyllabusAdapter(this,titles,syllabus);
        listView.setAdapter(syllabusAdapter);

    }
    public class SyllabusAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titleArray;
        private String[] syllabusArray;

        public SyllabusAdapter(Context context, String[] titleArray, String[] syllabusArray)
        {
            mContext=context;
            this.titleArray=titleArray;
            this.syllabusArray=syllabusArray;
            layoutInflater=LayoutInflater.from(context);

        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {
                convertView = layoutInflater.inflate(R.layout.syllabus_single_item,null);
            }
            title =(TextView) convertView.findViewById(R.id.tvTitle);
            syllabus=(TextView) convertView.findViewById(R.id.tvSyllabus);

            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);
            return convertView;



        }
    }
    @Override
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