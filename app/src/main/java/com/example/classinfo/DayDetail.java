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
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
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
        Monday = getResources().getStringArray(R.array.Monday);
        Tuesday = getResources().getStringArray(R.array.Tuesday);
        Wednesday = getResources().getStringArray(R.array.Wednesday);
        Thursday = getResources().getStringArray(R.array.Thursday);
        Friday = getResources().getStringArray(R.array.Friday);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);

        String selected_day = WeekActivity.sharedPreferences.getString(WeekActivity.SEL_DAY, null);
        if(selected_day.equalsIgnoreCase("Monday")){
            PreferredDay = Monday;
            PreferredTime = Time1;
        }else if(selected_day.equalsIgnoreCase("Tuesday")){
            PreferredDay = Tuesday;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Wednesday")){
            PreferredDay = Wednesday;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Thursday")){
            PreferredDay = Thursday;
            PreferredTime = Time4;
        }else
            {
            PreferredDay = Friday;
            PreferredTime = Time5;
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