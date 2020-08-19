package com.example.classinfo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        initToolBar();
        setupListView();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupUIViews()
    {
        toolbar=(Toolbar)findViewById(R.id.Toolbarmain);
        listView=(ListView) findViewById(R.id.lvMain);
    }
    private void initToolBar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Class Info");
    }
    private void setupListView()
    {
        String[] title=getResources().getStringArray(R.array.Title);
        String[] descrption=getResources().getStringArray(R.array.Description);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,title,descrption);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    {
                        Intent intent=new Intent(MainActivity.this,WeekActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {
                        break;
                    }
                    case 2:
                    {
                        break;
                    }
                    case 3:
                    {
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private ImageView imageView;
        private String[] titleArray;
        private String[] descriptionArray;

        public SimpleAdapter(Context context, String[] title, String[] description)
        {
            mContext=context;
            titleArray=title;
            descriptionArray=description;
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
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item,null);
            }
            title =(TextView) convertView.findViewById(R.id.tvMain);
            description=(TextView) convertView.findViewById(R.id.tvDescription);
            imageView=(ImageView) convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Timetable"))
            {
                imageView.setImageResource(R.drawable.time1);
            }
            else if(titleArray[position].equalsIgnoreCase("Subjects"))
            {
                imageView.setImageResource(R.drawable.sub);

            }
            else if(titleArray[position].equalsIgnoreCase("Faculty"))
            {
                imageView.setImageResource(R.drawable.faculty);

            }
            else
            {
                imageView.setImageResource(R.drawable.settings);

            }
            return convertView;



        }
    }

}