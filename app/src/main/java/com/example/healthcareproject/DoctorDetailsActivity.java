package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private  String[][] doctor_details1 =
            {
                    {"Doctor Name : Neelam Jain","Hospital Address : Mahim", "Exp : 5yrs", "Mobile No:9898567734", "600"},
                    {"Doctor Name : Swati Pawar","Hospital Address : Tilaknagar", "Exp : 15yrs", "Mobile No:9819532144", "900"},
                    {"Doctor Name : Neeraja Singh","Hospital Address : Dadar", "Exp : 8yrs", "Mobile No:9987022136", "300"},
                    {"Doctor Name : Mayuri Bakhle","Hospital Address : Chembur", "Exp : 6yrs", "Mobile No:9775610812", "500"},
                    {"Doctor Name : Meenakshi Kamat","Hospital Address : Govandi", "Exp : 7yrs", "Mobile No:9030673452", "800"}
            };
    private  String[][] doctor_details2 =
            {
                    {"Doctor Name : Ashish Jain","Hospital Address : Mahim", "Exp : 5yrs", "Mobile No:9898567734", "600"},
                    {"Doctor Name : Sumeet Pawar","Hospital Address : Tilaknagar", "Exp : 15yrs", "Mobile No:9819532144", "900"},
                    {"Doctor Name : Rakesh Singh","Hospital Address : Dadar", "Exp : 8yrs", "Mobile No:9987022136", "300"},
                    {"Doctor Name : Shrirang Bakhle","Hospital Address : Chembur", "Exp : 6yrs", "Mobile No:9775610812", "500"},
                    {"Doctor Name : Rajesh Kamat","Hospital Address : Govandi", "Exp : 7yrs", "Mobile No:9030673452", "800"}
            };
    private  String[][] doctor_details3 =
            {
                    {"Doctor Name : Seema Jain","Hospital Address : Mahim", "Exp : 4yrs", "Mobile No:9898567734", "200"},
                    {"Doctor Name : Pankaj Parab","Hospital Address :Tilaknagar", "Exp : 5yrs", "Mobile No:9819532144", "300"},
                    {"Doctor Name : Monish Jain","Hospital Address : Dadar", "Exp : 7yrs", "Mobile No:9987022136", "300"},
                    {"Doctor Name : Vishal Deshmukh","Hospital Address : Chembur", "Exp : 6yrs", "Mobile No:9775610812", "500"},
                    {"Doctor Name : Shrikant Saraf","Hospital Address : Govandi", "Exp : 7yrs", "Mobile No:9030673452", "600"}
            };
    private  String[][] doctor_details4 =
            {
                    {"Doctor Name : Amol Gawade","Hospital Address : Mahim", "Exp : 5yrs", "Mobile No:9898567734", "600"},
                    {"Doctor Name : Prasad Pawar","Hospital Address : Tilaknagar", "Exp : 15yrs", "Mobile No:9819532144", "900"},
                    {"Doctor Name : Nilesh Kale","Hospital Address : Dadar", "Exp : 8yrs", "Mobile No:9987022136", "300"},
                    {"Doctor Name : Deepak Deshpande","Hospital Address : Chembur", "Exp : 6yrs", "Mobile No:9775610812", "500"},
                    {"Doctor Name : Ashok Singh","Hospital Address : Govandi", "Exp : 7yrs", "Mobile No:9030673452", "800"}
            };
    private  String[][] doctor_details5 =
            {
                    {"Doctor Name : Nilesh Borate","Hospital Address : Mahim", "Exp : 5yrs", "Mobile No:9898567734", "1600"},
                    {"Doctor Name : Pankaj Pawar","Hospital Address : Tilaknagar", "Exp : 15yrs", "Mobile No:9819532144", "1900"},
                    {"Doctor Name : Swapnil Lele","Hospital Address : Dadar", "Exp : 8yrs", "Mobile No:9987022136", "1300"},
                    {"Doctor Name : Deepak Kumar","Hospital Address : Chembur", "Exp : 6yrs", "Mobile No:9775610812", "1500"},
                    {"Doctor Name : Ankur Pandey","Hospital Address : Govandi", "Exp : 7yrs", "Mobile No:9030673452", "1800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList  list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("FamilyPhysicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i< doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}