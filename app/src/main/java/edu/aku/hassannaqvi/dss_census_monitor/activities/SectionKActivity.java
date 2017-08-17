package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.dss_census_monitor.R;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.CensusContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.SectionKIMContract;
import edu.aku.hassannaqvi.dss_census_monitor.core.DatabaseHelper;
import edu.aku.hassannaqvi.dss_census_monitor.core.MainApp;

public class SectionKActivity extends Activity {

    private static final String TAG = SectionKActivity.class.getSimpleName();


    @BindView(R.id.scroll)
    ScrollView scroll;
    @BindView(R.id.dcka)
    EditText dcka;
    @BindView(R.id.dckb)
    RadioGroup dckb;
    @BindView(R.id.dckb01)
    RadioButton dckb01;
    @BindView(R.id.dckb02)
    RadioButton dckb02;
    @BindView(R.id.dckc)
    RadioGroup dckc;
    @BindView(R.id.dckc01)
    RadioButton dckc01;
    @BindView(R.id.dckc02)
    RadioButton dckc02;
    @BindView(R.id.dckdob)
    RadioGroup dckdob;
    @BindView(R.id.dckdob01)
    RadioButton dckdob01;
    @BindView(R.id.dckAge02)
    RadioButton dckAge02;
    @BindView(R.id.fldGrpdckdob)
    LinearLayout fldGrpdckdob;
    @BindView(R.id.dckd)
    DatePicker dckd;
    @BindView(R.id.fldGrpdckAge)
    LinearLayout fldGrpdckAge;
    @BindView(R.id.dckey)
    EditText dckey;
    @BindView(R.id.dckem)
    EditText dckem;
    @BindView(R.id.dcked)
    EditText dcked;
    @BindView(R.id.dckf)
    RadioGroup dckf;
    @BindView(R.id.dckf01)
    RadioButton dckf01;
    @BindView(R.id.dckf02)
    RadioButton dckf02;
    @BindView(R.id.dcki)
    RadioGroup dcki;
    @BindView(R.id.dcki01)
    RadioButton dcki01;
    @BindView(R.id.dcki02)
    RadioButton dcki02;
    @BindView(R.id.dckbcg)
    RadioGroup dckbcg;
    @BindView(R.id.dckbcg01)
    RadioButton dckbcg01;
    @BindView(R.id.dckbcg02)
    RadioButton dckbcg02;
    //@BindView(R.id.dckbcgsrc) RadioGroup dckbcgsrc;
    //@BindView(R.id.dckbcgsrc01) RadioButton dckbcgsrc01;
    //@BindView(R.id.dckbcgsrc02) RadioButton dckbcgsrc02;
    //@BindView(R.id.dckscar) RadioGroup dckscar;
    //@BindView(R.id.dckscar01)
    //RadioButton dckscar01;
    //@BindView(R.id.dckscar02) RadioButton dckscar02;
    //@BindView(R.id.dckscar03)
    //RadioButton dckscar03;
    @BindView(R.id.dckopv0)
    RadioGroup dckopv0;
    @BindView(R.id.dckopv001)
    RadioButton dckopv001;
    @BindView(R.id.dckopv002)
    RadioButton dckopv002;
    //@BindView(R.id.dckopv0src) RadioGroup dckopv0src;
    //@BindView(R.id.dckopv0src01) RadioButton dckopv0src01;
    //@BindView(R.id.dckopv0src02) RadioButton dckopv0src02;
    //@BindView(R.id.dckdate0) DatePicker dckdate0;
    @BindView(R.id.dckp1)
    RadioGroup dckp1;
    @BindView(R.id.dckp101)
    RadioButton dckp101;
    @BindView(R.id.dckp102)
    RadioButton dckp102;
    //@BindView(R.id.dckp1src) RadioGroup dckp1src;
    //@BindView(R.id.dckp1src01) RadioButton dckp1src01;
    //@BindView(R.id.dckp1src02) RadioButton dckp1src02;
    @BindView(R.id.dckpcv1)
    RadioGroup dckpcv1;
    @BindView(R.id.dckpcv101)
    RadioButton dckpcv101;
    @BindView(R.id.dckpcv102)
    RadioButton dckpcv102;
    //@BindView(R.id.dckpcv1src) RadioGroup dckpcv1src;
    //@BindView(R.id.dckpcv1src01) RadioButton dckpcv1src01;
    //@BindView(R.id.dckpcv1src02) RadioButton dckpcv1src02;
    @BindView(R.id.dckopv1)
    RadioGroup dckopv1;
    @BindView(R.id.dckopv101)
    RadioButton dckopv101;
    @BindView(R.id.dckopv102)
    RadioButton dckopv102;
    //@BindView(R.id.dckopv1src) RadioGroup dckopv1src;
    //@BindView(R.id.dckopv1src01) RadioButton dckopv1src01;
    //@BindView(R.id.dckopv1src02) RadioButton dckopv1src02;
    //@BindView(R.id.dckdate1) DatePicker dckdate1;
    @BindView(R.id.dckp2)
    RadioGroup dckp2;
    @BindView(R.id.dckp201)
    RadioButton dckp201;
    @BindView(R.id.dckp202)
    RadioButton dckp202;
    //@BindView(R.id.dckp2src) RadioGroup dckp2src;
    //@BindView(R.id.dckp2src01) RadioButton dckp2src01;
    //@BindView(R.id.dckp2src02) RadioButton dckp2src02;
    @BindView(R.id.dckpcv2)
    RadioGroup dckpcv2;
    @BindView(R.id.dckpcv201)
    RadioButton dckpcv201;
    @BindView(R.id.dckpcv202)
    RadioButton dckpcv202;
    //@BindView(R.id.dckpcv2src) RadioGroup dckpcv2src;
    //@BindView(R.id.dckpcv2src01) RadioButton dckpcv2src01;
    //@BindView(R.id.dckpcv2src02) RadioButton dckpcv2src02;
    @BindView(R.id.dckopv2)
    RadioGroup dckopv2;
    @BindView(R.id.dckopv201)
    RadioButton dckopv201;
    @BindView(R.id.dckopv202)
    RadioButton dckopv202;
    //@BindView(R.id.dckopv2src) RadioGroup dckopv2src;
    //@BindView(R.id.dckopv2src01) RadioButton dckopv2src01;
    //@BindView(R.id.dckopv2src02) RadioButton dckopv2src02;
    //@BindView(R.id.dckdate2) DatePicker dckdate2;
    @BindView(R.id.dckp3)
    RadioGroup dckp3;
    @BindView(R.id.dckp301)
    RadioButton dckp301;
    @BindView(R.id.dckp302)
    RadioButton dckp302;
    //@BindView(R.id.dckp3src) RadioGroup dckp3src;
    //@BindView(R.id.dckp3src01) RadioButton dckp3src01;
    //@BindView(R.id.dckp3src02) RadioButton dckp3src02;
    @BindView(R.id.dckpcv3)
    RadioGroup dckpcv3;
    @BindView(R.id.dckpcv301)
    RadioButton dckpcv301;
    @BindView(R.id.dckpcv302)
    RadioButton dckpcv302;
    //@BindView(R.id.dckpcv3src) RadioGroup dckpcv3src;
    //@BindView(R.id.dckpcv3src01) RadioButton dckpcv3src01;
    //@BindView(R.id.dckpcv3src02) RadioButton dckpcv3src02;
    @BindView(R.id.dckopv3)
    RadioGroup dckopv3;
    @BindView(R.id.dckopv301)
    RadioButton dckopv301;
    @BindView(R.id.dckopv302)
    RadioButton dckopv302;
    //@BindView(R.id.dckopv3src) RadioGroup dckopv3src;
    //@BindView(R.id.dckopv3src01) RadioButton dckopv3src01;
    //@BindView(R.id.dckopv3src02) RadioButton dckopv3src02;
    //@BindView(R.id.dckdate3) DatePicker dckdate3;
    @BindView(R.id.dckm1)
    RadioGroup dckm1;
    @BindView(R.id.dckm101)
    RadioButton dckm101;
    @BindView(R.id.dckm102)
    RadioButton dckm102;
    //@BindView(R.id.dckm1src) RadioGroup dckm1src;
    //@BindView(R.id.dckm1src01) RadioButton dckm1src01;
    //@BindView(R.id.dckm1src02) RadioButton dckm1src02;
    //@BindView(R.id.dckdate4) DatePicker dckdate4;
    @BindView(R.id.dckm2)
    RadioGroup dckm2;
    @BindView(R.id.dckm201)
    RadioButton dckm201;
    @BindView(R.id.dckm202)
    RadioButton dckm202;
    @BindView(R.id.count)
    TextView count;
    //@BindView(R.id.dckm2src) RadioGroup dckm2src;
    //@BindView(R.id.dckm2src01) RadioButton dckm2src01;
    //@BindView(R.id.dckm2src02) RadioButton dckm2src02;
    //@BindView(R.id.dckdate5) DatePicker dckdate5;

    private int position = 0;

    private ArrayList<CensusContract> chm;
    ArrayList<String> chmName;
    Map<String, String> ch;

    ArrayAdapter<String> adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_k);
        ButterKnife.bind(this);


        dckd.setMaxDate(new Date().getTime());

        count.setText("Child: " + MainApp.mm + " out of " + MainApp.totalChild);

        dckdob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dckdob01.isChecked()) {
                    fldGrpdckdob.setVisibility(View.VISIBLE);
                    fldGrpdckAge.setVisibility(View.GONE);
                    dcked.setText(null);
                    dckem.setText(null);
                    dckey.setText(null);
                } else {
                    fldGrpdckAge.setVisibility(View.VISIBLE);
                    fldGrpdckdob.setVisibility(View.GONE);
                }
            }
        });


        DatabaseHelper db = new DatabaseHelper(this);

/*
        Collection<CensusContract> child = db.getChildFromMember(MainApp.fc.getDSSID(),MainApp.fc.getUID());
//        Collection<CensusContract> child = db.getChildFromMember("AGHN21011A", "98c4a79aec06a40e1");
        chm = new ArrayList<>();
        chmName = new ArrayList<>();
        ch = new HashMap<>();


//        First Index Null
        chmName.add("....");
        chm.add(new CensusContract());

        for (CensusContract ch : child) {
            if (ch.getAgeY().equals("") ? checkChildLessThenFive(ch.getDob(), 1) :
                    checkChildLessThenFive(ch.getAgeY()+"-"+ch.getAgeM()+"-"+ch.getAgeD(), 2)) {
                chm.add(new CensusContract(ch));
                chmName.add(ch.getName());
            }
        }

        adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, chmName);

        dcka.setAdapter(adapt);

        dcka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;

                if (position!=0) {
                    dckb.check(chm.get(position).getGender().equals("1") ? dckb01.getId() : dckb02.getId());
                    try {

                        if (chm.get(position).getAgeY().equals("")) {
                            dckdob01.setChecked(true);

                            dckd.setMaxDate(new Date().getTime());

                            String[] dt = chm.get(position).getDob().split("-");

                            dckd.updateDate(Integer.parseInt(dt[2]), Integer.parseInt(dt[1]) - 1, Integer.parseInt(dt[0]));
                        }else {
                            dckAge02.setChecked(true);

                            dckey.setText(chm.get(position).getAgeY());
                            dckem.setText(chm.get(position).getAgeM());
                            dcked.setText(chm.get(position).getAgeD());
                        }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
*/


    }

    public boolean checkChildLessThenFive(String dob, int i) {

        if (i == 1) {

            String[] dt = dob.split("-");

            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(dt[2]), Integer.parseInt(dt[1]) - 1, Integer.parseInt(dt[0]));
            Date date1 = new Date();
            Date date2 = cal.getTime();
            long diff = date1.getTime() - date2.getTime();
            long ageInYears = (diff / (24 * 60 * 60 * 1000)) / 365;
//
//            if (ageInYears > 5) {
//                return false;
//            } else {
//                return true;
//            }
//
            return ageInYears <= 5;

        } else {

            String[] dt = dob.split("-");

            if ((Integer.parseInt(dt[0]) == 5 && Integer.parseInt(dt[1]) == 0 &&
                    Integer.parseInt(dt[2]) == 0) || Integer.parseInt(dt[0]) < 5) {
                return true;
            }else {
                return false;
            }

//            return Integer.parseInt(dob) <= 5;
        }
    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
//        finish();
//        Intent endSec = new Intent(this, EndingActivity.class);
//        endSec.putExtra("check", false);
//        startActivity(endSec);
        MainApp.endActivity(this,this);

    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                if (MainApp.mm < MainApp.totalChild) {

//                    finish();

                    MainApp.selectedCh = position;

//                    MainApp.selectedC.add(position);

                    clearFields();

//                    Intent intent = new Intent(this, SectionKActivity.class);
                    MainApp.mm++;
                    count.setText("Child: " + MainApp.mm + "out of " + MainApp.totalChild);

                    /*chm.remove(position);
                    chmName.remove(position);
                    dcka.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, chmName));*/

                    scroll.setScrollY(0);

//                    startActivity(intent);
                } else {

                    MainApp.selectedCh = -1;

                    MainApp.mm = 1;

                    finish();
//                    startActivity(new Intent(this, SectionLActivity.class));
//                    startActivity(new Intent(this, MotherListActivity.class));
                    startActivity(new Intent(this, EndingActivity.class).putExtra("check",true));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void clearFields() {
        dcka.setText(null);
        dckb.clearCheck();
        dckc.clearCheck();
        dckdob.clearCheck();
        dckey.setText(null);
        dckem.setText(null);
        dcked.setText(null);
        dckf.clearCheck();
        dcki.clearCheck();
        dckbcg.clearCheck();
        dckopv0.clearCheck();
        dckp1.clearCheck();
        dckpcv1.clearCheck();
        dckopv1.clearCheck();
        dckp2.clearCheck();
        dckpcv2.clearCheck();
        dckopv2.clearCheck();
        dckp3.clearCheck();
        dckpcv3.clearCheck();
        dckopv3.clearCheck();
        dckm1.clearCheck();
        dckm2.clearCheck();

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);


        Long updcount = db.addChild(MainApp.ims);
        MainApp.ims.set_ID(String.valueOf(updcount));

        if (updcount != -1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.ims.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.ims.get_ID()));
            db.updateChildID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

//        dcka.getChildAt(position).setEnabled(false);
//        dcka.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.gray));


        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        MainApp.ims = new SectionKIMContract();

        MainApp.ims.set_UUID(MainApp.fc.getUID());
        MainApp.ims.setFormDate(MainApp.fc.getFormDate());
        MainApp.ims.setDeviceId(MainApp.fc.getDeviceID());
        MainApp.ims.setUser(MainApp.fc.getUser());
        //MainApp.mc.setChildID(MainApp.lstMothers.get(MainApp.position).getChild_id());
        MainApp.ims.setMm(String.valueOf(MainApp.mm));
        MainApp.ims.setDssID(MainApp.fc.getDSSID());

        MainApp.ims.setDevicetagID(sharedPref.getString("tagName", null));

        JSONObject sK = new JSONObject();

//        sK.put("dcka", dcka.getSelectedItem().toString());
        sK.put("dcka", dcka.getText().toString());
        sK.put("dckb", dckb01.isChecked() ? "1" : dckb02.isChecked() ? "2" : "0");
        sK.put("dckc", dckc01.isChecked() ? "1" : dckc02.isChecked() ? "2" : "0");
        if (dckdob01.isChecked()) {
            sK.put("dckd", new SimpleDateFormat("dd-MM-yyyy").format(dckd.getCalendarView().getDate()));

            sK.put("dckey", "");
            sK.put("dckem", "");
            sK.put("dcked", "");
        }else {
            sK.put("dckd", "");

            sK.put("dckey", dckey.getText().toString());
            sK.put("dckem", dckem.getText().toString());
            sK.put("dcked", dcked.getText().toString());
        }
        sK.put("dckf", dckf01.isChecked() ? "1" : dckf02.isChecked() ? "2" : "0");
        sK.put("dcki", dcki01.isChecked() ? "1" : dcki02.isChecked() ? "2" : "0");
        sK.put("dckbcg", dckbcg01.isChecked() ? "1" : dckbcg02.isChecked() ? "2" : "0");
        //sK.put("dckbcgsrc", dckbcgsrc01.isChecked() ? "1" : dckbcgsrc02.isChecked() ? "2" : "0");
        //sK.put("dckscar", dckscar01.isChecked() ? "1" : dckscar02.isChecked() ? "2" : dckscar03.isChecked() ? "3" : "0");
        sK.put("dckopv0", dckopv001.isChecked() ? "1" : dckopv002.isChecked() ? "2" : "0");
        //sK.put("dckopv0src", dckopv0src01.isChecked() ? "1" : dckopv0src02.isChecked() ? "2" : "0");
        //sk.put("dckdate0", new SimpleDateFormat("dd-MM-yyyy").format(dckdate0.getCalendarView().getDate()));
        sK.put("dckp1", dckp101.isChecked() ? "1" : dckp102.isChecked() ? "2" : "0");
        //sK.put("dckp1src", dckp1src01.isChecked() ? "1" : dckp1src02.isChecked() ? "2" : "0");
        sK.put("dckpcv1", dckpcv101.isChecked() ? "1" : dckpcv102.isChecked() ? "2" : "0");
        //sK.put("dckpcv1src", dckpcv1src01.isChecked() ? "1" : dckpcv1src02.isChecked() ? "2" : "0");
        sK.put("dckopv1", dckopv101.isChecked() ? "1" : dckopv102.isChecked() ? "2" : "0");
        //sK.put("dckopv1src", dckopv1src01.isChecked() ? "1" : dckopv1src02.isChecked() ? "2" : "0");
        //sk.put("dckdate1", new SimpleDateFormat("dd-MM-yyyy").format(dckdate1.getCalendarView().getDate()));
        sK.put("dckp2", dckp201.isChecked() ? "1" : dckp202.isChecked() ? "2" : "0");
        //sK.put("dckp2src", dckp2src01.isChecked() ? "1" : dckp2src02.isChecked() ? "2" : "0");
        sK.put("dckpcv2", dckpcv201.isChecked() ? "1" : dckpcv202.isChecked() ? "2" : "0");
        //sK.put("dckpcv2src", dckpcv2src01.isChecked() ? "1" : dckpcv2src02.isChecked() ? "2" : "0");
        sK.put("dckopv2", dckopv201.isChecked() ? "1" : dckopv202.isChecked() ? "2" : "0");
        //sK.put("dckopv2src", dckopv2src01.isChecked() ? "1" : dckopv2src02.isChecked() ? "2" : "0");
        //sk.put("dckdate2", new SimpleDateFormat("dd-MM-yyyy").format(dckdate2.getCalendarView().getDate()));
        sK.put("dckp3", dckp301.isChecked() ? "1" : dckp302.isChecked() ? "2" : "0");
        //sK.put("dckp3src", dckp3src01.isChecked() ? "1" : dckp3src02.isChecked() ? "2" : "0");
        sK.put("dckpcv3", dckpcv301.isChecked() ? "1" : dckpcv302.isChecked() ? "2" : "0");
        //sK.put("dckpcv3src", dckpcv3src01.isChecked() ? "1" : dckpcv3src02.isChecked() ? "2" : "0");
        sK.put("dckopv3", dckopv301.isChecked() ? "1" : dckopv302.isChecked() ? "2" : "0");
        //sK.put("dckopv3src", dckopv3src01.isChecked() ? "1" : dckopv3src02.isChecked() ? "2" : "0");
        //sk.put("dckdate3", new SimpleDateFormat("dd-MM-yyyy").format(dckdate3.getCalendarView().getDate()));
        sK.put("dckm1", dckm101.isChecked() ? "1" : dckm102.isChecked() ? "2" : "0");
        //sK.put("dckm1src", dckm1src01.isChecked() ? "1" : dckm1src02.isChecked() ? "2" : "0");
        //sk.put("dckdate4", new SimpleDateFormat("dd-MM-yyyy").format(dckdate4.getCalendarView().getDate()));
        sK.put("dckm2", dckm201.isChecked() ? "1" : dckm202.isChecked() ? "2" : "0");
        //sK.put("dckm2src", dckm2src01.isChecked() ? "1" : dckm2src02.isChecked() ? "2" : "0");
        //sk.put("dckdate5", new SimpleDateFormat("dd-MM-yyyy").format(dckdate5.getCalendarView().getDate()));

   /*     sK.put("dss_id_hh", chm.get(position).getDss_id_hh());
        sK.put("dss_id_m", chm.get(position).getDss_id_m());
        sK.put("dss_id_member", chm.get(position).getDss_id_member());
        sK.put("member_type", chm.get(position).getMember_type());
        sK.put("serial", chm.get(position).getSerialNo());*/

        MainApp.ims.setsK(String.valueOf(sK));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        // ====================== Name ==============

        /*if (dcka.getSelectedItem() == "....") {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.dcka), Toast.LENGTH_SHORT).show();
            ((TextView) dcka.getSelectedView()).setText("This Data is Required");
            ((TextView) dcka.getSelectedView()).setError("This Data is Required");
            ((TextView) dcka.getSelectedView()).setTextColor(Color.RED);

            Log.i(TAG, "cra01: This Data is Required!");
            return false;
        } else {
            ((TextView) dcka.getSelectedView()).setError(null);
        }*/

        if (dcka.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcka), Toast.LENGTH_SHORT).show();
            dcka.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcka: This data is Required!");
            return false;
        } else {
            dcka.setError(null);
        }

        // ============== Sex ===================

        if (dckb.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckb), Toast.LENGTH_SHORT).show();
            dckb02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckb: This data is Required!");
            return false;
        } else {
            dckb02.setError(null);
        }
        // ============== Vaccincation Card ===================

        if (dckc.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckc), Toast.LENGTH_SHORT).show();
            dckc02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckc: This data is Required!");
            return false;
        } else {
            dckc02.setError(null);
        }
        if (dckAge02.isChecked()) {
            // ================= Age in years ===========
            if (dckey.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckey), Toast.LENGTH_SHORT).show();
                dckey.setError("This data is Required! Please enter some value or zero");    // Set Error on last radio button

                Log.i(TAG, "dckey: This data is Required!");
                return false;
            } else {
                dckey.setError(null);
            }

            // ================= Age in years ===========
            if (Integer.parseInt(dckey.getText().toString().isEmpty() ? "0" : dckey.getText().toString()) > 5) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckey), Toast.LENGTH_SHORT).show();
                dckey.setError("Range is 0 to 5 years");    // Set Error on last radio button

                Log.i(TAG, "dckey: Range is 0 to 5 year ");
                return false;
            } else {
                dckey.setError(null);
            }

            // ================= Age in months ===========
            if (dckem.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckem), Toast.LENGTH_SHORT).show();
                dckem.setError("This data is Required! Please enter some value or zero");    // Set Error on last radio button

                Log.i(TAG, "dckem: This data is Required!");
                return false;
            } else {
                dckem.setError(null);
            }

            if (Integer.parseInt(dckem.getText().toString().isEmpty() ? "0" : dckem.getText().toString()) > 11) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckem), Toast.LENGTH_SHORT).show();
                dckem.setError("Range is 0 to 11 months");    // Set Error on last radio button

                Log.i(TAG, "dckem: Range is 0 to 11 months ");
                return false;
            } else {
                dckem.setError(null);
            }


            // ================= Age in days ===========
            if (dcked.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcked), Toast.LENGTH_SHORT).show();
                dcked.setError("This data is Required! Please enter some value or zero");    // Set Error on last radio button

                Log.i(TAG, "dcked: This data is Required!");
                return false;
            } else {
                dcked.setError(null);
            }

//            if (Integer.parseInt(dcked.getText().toString().isEmpty() ? "0" : dcked.getText().toString()) > 11) {
            if (Integer.parseInt(dcked.getText().toString()) < 0 || Integer.parseInt(dcked.getText().toString()) > 29) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcked), Toast.LENGTH_SHORT).show();
                dcked.setError("Range is 0 to 29 days");    // Set Error on last radio button

                Log.i(TAG, "dcked: Range is 0 to 29 days ");
                return false;
            } else {
                dcked.setError(null);
            }
        }

        // ============== Vitamin drops ===================

        if (dckf.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckf), Toast.LENGTH_SHORT).show();
            dckf02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckf: This data is Required!");
            return false;
        } else {
            dckf02.setError(null);
        }

        // ============== National Immunization ===================

        if (dcki.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckg), Toast.LENGTH_SHORT).show();
            dcki02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcki: This data is Required!");
            return false;
        } else {
            dcki02.setError(null);
        }

        // ============== BCG ===================

        if (dckbcg.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckbcg), Toast.LENGTH_SHORT).show();
            dckbcg02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckbcg: This data is Required!");
            return false;
        } else {
            dckbcg02.setError(null);
        }

        // ============== BCG  Source ===================

        /*if (dckbcgsrc.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckbcgsrc02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckbcgsrc: This data is Required!");
            return false;
        } else {
            dckbcgsrc02.setError(null);
        }*/

        // ============== BCG  Scar ===================

        /*if (dckscar.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckscar), Toast.LENGTH_SHORT).show();
            dckscar02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckscar: This data is Required!");
            return false;
        } else {
            dckscar02.setError(null);
        }
*/
        // ============== OPV 0 ===================

        if (dckopv0.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckop0), Toast.LENGTH_SHORT).show();
            dckopv002.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv0: This data is Required!");
            return false;
        } else {
            dckopv002.setError(null);
        }

        // ============== OPV0  Source ===================

        /*if (dckopv0src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckopv0src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv0src: This data is Required!");
            return false;
        } else {
            dckopv0src02.setError(null);
        }
*/

        // ============== Penta 1 ===================

        if (dckp1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckp1), Toast.LENGTH_SHORT).show();
            dckp102.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp1: This data is Required!");
            return false;
        } else {
            dckp102.setError(null);
        }

        // ============== Penta 1  Source ===================

       /* if (dckp1src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckp1src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp1src: This data is Required!");
            return false;
        } else {
            dckp1src02.setError(null);
        }*/

        // ============== PCV 1 ===================

        if (dckpcv1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckpcv1), Toast.LENGTH_SHORT).show();
            dckpcv102.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv1: This data is Required!");
            return false;
        } else {
            dckpcv102.setError(null);
        }

        // ============== PCV 1  Source ===================

        /*if (dckpcv1src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckpcv1src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv1src: This data is Required!");
            return false;
        } else {
            dckpcv1src02.setError(null);
        }
*/
        // ============== OPV 1 ===================

        if (dckopv1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckopv1), Toast.LENGTH_SHORT).show();
            dckopv102.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv1: This data is Required!");
            return false;
        } else {
            dckopv102.setError(null);
        }

        // ============== OPV 1  Source ===================

        /*if (dckopv1src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckopv1src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv1src: This data is Required!");
            return false;
        } else {
            dckopv1src02.setError(null);
        }
*/

        // ============== Penta 2 ===================

        if (dckp2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckp2), Toast.LENGTH_SHORT).show();
            dckp202.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp2: This data is Required!");
            return false;
        } else {
            dckp202.setError(null);
        }

        // ============== Penta 1  Source ===================

        /*if (dckp2src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckp2src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp2src: This data is Required!");
            return false;
        } else {
            dckp2src02.setError(null);
        }
*/
        // ============== PCV 2 ===================

        if (dckpcv2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckpcv2), Toast.LENGTH_SHORT).show();
            dckpcv202.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv2: This data is Required!");
            return false;
        } else {
            dckpcv202.setError(null);
        }

        // ============== PCV 2  Source ===================

        /*if (dckpcv2src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckpcv2src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv1src: This data is Required!");
            return false;
        } else {
            dckpcv2src02.setError(null);
        }*/

        // ============== OPV 2 ===================

        if (dckopv2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckopv2), Toast.LENGTH_SHORT).show();
            dckopv202.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv2: This data is Required!");
            return false;
        } else {
            dckopv202.setError(null);
        }

        // ============== OPV 2  Source ===================

        /*if (dckopv2src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckopv2src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv2src: This data is Required!");
            return false;
        } else {
            dckopv2src02.setError(null);
        }*/

        // ============== Penta 3 ===================

        if (dckp3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckp3), Toast.LENGTH_SHORT).show();
            dckp302.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp3: This data is Required!");
            return false;
        } else {
            dckp302.setError(null);
        }

        // ============== Penta 3  Source ===================

        /*if (dckp3src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckp3src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckp3src: This data is Required!");
            return false;
        } else {
            dckp3src02.setError(null);
        }*/

        // ============== PCV 3 ===================

        if (dckpcv3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckpcv3), Toast.LENGTH_SHORT).show();
            dckpcv302.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv3: This data is Required!");
            return false;
        } else {
            dckpcv302.setError(null);
        }

        // ============== PCV 3  Source ===================

        /*if (dckpcv3src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckpcv3src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckpcv3src: This data is Required!");
            return false;
        } else {
            dckpcv3src02.setError(null);
        }
*/
        // ============== OPV 3 ===================

        if (dckopv3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckopv3), Toast.LENGTH_SHORT).show();
            dckopv302.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv3: This data is Required!");
            return false;
        } else {
            dckopv302.setError(null);
        }

        // ============== OPV 3  Source ===================

        /*if (dckopv1src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckopv3src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckopv3src: This data is Required!");
            return false;
        } else {
            dckopv3src02.setError(null);
        }*/

        // ============== Measles 1 ===================

        if (dckm1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckm1), Toast.LENGTH_SHORT).show();
            dckm102.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckm1: This data is Required!");
            return false;
        } else {
            dckm102.setError(null);
        }

        // ============== Measles 1  Source ===================

        /*if (dckm1src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckm1src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckm1src: This data is Required!");
            return false;
        } else {
            dckm1src02.setError(null);
        }
*/

        // ============== Measles 2 ===================

        if (dckm2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dckm2), Toast.LENGTH_SHORT).show();
            dckm202.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckm2: This data is Required!");
            return false;
        } else {
            dckm202.setError(null);
        }

        // ============== Measles 2  Source ===================

        /*if (dckm2src.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcksrc), Toast.LENGTH_SHORT).show();
            dckm2src02.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dckm2src: This data is Required!");
            return false;
        } else {
            dckm2src02.setError(null);
        }
*/


        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
