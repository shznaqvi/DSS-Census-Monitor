package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.dss_census_monitor.R;
import edu.aku.hassannaqvi.dss_census_monitor.core.DatabaseHelper;
import edu.aku.hassannaqvi.dss_census_monitor.core.MainApp;

public class SectionIActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = SectionIActivity.class.getSimpleName();


    @BindView(R.id.dci01)
    EditText dci01;
    @BindView(R.id.dci02)
    RadioGroup dci02;
    @BindView(R.id.dci0201)
    RadioButton dci0201;
    @BindView(R.id.dci0202)
    RadioButton dci0202;
    //    @BindView(R.id.dci03)
//    EditText dci03;
//    @BindView(R.id.dci04)
//    EditText dci04;
    @BindView(R.id.dci05)
    DatePicker dci05;
    @BindView(R.id.dci06)
    RadioGroup dci06;
    @BindView(R.id.dci0601)
    RadioButton dci0601;
    @BindView(R.id.dci0602)
    RadioButton dci0602;
    @BindView(R.id.dci0699)
    RadioButton dci0699;
    @BindView(R.id.dci07d)
    EditText dci07d;
    @BindView(R.id.dci07m)
    EditText dci07m;
    @BindView(R.id.dci07y)
    EditText dci07y;
    @BindView(R.id.dci08)
    RadioGroup dci08;
    @BindView(R.id.dci0801)
    RadioButton dci0801;
    @BindView(R.id.dci0802)
    RadioButton dci0802;
    @BindView(R.id.dci0803)
    RadioButton dci0803;
    @BindView(R.id.dci09)
    EditText dci09;
    @BindView(R.id.dci10a)
    RadioGroup dci10a;
    @BindView(R.id.dci10a01)
    RadioButton dci10a01;
    @BindView(R.id.dci10a02)
    RadioButton dci10a02;
    @BindView(R.id.dci10b)
    RadioGroup dci10b;
    @BindView(R.id.dci10b01)
    RadioButton dci10b01;
    @BindView(R.id.dci10b02)
    RadioButton dci10b02;
    @BindView(R.id.dci11)
    RadioGroup dci11;
    @BindView(R.id.dci1101)
    RadioButton dci1101;
    @BindView(R.id.dci1102)
    RadioButton dci1102;
    @BindView(R.id.dci1199)
    RadioButton dci1199;
    @BindView(R.id.dci12)
    RadioGroup dci12;
    @BindView(R.id.dci1201)
    RadioButton dci1201;
    @BindView(R.id.dci1202)
    RadioButton dci1202;
    @BindView(R.id.dci1299)
    RadioButton dci1299;
    @BindView(R.id.dci13)
    RadioGroup dci13;
    @BindView(R.id.dci1301)
    RadioButton dci1301;
    @BindView(R.id.dci1302)
    RadioButton dci1302;
    @BindView(R.id.dci1399)
    RadioButton dci1399;
    @BindView(R.id.dci14)
    RadioGroup dci14;
    @BindView(R.id.dci1401)
    RadioButton dci1401;
    @BindView(R.id.dci1402)
    RadioButton dci1402;
    @BindView(R.id.dci1499)
    RadioButton dci1499;
    @BindView(R.id.dci15)
    RadioGroup dci15;
    @BindView(R.id.dci1501)
    RadioButton dci1501;
    @BindView(R.id.dci1502)
    RadioButton dci1502;
    @BindView(R.id.dci1599)
    RadioButton dci1599;
    @BindView(R.id.dci16)
    RadioGroup dci16;
    @BindView(R.id.dci1601)
    RadioButton dci1601;
    @BindView(R.id.dci1602)
    RadioButton dci1602;
    @BindView(R.id.dci1699)
    RadioButton dci1699;
    @BindView(R.id.dci17a)
    RadioGroup dci17a;
    @BindView(R.id.dci17a01)
    RadioButton dci17a01;
    @BindView(R.id.dci17a02)
    RadioButton dci17a02;
    @BindView(R.id.dci17a99)
    RadioButton dci17a99;
    @BindView(R.id.dci17b)
    RadioGroup dci17b;
    @BindView(R.id.dci17b01)
    RadioButton dci17b01;
    @BindView(R.id.dci17b02)
    RadioButton dci17b02;
    @BindView(R.id.dci17b99)
    RadioButton dci17b99;
    @BindView(R.id.dci17btimes)
    EditText dci17btimes;
    @BindView(R.id.dci17c)
    RadioGroup dci17c;
    @BindView(R.id.dci17c01)
    RadioButton dci17c01;
    @BindView(R.id.dci17c02)
    RadioButton dci17c02;
    @BindView(R.id.dci17c99)
    RadioButton dci17c99;
    @BindView(R.id.dci17ctimes)
    EditText dci17ctimes;
    @BindView(R.id.dci17d)
    RadioGroup dci17d;
    @BindView(R.id.dci17d01)
    RadioButton dci17d01;
    @BindView(R.id.dci17d02)
    RadioButton dci17d02;
    @BindView(R.id.dci17d99)
    RadioButton dci17d99;
    @BindView(R.id.dci17e)
    RadioGroup dci17e;
    @BindView(R.id.dci17e01)
    RadioButton dci17e01;
    @BindView(R.id.dci17e02)
    RadioButton dci17e02;
    @BindView(R.id.dci17e99)
    RadioButton dci17e99;
    @BindView(R.id.dci17f)
    RadioGroup dci17f;
    @BindView(R.id.dci17f01)
    RadioButton dci17f01;
    @BindView(R.id.dci17f02)
    RadioButton dci17f02;
    @BindView(R.id.dci17f99)
    RadioButton dci17f99;
    @BindView(R.id.dci17ftimes)
    EditText dci17ftimes;
    @BindView(R.id.dci17g)
    RadioGroup dci17g;
    @BindView(R.id.dci17g01)
    RadioButton dci17g01;
    @BindView(R.id.dci17g02)
    RadioButton dci17g02;
    @BindView(R.id.dci17g99)
    RadioButton dci17g99;
    @BindView(R.id.dci17h)
    RadioGroup dci17h;
    @BindView(R.id.dci17h01)
    RadioButton dci17h01;
    @BindView(R.id.dci17h02)
    RadioButton dci17h02;
    @BindView(R.id.dci17h99)
    RadioButton dci17h99;
    @BindView(R.id.dci18a)
    RadioGroup dci18a;
    @BindView(R.id.dci18a01)
    RadioButton dci18a01;
    @BindView(R.id.dci18a02)
    RadioButton dci18a02;
    @BindView(R.id.dci18a99)
    RadioButton dci18a99;
    @BindView(R.id.dci18b)
    RadioGroup dci18b;
    @BindView(R.id.dci18b01)
    RadioButton dci18b01;
    @BindView(R.id.dci18b02)
    RadioButton dci18b02;
    @BindView(R.id.dci18b99)
    RadioButton dci18b99;
    @BindView(R.id.dci18c)
    RadioGroup dci18c;
    @BindView(R.id.dci18c01)
    RadioButton dci18c01;
    @BindView(R.id.dci18c02)
    RadioButton dci18c02;
    @BindView(R.id.dci18c99)
    RadioButton dci18c99;
    @BindView(R.id.dci18d)
    RadioGroup dci18d;
    @BindView(R.id.dci18d01)
    RadioButton dci18d01;
    @BindView(R.id.dci18d02)
    RadioButton dci18d02;
    @BindView(R.id.dci18d99)
    RadioButton dci18d99;
    @BindView(R.id.dci18e)
    RadioGroup dci18e;
    @BindView(R.id.dci18e01)
    RadioButton dci18e01;
    @BindView(R.id.dci18e02)
    RadioButton dci18e02;
    @BindView(R.id.dci18e99)
    RadioButton dci18e99;
    @BindView(R.id.dci18f)
    RadioGroup dci18f;
    @BindView(R.id.dci18f01)
    RadioButton dci18f01;
    @BindView(R.id.dci18f02)
    RadioButton dci18f02;
    @BindView(R.id.dci18f99)
    RadioButton dci18f99;
    @BindView(R.id.dci18g)
    RadioGroup dci18g;
    @BindView(R.id.dci18g01)
    RadioButton dci18g01;
    @BindView(R.id.dci18g02)
    RadioButton dci18g02;
    @BindView(R.id.dci18g99)
    RadioButton dci18g99;
    @BindView(R.id.dci18h)
    RadioGroup dci18h;
    @BindView(R.id.dci18h01)
    RadioButton dci18h01;
    @BindView(R.id.dci18h02)
    RadioButton dci18h02;
    @BindView(R.id.dci18h99)
    RadioButton dci18h99;
    @BindView(R.id.dci18i)
    RadioGroup dci18i;
    @BindView(R.id.dci18i01)
    RadioButton dci18i01;
    @BindView(R.id.dci18i02)
    RadioButton dci18i02;
    @BindView(R.id.dci18i99)
    RadioButton dci18i99;
    @BindView(R.id.dci18j)
    RadioGroup dci18j;
    @BindView(R.id.dci18j01)
    RadioButton dci18j01;
    @BindView(R.id.dci18j02)
    RadioButton dci18j02;
    @BindView(R.id.dci18j99)
    RadioButton dci18j99;
    @BindView(R.id.dci18k)
    RadioGroup dci18k;
    @BindView(R.id.dci18k01)
    RadioButton dci18k01;
    @BindView(R.id.dci18k02)
    RadioButton dci18k02;
    @BindView(R.id.dci18k99)
    RadioButton dci18k99;
    @BindView(R.id.dci18l)
    RadioGroup dci18l;
    @BindView(R.id.dci18l01)
    RadioButton dci18l01;
    @BindView(R.id.dci18l02)
    RadioButton dci18l02;
    @BindView(R.id.dci18l99)
    RadioButton dci18l99;
    @BindView(R.id.dci18m)
    RadioGroup dci18m;
    @BindView(R.id.dci18m01)
    RadioButton dci18m01;
    @BindView(R.id.dci18m02)
    RadioButton dci18m02;
    @BindView(R.id.dci18m99)
    RadioButton dci18m99;
    @BindView(R.id.dci18n)
    RadioGroup dci18n;
    @BindView(R.id.dci18n01)
    RadioButton dci18n01;
    @BindView(R.id.dci18n02)
    RadioButton dci18n02;
    @BindView(R.id.dci18n99)
    RadioButton dci18n99;
    @BindView(R.id.dci18o)
    RadioGroup dci18o;
    @BindView(R.id.dci18o01)
    RadioButton dci18o01;
    @BindView(R.id.dci18o02)
    RadioButton dci18o02;
    @BindView(R.id.dci18o99)
    RadioButton dci18o99;
    @BindView(R.id.dci18p)
    RadioGroup dci18p;
    @BindView(R.id.dci18p01)
    RadioButton dci18p01;
    @BindView(R.id.dci18p02)
    RadioButton dci18p02;
    @BindView(R.id.dci18p99)
    RadioButton dci18p99;
    @BindView(R.id.dci18q)
    RadioGroup dci18q;
    @BindView(R.id.dci18q01)
    RadioButton dci18q01;
    @BindView(R.id.dci18q02)
    RadioButton dci18q02;
    @BindView(R.id.dci18q99)
    RadioButton dci18q99;
    @BindView(R.id.dci19)
    RadioGroup dci19;
    @BindView(R.id.dci1901)
    RadioButton dci1901;
    @BindView(R.id.dci1902)
    RadioButton dci1902;
    @BindView(R.id.dci1999)
    RadioButton dci1999;
    @BindView(R.id.dci2001)
    EditText dci2001;
    @BindView(R.id.dci2099)
    CheckBox dci2099;
    @BindView(R.id.dci21)
    RadioGroup dci21;
    @BindView(R.id.dci2101)
    RadioButton dci2101;
    @BindView(R.id.dci2102)
    RadioButton dci2102;
    @BindView(R.id.dci2199)
    RadioButton dci2199;
    String dob = null;
    @BindView(R.id.dci17i)
    RadioGroup dci17i;
    @BindView(R.id.dci17i01)
    RadioButton dci17i01;
    @BindView(R.id.dci17i02)
    RadioButton dci17i02;
    @BindView(R.id.dci17i99)
    RadioButton dci17i99;
    @BindView(R.id.dci17ix)
    EditText dci17ix;
    @BindView(R.id.fldGrpdci13)
    LinearLayout fldGrpdci13;
    @BindView(R.id.fldGrpdci14)
    LinearLayout fldGrpdci14;
    @BindView(R.id.fldGrpdci19)
    LinearLayout fldGrpdci19;
    @BindView(R.id.fldGrpdci20)
    LinearLayout fldGrpdci20;
    @BindView(R.id.fldGrpdci17b)
    LinearLayout fldGrpdci17b;
    @BindView(R.id.fldGrpdci17c)
    LinearLayout fldGrpdci17c;
    @BindView(R.id.fldGrpdci17f)
    LinearLayout fldGrpdci17f;


    @BindViews({R.id.dci18a, R.id.dci18b, R.id.dci18c, R.id.dci18d, R.id.dci18e, R.id.dci18f, R.id.dci18g,
            R.id.dci18h, R.id.dci18i, R.id.dci18j, R.id.dci18k, R.id.dci18l, R.id.dci18m, R.id.dci18n, R.id.dci18o,
            R.id.dci18p, R.id.dci18q})
    List<RadioGroup> dci18;

    @BindViews({R.id.dci18a02, R.id.dci18b02, R.id.dci18c02, R.id.dci18d02, R.id.dci18e02, R.id.dci18f02, R.id.dci18g02,
            R.id.dci18h02, R.id.dci18i02, R.id.dci18j02, R.id.dci18k02, R.id.dci18l02, R.id.dci18m02, R.id.dci18n02, R.id.dci18o02,
            R.id.dci18p02, R.id.dci18q02})
    List<RadioButton> dci1802;

    @BindViews({R.id.dci18a99, R.id.dci18b99, R.id.dci18c99, R.id.dci18d99, R.id.dci18e99, R.id.dci18f99, R.id.dci18g99,
            R.id.dci18h99, R.id.dci18i99, R.id.dci18j99, R.id.dci18k99, R.id.dci18l99, R.id.dci18m99, R.id.dci18n99, R.id.dci18o99,
            R.id.dci18p99, R.id.dci18q99})
    List<RadioButton> dci1899;

    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    int month = now.get(Calendar.MONTH);
    int day = now.get(Calendar.DATE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_i);
        ButterKnife.bind(this);


        if (MainApp.lstMothers.get(MainApp.position).getAgey().equals("")) {
            try {
                if (MainApp.monthsBetweenDates(new SimpleDateFormat("dd-MM-yy").parse(MainApp.lstMothers.get(MainApp.position).getDate_of_birth()),
                        new Date()) < MainApp.selectedCHILD) {

                    String[] dt = MainApp.lstMothers.get(MainApp.position).getDate_of_birth().split("-");

                    dci05.updateDate(Integer.parseInt(dt[2]), Integer.parseInt(dt[1]) - 1, Integer.parseInt(dt[0]));

                } else {
                    startActivity(new Intent(this, SectionJActivity.class));
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (Integer.parseInt(MainApp.lstMothers.get(MainApp.position).getAgey())*12 +
                    Integer.parseInt(MainApp.lstMothers.get(MainApp.position).getAgem()) < MainApp.selectedCHILD){
                dci07y.setText(MainApp.lstMothers.get(MainApp.position).getAgey());
                dci07m.setText(MainApp.lstMothers.get(MainApp.position).getAgem());
                dci07d.setText(MainApp.lstMothers.get(MainApp.position).getAged());
            }else {
                startActivity(new Intent(this, SectionJActivity.class));
            }
        }


        dci05.setMaxDate(new Date().getTime());
        dci05.setMinDate((new Date().getTime() - ((MainApp.MILLISECONDS_IN_YEAR) + (MainApp.MILLISECONDS_IN_YEAR) - (MainApp.MILLISECONDS_IN_MONTH) + MainApp.MILLISECONDS_IN_DAY)));
//        dob = new SimpleDateFormat("dd-MM-yyyy").format(dci05.getCalendarView().getDate());

        // ============= Q 18 B =============
        dci17b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci17b01.isChecked()) {
                    fldGrpdci17b.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdci17b.setVisibility(View.GONE);
                    dci17btimes.setText(null);
                }
            }
        });


        // ============= Q 18 C =============
        dci17c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci17c01.isChecked()) {
                    fldGrpdci17c.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdci17c.setVisibility(View.GONE);
                    dci17ctimes.setText(null);
                }

            }
        });

        // ============= Q 18 F =============
        dci17f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci17f01.isChecked()) {
                    fldGrpdci17f.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdci17f.setVisibility(View.GONE);
                    dci17ftimes.setText(null);
                }

            }
        });

        //=================== Q12 Skip Pattern ==============
        dci12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci1201.isChecked()) {
                    fldGrpdci13.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdci13.setVisibility(View.GONE);
                    dci13.clearCheck();
                }
            }
        });

        //================== Q 13 Skip Pattern ===============
        dci13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci1301.isChecked()) {
                    fldGrpdci14.setVisibility(View.GONE);
                    dci14.clearCheck();
                } else {
                    fldGrpdci14.setVisibility(View.VISIBLE);
                }
            }
        });


        // =================== Q 19 Skip Pattern ================
        for (RadioGroup rg : dci18) {
            rg.setOnCheckedChangeListener(this);
        }

        //================= Q 20 Skip Pattern =============

        dci19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dci1901.isChecked()) {
                    fldGrpdci20.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdci20.setVisibility(View.GONE);
                    dci2001.setText(null);
                    dci2099.setChecked(false);
                }
            }
        });

        dci2099.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    dci2001.setEnabled(false);
                    dci2001.setText(null);
                } else {
                    dci2001.setEnabled(true);
                }
            }
        });


//        Fill Info

        dci01.setText(MainApp.lstMothers.get(MainApp.position).getChild_name());
        dci01.setEnabled(false);

        dci02.check(MainApp.lstMothers.get(MainApp.position).getGender().equals("1") ? dci0201.getId() : dci0202.getId());


    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
//        finish();
        MainApp.finishActivity(this, this);
    }


    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent secNext = new Intent(this, SectionJActivity.class);
                startActivity(secNext);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSI();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sI = new JSONObject();

        sI.put("dci01", dci01.getText().toString());
        sI.put("dci02", dci0201.isChecked() ? "1" : dci0202.isChecked() ? "2" : "0");
        sI.put("dci03", MainApp.lstMothers.get(MainApp.position).getSerial());
        sI.put("dci04", MainApp.lstMothers.get(MainApp.position).getSerialm());
        sI.put("dci05", new SimpleDateFormat("dd-MM-yyyy").format(dci05.getCalendarView().getDate()));
        sI.put("dci06", dci0601.isChecked() ? "1" : dci0602.isChecked() ? "2" : dci0699.isChecked() ? "99" : "0");
        /*sI.put("dci07d", dci07d.getText().toString());
        sI.put("dci07m", dci07m.getText().toString());
        sI.put("dci07y", dci07y.getText().toString());
        sI.put("dci08", dci0801.isChecked() ? "1" : dci0802.isChecked() ? "2" : dci0803.isChecked() ? "3" : "0");
        sI.put("dci09", dci09.getText().toString());
        sI.put("dci10a", dci10a01.isChecked() ? "1" : dci10a02.isChecked() ? "2" : "0");
        sI.put("dci10b", dci10b01.isChecked() ? "1" : dci10b02.isChecked() ? "2" : "0");
        sI.put("dci11", dci1101.isChecked() ? "1" : dci1102.isChecked() ? "2" : dci1199.isChecked() ? "99" : "0");*/
        sI.put("dci12", dci1201.isChecked() ? "1" : dci1202.isChecked() ? "2" : dci1299.isChecked() ? "99" : "0");
        sI.put("dci13", dci1301.isChecked() ? "1" : dci1302.isChecked() ? "2" : dci1399.isChecked() ? "99" : "0");
        sI.put("dci14", dci1401.isChecked() ? "1" : dci1402.isChecked() ? "2" : dci1499.isChecked() ? "99" : "0");
        sI.put("dci15", dci1501.isChecked() ? "1" : dci1502.isChecked() ? "2" : dci1599.isChecked() ? "99" : "0");
        sI.put("dci16", dci1601.isChecked() ? "1" : dci1602.isChecked() ? "2" : dci1699.isChecked() ? "99" : "0");
        sI.put("dci17a", dci17a01.isChecked() ? "1" : dci17a02.isChecked() ? "2" : dci17a99.isChecked() ? "99" : "0");
        sI.put("dci17b", dci17b01.isChecked() ? "1" : dci17b02.isChecked() ? "2" : dci17b99.isChecked() ? "99" : "0");
        sI.put("dci17btimes", dci17btimes.getText().toString());
        sI.put("dci17c", dci17c01.isChecked() ? "1" : dci17c02.isChecked() ? "2" : dci17c99.isChecked() ? "99" : "0");
        sI.put("dci17ctimes", dci17ctimes.getText().toString());
        sI.put("dci17d", dci17d01.isChecked() ? "1" : dci17d02.isChecked() ? "2" : dci17d99.isChecked() ? "99" : "0");
        sI.put("dci17e", dci17e01.isChecked() ? "1" : dci17e02.isChecked() ? "2" : dci17e99.isChecked() ? "99" : "0");
        sI.put("dci17f", dci17f01.isChecked() ? "1" : dci17f02.isChecked() ? "2" : dci17f99.isChecked() ? "99" : "0");
        sI.put("dci17ftimes", dci17ftimes.getText().toString());
        sI.put("dci17g", dci17g01.isChecked() ? "1" : dci17g02.isChecked() ? "2" : dci17g99.isChecked() ? "99" : "0");
        sI.put("dci17h", dci17h01.isChecked() ? "1" : dci17h02.isChecked() ? "2" : dci17h99.isChecked() ? "99" : "0");
        sI.put("dci17i", dci17i01.isChecked() ? "1" : dci17i02.isChecked() ? "2" : dci17i99.isChecked() ? "99" : "0");
        sI.put("dci17ix", dci17ix.getText().toString());
        sI.put("dci18a", dci18a01.isChecked() ? "1" : dci18a02.isChecked() ? "2" : dci18a99.isChecked() ? "99" : "0");
        sI.put("dci18b", dci18b01.isChecked() ? "1" : dci18b02.isChecked() ? "2" : dci18b99.isChecked() ? "99" : "0");
        sI.put("dci18c", dci18c01.isChecked() ? "1" : dci18c02.isChecked() ? "2" : dci18c99.isChecked() ? "99" : "0");
        sI.put("dci18d", dci18d01.isChecked() ? "1" : dci18d02.isChecked() ? "2" : dci18d99.isChecked() ? "99" : "0");
        sI.put("dci18e", dci18e01.isChecked() ? "1" : dci18e02.isChecked() ? "2" : dci18e99.isChecked() ? "99" : "0");
        sI.put("dci18f", dci18f01.isChecked() ? "1" : dci18f02.isChecked() ? "2" : dci18f99.isChecked() ? "99" : "0");
        sI.put("dci18g", dci18g01.isChecked() ? "1" : dci18g02.isChecked() ? "2" : dci18g99.isChecked() ? "99" : "0");
        sI.put("dci18h", dci18h01.isChecked() ? "1" : dci18h02.isChecked() ? "2" : dci18h99.isChecked() ? "99" : "0");
        sI.put("dci18i", dci18i01.isChecked() ? "1" : dci18i02.isChecked() ? "2" : dci18i99.isChecked() ? "99" : "0");
        sI.put("dci18j", dci18j01.isChecked() ? "1" : dci18j02.isChecked() ? "2" : dci18j99.isChecked() ? "99" : "0");
        sI.put("dci18k", dci18k01.isChecked() ? "1" : dci18k02.isChecked() ? "2" : dci18k99.isChecked() ? "99" : "0");
        sI.put("dci18l", dci18l01.isChecked() ? "1" : dci18l02.isChecked() ? "2" : dci18l99.isChecked() ? "99" : "0");
        sI.put("dci18m", dci18m01.isChecked() ? "1" : dci18m02.isChecked() ? "2" : dci18m99.isChecked() ? "99" : "0");
        sI.put("dci18n", dci18n01.isChecked() ? "1" : dci18n02.isChecked() ? "2" : dci18n99.isChecked() ? "99" : "0");
        sI.put("dci18o", dci18o01.isChecked() ? "1" : dci18o02.isChecked() ? "2" : dci18o99.isChecked() ? "99" : "0");
        sI.put("dci18p", dci18p01.isChecked() ? "1" : dci18p02.isChecked() ? "2" : dci18p99.isChecked() ? "99" : "0");
        sI.put("dci18q", dci18q01.isChecked() ? "1" : dci18q02.isChecked() ? "2" : dci18q99.isChecked() ? "99" : "0");
        sI.put("dci19", dci1901.isChecked() ? "1" : dci1902.isChecked() ? "2" : dci1999.isChecked() ? "99" : "0");
        sI.put("dci2001", dci2001.getText().toString());
        sI.put("dci20", dci2099.isChecked() ? "99" : "0");
        sI.put("dci21", dci2101.isChecked() ? "1" : dci2102.isChecked() ? "2" : dci2199.isChecked() ? "99" : "0");

        MainApp.mc.setsI(String.valueOf(sI));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();


    }

    public boolean ValidateForm() {

        // ====================== Q 1 ==============
        if (dci01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci01), Toast.LENGTH_SHORT).show();
            dci01.setError("This data is Required!");
            Log.i(TAG, "dci01: This data is Required!");
            return false;
        } else {
            dci01.setError(null);
        }

        // ====================== Q 2 ==============
        if (dci02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci02), Toast.LENGTH_SHORT).show();
            dci0202.setError("This data is Required!");
            Log.i(TAG, "dci02: This data is Required!");
            return false;
        } else {
            dci0202.setError(null);
        }

        // ====================== Q 3 ==============
//        if (dci03.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci03), Toast.LENGTH_SHORT).show();
//            dci03.setError("This data is Required!");
//            Log.i(TAG, "dci03: This data is Required!");
//            return false;
//        } else {
//            dci03.setError(null);
//        }
//
//        // ====================== Q 4 ==============
//        if (dci04.getText().toString().isEmpty()) {
//            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci04), Toast.LENGTH_SHORT).show();
//            dci04.setError("This data is Required!");
//            Log.i(TAG, "dci05: This data is Required!");
//            return false;
//        } else {
//            dci04.setError(null);
//        }

        // ====================== Q 6 ==============
        if (dci06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci06), Toast.LENGTH_SHORT).show();
            dci0699.setError("This data is Required!");
            Log.i(TAG, "dci06: This data is Required!");
            return false;
        } else {
            dci0699.setError(null);
        }

        /*// ====================== Q 7 ==============
        if (dci07d.getText().toString().isEmpty() && dci07m.getText().toString().isEmpty() && dci07y.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07), Toast.LENGTH_SHORT).show();
            dci07y.setError("This data is Required!");
            Log.i(TAG, "dci07y: This data is Required!");
            return false;
        } else {
            dci07y.setError(null);
        }

        // ====================== Q 7 ==============
        if ((Integer.parseInt(dci07d.getText().toString().isEmpty() ? "0" : dci07d.getText().toString()) == 0
                && Integer.parseInt(dci07m.getText().toString().isEmpty() ? "0" : dci07m.getText().toString()) == 0
                && Integer.parseInt(dci07y.getText().toString().isEmpty() ? "0" : dci07y.getText().toString()) == 0)) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07), Toast.LENGTH_SHORT).show();
            dci07y.setError("Can not be zero");
            Log.i(TAG, "dci07y: Can not be zero");
            return false;
        } else {
            dci07y.setError(null);
        }

        // ====================== Q 7 ==============
        if ((Integer.parseInt(dci07d.getText().toString().isEmpty() ? "0" : dci07d.getText().toString()) < 0
                || Integer.parseInt(dci07d.getText().toString().isEmpty() ? "0" : dci07d.getText().toString()) > 29)
                && Integer.parseInt(dci07d.getText().toString().isEmpty() ? "0" : dci07d.getText().toString()) != 98) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07d), Toast.LENGTH_SHORT).show();
            dci07d.setError("Range is 0 to 29 days... ");
            Log.i(TAG, "Range is 0 to 29 days");
            return false;
        } else {
            dci07d.setError(null);
        }

        // ====================== Q 7 ==============
        if ((Integer.parseInt(dci07m.getText().toString().isEmpty() ? "0" : dci07m.getText().toString()) < 0
                || Integer.parseInt(dci07m.getText().toString().isEmpty() ? "0" : dci07m.getText().toString()) > 11)) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07m), Toast.LENGTH_SHORT).show();
            dci07m.setError("Range is 0 to 11 months... ");
            Log.i(TAG, "Range is 0 to 11 months");
            return false;
        } else {
            dci07m.setError(null);
        }

        // ====================== Q 7 ==============
        if ((Integer.parseInt(dci07y.getText().toString().isEmpty() ? "0" : dci07y.getText().toString()) < 0
                || Integer.parseInt(dci07y.getText().toString().isEmpty() ? "0" : dci07y.getText().toString()) > 1)) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07y), Toast.LENGTH_SHORT).show();
            dci07y.setError("Range is 0 to 1 year & 11 months ... ");
            Log.i(TAG, "Range is 0 to 1 year & 11 months");
            return false;
        } else {
            dci07y.setError(null);
        }


        // ====================== Q 8 ==============
        if (dci08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci08), Toast.LENGTH_SHORT).show();
            dci0803.setError("This data is Required!");
            Log.i(TAG, "dci08: This data is Required!");
            return false;
        } else {
            dci0803.setError(null);
        }

        // ====================== Q 9 ==============
        if (dci09.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci09), Toast.LENGTH_SHORT).show();
            dci09.setError("This data is Required!");
            Log.i(TAG, "dci09: This data is Required!");
            return false;
        } else {
            dci09.setError(null);
        }
        // ====================== Q 9 ==============
        if ((Integer.parseInt(dci09.getText().toString().isEmpty() ? "0" : dci09.getText().toString()) < 0
                || Integer.parseInt(dci09.getText().toString().isEmpty() ? "0" : dci09.getText().toString()) > 23)) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci07m), Toast.LENGTH_SHORT).show();
            dci09.setError("Range is 0 to 23 months... ");
            Log.i(TAG, "Range is 0 to 23 months");
            return false;
        } else {
            dci09.setError(null);
        }


        // ====================== Q 10a ==============
        if (dci10a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci10a), Toast.LENGTH_SHORT).show();
            dci10a02.setError("This data is Required!");
            Log.i(TAG, "dci10a: This data is Required!");
            return false;
        } else {
            dci10a02.setError(null);
        }

        // ====================== Q 10b ==============
        if (dci10b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci10b), Toast.LENGTH_SHORT).show();
            dci10b02.setError("This data is Required!");
            Log.i(TAG, "dci10b: This data is Required!");
            return false;
        } else {
            dci10b02.setError(null);
        }

        // ====================== Q 11 ==============
        if (dci11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci11), Toast.LENGTH_SHORT).show();
            dci1199.setError("This data is Required!");
            Log.i(TAG, "dci11: This data is Required!");
            return false;
        } else {
            dci1199.setError(null);
        }

*/

        // ====================== Q 12 ==============
        if (dci12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci12), Toast.LENGTH_SHORT).show();
            dci1299.setError("This data is Required!");
            Log.i(TAG, "dci12: This data is Required!");
            return false;
        } else {
            dci1299.setError(null);
        }
        // ====================== Q 13 ==============
        if (dci1201.isChecked()) {
            if (dci13.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci13), Toast.LENGTH_SHORT).show();
                dci1399.setError("This data is Required!");
                Log.i(TAG, "dci13: This data is Required!");
                return false;
            } else {
                dci1399.setError(null);
            }
        } else {
            // ====================== Q 14 ==============
            if (dci14.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci14), Toast.LENGTH_SHORT).show();
                dci1499.setError("This data is Required!");
                Log.i(TAG, "dci14: This data is Required!");
                return false;
            } else {
                dci1499.setError(null);
            }

        }
        // ====================== Q 15 ==============
        if (dci1301.isChecked()) {
            if (dci15.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci15), Toast.LENGTH_SHORT).show();
                dci1599.setError("This data is Required!");
                Log.i(TAG, "dci15: This data is Required!");
                return false;
            } else {
                dci1599.setError(null);
            }
        }

        // ====================== Q 17 ==============
        if (dci16.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci16), Toast.LENGTH_SHORT).show();
            dci1699.setError("This data is Required!");
            Log.i(TAG, "dci16: This data is Required!");
            return false;
        } else {
            dci1699.setError(null);
        }

        // ====================== Q 18A ==============
        if (dci17a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17a), Toast.LENGTH_SHORT).show();
            dci17a99.setError("This data is Required!");
            Log.i(TAG, "dci17a: This data is Required!");
            return false;
        } else {
            dci17a99.setError(null);
        }
        // ====================== Q 18B ==============
        if (dci17b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17b), Toast.LENGTH_SHORT).show();
            dci17b99.setError("This data is Required!");
            Log.i(TAG, "dci17b: This data is Required!");
            return false;
        } else {
            dci17b99.setError(null);
        }

        if (dci17b01.isChecked() && dci17btimes.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17b), Toast.LENGTH_SHORT).show();
            dci17btimes.setError("This data is Required!");
            Log.i(TAG, "dci17btimes: This data is Required!");

            return false;
        } else {
            dci17btimes.setError(null);
        }


        // ====================== Q 18C ==============
        if (dci17c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17c), Toast.LENGTH_SHORT).show();
            dci17c99.setError("This data is Required!");
            Log.i(TAG, "dci17c: This data is Required!");
            return false;
        } else {
            dci17c99.setError(null);
        }

        if (dci17c01.isChecked() && dci17ctimes.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17c), Toast.LENGTH_SHORT).show();
            dci17ctimes.setError("This data is Required!");
            Log.i(TAG, "dcictimes: This data is Required!");

            return false;
        } else {
            dci17ctimes.setError(null);
        }

        // ====================== Q 18D ==============
        if (dci17d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17d), Toast.LENGTH_SHORT).show();
            dci17d99.setError("This data is Required!");
            Log.i(TAG, "dci17d: This data is Required!");
            return false;
        } else {
            dci17d99.setError(null);
        }
        // ====================== Q 18E ==============
        if (dci17e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17e), Toast.LENGTH_SHORT).show();
            dci17e99.setError("This data is Required!");
            Log.i(TAG, "dci17e: This data is Required!");
            return false;
        } else {
            dci17e99.setError(null);
        }
        // ====================== Q 18F ==============
        if (dci17f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17f), Toast.LENGTH_SHORT).show();
            dci17f99.setError("This data is Required!");
            Log.i(TAG, "dci17f: This data is Required!");
            return false;
        } else {
            dci17f99.setError(null);
        }

        if (dci17f01.isChecked() && dci17ftimes.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17f), Toast.LENGTH_SHORT).show();
            dci17ftimes.setError("This data is Required!");
            Log.i(TAG, "dci17ftimes: This data is Required!");

            return false;
        } else {
            dci17ftimes.setError(null);
        }

        // ====================== Q 18G ==============
        if (dci17g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17g), Toast.LENGTH_SHORT).show();
            dci17g99.setError("This data is Required!");
            Log.i(TAG, "dci17g: This data is Required!");
            return false;
        } else {
            dci17g99.setError(null);
        }
        // ====================== Q 18H ==============
        if (dci17h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17h), Toast.LENGTH_SHORT).show();
            dci17h99.setError("This data is Required!");
            Log.i(TAG, "dci17h: This data is Required!");
            return false;
        } else {
            dci17h99.setError(null);
        }
        // ====================== Q 18I ==============
        if (dci17i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci17i), Toast.LENGTH_SHORT).show();
            dci17i99.setError("This data is Required!");
            Log.i(TAG, "dci17i: This data is Required!");
            return false;
        } else {
            dci17i99.setError(null);
        }
        // ====================== Q 19A ==============
        if (dci18a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18a), Toast.LENGTH_SHORT).show();
            dci18a99.setError("This data is Required!");
            Log.i(TAG, "dci18a: This data is Required!");
            return false;
        } else {
            dci18a99.setError(null);
        }
        // ====================== Q 19B ==============
        if (dci18b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18b), Toast.LENGTH_SHORT).show();
            dci18b99.setError("This data is Required!");
            Log.i(TAG, "dci18b: This data is Required!");
            return false;
        } else {
            dci18b99.setError(null);
        }
        // ====================== Q 19C ==============
        if (dci18c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18c), Toast.LENGTH_SHORT).show();
            dci18c99.setError("This data is Required!");
            Log.i(TAG, "dci18c: This data is Required!");
            return false;
        } else {
            dci18c99.setError(null);
        }
        // ====================== Q 19D ==============
        if (dci18d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18d), Toast.LENGTH_SHORT).show();
            dci18d99.setError("This data is Required!");
            Log.i(TAG, "dci18d: This data is Required!");
            return false;
        } else {
            dci18d99.setError(null);
        }
        // ====================== Q 19E ==============
        if (dci18e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18e), Toast.LENGTH_SHORT).show();
            dci18e99.setError("This data is Required!");
            Log.i(TAG, "dci18e: This data is Required!");
            return false;
        } else {
            dci18e99.setError(null);
        }
        // ====================== Q 19F ==============
        if (dci18f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18f), Toast.LENGTH_SHORT).show();
            dci18f99.setError("This data is Required!");
            Log.i(TAG, "dci18f: This data is Required!");
            return false;
        } else {
            dci18f99.setError(null);
        }

        // ====================== Q 19G ==============
        if (dci18g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18g), Toast.LENGTH_SHORT).show();
            dci18g99.setError("This data is Required!");
            Log.i(TAG, "dci18g: This data is Required!");
            return false;
        } else {
            dci18g99.setError(null);
        }
        // ====================== Q 19H ==============
        if (dci18h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18h), Toast.LENGTH_SHORT).show();
            dci18h99.setError("This data is Required!");
            Log.i(TAG, "dci18h: This data is Required!");
            return false;
        } else {
            dci18h99.setError(null);
        }
        // ====================== Q 19I ==============
        if (dci18i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18i), Toast.LENGTH_SHORT).show();
            dci18i99.setError("This data is Required!");
            Log.i(TAG, "dci18i: This data is Required!");
            return false;
        } else {
            dci18i99.setError(null);
        }
        // ====================== Q 19J ==============
        if (dci18j.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18j), Toast.LENGTH_SHORT).show();
            dci18j99.setError("This data is Required!");
            Log.i(TAG, "dci18j: This data is Required!");
            return false;
        } else {
            dci18j99.setError(null);
        }
        // ====================== Q 19K ==============
        if (dci18k.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18k), Toast.LENGTH_SHORT).show();
            dci18k99.setError("This data is Required!");
            Log.i(TAG, "dci18k: This data is Required!");
            return false;
        } else {
            dci18k99.setError(null);
        }
        // ====================== Q 19L ==============
        if (dci18l.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18l), Toast.LENGTH_SHORT).show();
            dci18l99.setError("This data is Required!");
            Log.i(TAG, "dci18l: This data is Required!");
            return false;
        } else {
            dci18l99.setError(null);
        }
        // ====================== Q 19M ==============
        if (dci18m.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18m), Toast.LENGTH_SHORT).show();
            dci18m99.setError("This data is Required!");
            Log.i(TAG, "dci18m: This data is Required!");
            return false;
        } else {
            dci18m99.setError(null);
        }
        // ====================== Q 19N ==============
        if (dci18n.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18n), Toast.LENGTH_SHORT).show();
            dci18n99.setError("This data is Required!");
            Log.i(TAG, "dci18n: This data is Required!");
            return false;
        } else {
            dci18n99.setError(null);
        }
        // ====================== Q 19O ==============
        if (dci18o.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18o), Toast.LENGTH_SHORT).show();
            dci18o99.setError("This data is Required!");
            Log.i(TAG, "dci18o: This data is Required!");
            return false;
        } else {
            dci18o99.setError(null);
        }
        // ====================== Q 19P ==============
        if (dci18p.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18p), Toast.LENGTH_SHORT).show();
            dci18p99.setError("This data is Required!");
            Log.i(TAG, "dci18p: This data is Required!");
            return false;
        } else {
            dci18p99.setError(null);
        }
        // ====================== Q 19Q ==============
        if (dci18q.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci18q), Toast.LENGTH_SHORT).show();
            dci18q99.setError("This data is Required!");
            Log.i(TAG, "dci18q: This data is Required!");
            return false;
        } else {
            dci18q99.setError(null);
        }

        // ====================== Q 20 ==============
        if (dci19.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci19), Toast.LENGTH_SHORT).show();
            dci1999.setError("This data is Required!");
            Log.i(TAG, "dci19: This data is Required!");
            return false;
        } else {
            dci1999.setError(null);
        }


        // ====================== Q 21 ==============
        if (dci1901.isChecked()) {
            if (dci2001.getText().toString().isEmpty() && (!(dci2099.isChecked()))) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci20), Toast.LENGTH_SHORT).show();
                dci2099.setError("This data is Required!");
                Log.i(TAG, "dci20: This data is Required!");
                return false;
            } else {
                dci2099.setError(null);
            }
        }


        // ====================== Q 21 ==============
        if (dci21.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dci21), Toast.LENGTH_SHORT).show();
            dci2199.setError("This data is Required!");
            Log.i(TAG, "dci21: This data is Required!");
            return false;
        } else {
            dci2199.setError(null);
        }

        if (is18AllNo() && dci1901.isChecked()) {
            Toast.makeText(this, "ERROR: " + getString(R.string.dci18a) + "Atleast one should be Yes", Toast.LENGTH_SHORT).show();
            dci18a02.setError("Atlease one should be yes Other wise Select no in " + getString(R.string.dci19));
            Log.i(TAG, "dci18: This data is Required!");
            return false;
        } else {
            dci18a02.setError(null);
        }

//        if (!(is18AllNo()) && !dci1901.isChecked()) {
//            dci1901.setError("Check again" + getString(R.string.dci19));
//            Log.i(TAG, "dci19: This data is Required!");
//            return false;
//        } else {
//            dci1901.setError(null);
//        }


        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        if (is18AllNo() || is18Alldontknow()) {
            // Show answer here
            fldGrpdci19.setVisibility(View.VISIBLE);

        } else {
            fldGrpdci19.setVisibility(View.VISIBLE);
            fldGrpdci20.setVisibility(View.VISIBLE);

        }

    }

    public boolean is18AllNo() {
        boolean val = false;

        int i = 0;
        for (RadioButton rg : dci1802) {
            if (rg.isChecked())
                i++;
        }

        // Show answer here
        return i == dci1802.size();

        //return val;
    }

    public boolean is18Alldontknow() {
        boolean val = false;

        int i = 0;
        for (RadioButton rg : dci1899) {
            if (rg.isChecked())
                i++;
        }

        // Show answer here
        return i == dci1899.size();

        //return val;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}

