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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.classinfo.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);
        setupUIViews();
        initToolBar();
        setupListView();
    }

    private void setupUIViews()
    {
        toolbar =(Toolbar) findViewById(R.id.ToolbarDayDetail);
        listView =(ListView) findViewById(R.id.lvDayDetail);
    }
    private void initToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView()
    {


        String selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null);
        if(selected_day.equalsIgnoreCase("Monday")){
            PreferredDay = getResources().getStringArray(R.array.Monday);
            PreferredTime = getResources().getStringArray(R.array.time1);
        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            PreferredDay = getResources().getStringArray(R.array.Tuesday);
            PreferredTime = getResources().getStringArray(R.array.time2);
        }else if(selected_day.equalsIgnoreCase("Wednesday")){
            PreferredDay = getResources().getStringArray(R.array.Wednesday);
            PreferredTime = getResources().getStringArray(R.array.time3);
        }else if(selected_day.equalsIgnoreCase("Thursday")){
            PreferredDay = getResources().getStringArray(R.array.Thursday);
            PreferredTime = getResources().getStringArray(R.array.time4);
        }else
            {
                PreferredDay = getResources().getStringArray(R.array.Friday);
                PreferredTime = getResources().getStringArray(R.array.time5);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(DayDetail.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);



    }
    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private LetterImageView letterImageView;
        private String[] subjectArray;
        private String[] timeArray;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray)
        {
            mContext=context;
            this.subjectArray=subjectArray;
            this.timeArray=timeArray;
           layoutInflater=LayoutInflater.from(context);

        }


        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {
                convertView = layoutInflater.inflate(R.layout.activity_day_single_item,null);
            }
            subject =(TextView) convertView.findViewById(R.id.tvDay);
            time=(TextView) convertView.findViewById(R.id.tvTime);
            letterImageView=(LetterImageView) convertView.findViewById(R.id.ivDay);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);
            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));
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