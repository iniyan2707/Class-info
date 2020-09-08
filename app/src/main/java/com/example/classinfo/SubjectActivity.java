package com.example.classinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.classinfo.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        setupUIViews();
        initToolBar();
        setupListView();
    }

    private void setupUIViews()
    {
        toolbar =(Toolbar) findViewById(R.id.ToolbarSubject);
        listView =(ListView) findViewById(R.id.lvSubject);
    }
    private void initToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView()
    {
        subjects=getResources().getStringArray(R.array.Subjects);
        SubjectAdpater subjectAdpater=new SubjectAdpater(this,R.layout.subject_single_item,subjects);
        listView.setAdapter(subjectAdpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position)
                {
                    case 0:break;
                    case 1:break;
                    case 2:break;
                    case 3:break;
                    case 4:break;
                    case 5:break;

                }
            }
        });

    }
    public class SubjectAdpater extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects=new String[]{};

        public SubjectAdpater(Context context, int resource, String[] objects) {
            super(context, resource,objects);
            this.resource=resource;
            this.subjects=objects;
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null)
            {
                holder=new ViewHolder();
                convertView=layoutInflater.inflate(resource,null);
                holder.ivLogo=(LetterImageView) convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject=(TextView) convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }
            else
            {
                holder=(ViewHolder)convertView.getTag();
            }
            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(subjects[position].charAt(0));
            holder.tvSubject.setText(subjects[position]);
            return convertView;

        }
        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvSubject;
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