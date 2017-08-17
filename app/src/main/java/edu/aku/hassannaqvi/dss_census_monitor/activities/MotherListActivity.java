package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.dss_census_monitor.R;
import edu.aku.hassannaqvi.dss_census_monitor.core.DatabaseHelper;
import edu.aku.hassannaqvi.dss_census_monitor.core.MainApp;
import edu.aku.hassannaqvi.dss_census_monitor.otherClasses.MothersLst;

public class MotherListActivity extends Activity {
//    @BindView(R.id.scrollView01)
//    ScrollView scrollView01;
    @BindView(R.id.motherList)
    ListView motherList;
//    @BindView(R.id.btn_End)
//    Button btn_End;
    @BindView(R.id.lblNoMother)
    TextView lblNoMother;

    int leftChild = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_list);
        ButterKnife.bind(this);

        DatabaseHelper db = new DatabaseHelper(this);
        try {
            Collection<MothersLst> mo = db.getMotherByUUID(MainApp.fc.getUID());

            MainApp.lstMothers = new ArrayList<>();

            for (MothersLst m : mo) {

                Log.d("Mothers", String.valueOf(m));

                if (m.getAgey().equals("")? checkChild(m.getDate_of_birth()): checkChildAge(m.getAgey(),m.getAgem(),m.getAged())) {
                    MainApp.lstMothers.add(new MothersLst(m));
                }
            }

            if (MainApp.lstMothers.size() == 0) {
//                btn_End.setEnabled(true);
                lblNoMother.setText("No Mother Found");
//                lblNoMother.setVisibility(View.VISIBLE);
            } else {
//                btn_End.setEnabled(false);
                lblNoMother.setText("Child Above Age 2:" + leftChild);
//                lblNoMother.setVisibility(View.GONE);
            }

            MainApp.fc.setsF(String.valueOf(MainApp.lstMothers.size()));

            db.updateMotherCount(MainApp.fc.getsF(), MainApp.fc.get_ID());

            listAdapter motherAdapter = new listAdapter(this, android.R.layout.simple_list_item_1, MainApp.lstMothers);

            motherList.setAdapter(motherAdapter);
        } catch (Exception ex) {
            Log.e("Fetch mother", ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public Boolean checkChild(String dob) {

        try {
            Date dt = new SimpleDateFormat("dd-MM-yy").parse(dob);

            if (MainApp.monthsBetweenDates(dt,new Date()) < MainApp.selectedCHILD) {
                return true;
            } else {
                leftChild++;
                return false;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return true;

    }

    public Boolean checkChildAge(String y,String m,String d){

        int age = Integer.parseInt(y) *12 + Integer.parseInt(m) + (Integer.parseInt(d)/29);

        if (age < MainApp.selectedCHILD){
            return true;
        }else {
            leftChild++;
            return false;
        }

    }



    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        //TODO implement

//        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

        finish();
        Intent secNext = new Intent(this, EndingActivity.class);
        secNext.putExtra("check",true);
        startActivity(secNext);

//        MainApp.endActivity(this,this);
    }


//    @OnClick(R.id.btn_End)
//    void onBtnContinueClick() {
//        //TODO implement
//        Toast.makeText(this, "Next Section", Toast.LENGTH_SHORT).show();
//        finish();
////        if (MainApp.totalChild > 0) {
////            startActivity(new Intent(this, SectionKActivity.class));
////        } else {
////            startActivity(new Intent(this, SectionLActivity.class));
////        }
//        Intent secNext = new Intent(this, EndingActivity.class);
//        secNext.putExtra("check",true);
//        startActivity(secNext);
//    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

    public class listAdapter extends ArrayAdapter {

        ArrayList<MothersLst> list = new ArrayList<>();

        public listAdapter(Context context, int textViewResourceId, ArrayList<MothersLst> objects) {
            super(context, textViewResourceId, objects);
            list = objects;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {
            View v = view;
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.lstview, null);
            final TextView mother_name = (TextView) v.findViewById(R.id.mother_name);
            TextView child_name = (TextView) v.findViewById(R.id.child_name);
            TextView date_of_birth = (TextView) v.findViewById(R.id.date_of_birth);

            mother_name.setText(list.get(position).getMother_name());
            child_name.setText(list.get(position).getChild_name());
            date_of_birth.setText(list.get(position).getAgey().equals("")?list.get(position).getDate_of_birth():
                    list.get(position).getAgey()+"y "+list.get(position).getAgem()+"m "+list.get(position).getAged()+"d");

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    finish();

                    motherList.getChildAt(position).setEnabled(false);
                    motherList.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.gray));

//                    btn_End.setEnabled(true);

//                Toast.makeText(getApplicationContext(),AppMain.currentParticipantName,Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_LONG).show();

                    Intent cb = new Intent(getApplicationContext(), SectionFActivity.class);
                    cb.putExtra("position", position);
                    startActivity(cb);
                }
            });

            return v;
        }
    }


}
