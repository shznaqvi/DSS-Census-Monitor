package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.dss_census_monitor.R;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.FormsContract;
import edu.aku.hassannaqvi.dss_census_monitor.contracts.MembersContract;
import edu.aku.hassannaqvi.dss_census_monitor.core.DatabaseHelper;
import edu.aku.hassannaqvi.dss_census_monitor.core.MainApp;


public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());


    @BindView(R.id.dca03)
    EditText dca03;
    @BindView(R.id.membersExists)
    LinearLayout membersExists;
    @BindView(R.id.dca04)
    RadioGroup dca04;
    @BindView(R.id.dca0402)
    RadioButton dca0402;
    @BindView(R.id.dca0401)
    RadioButton dca0401;
    @BindView(R.id.dca0403)
    RadioButton dca0403;
    @BindView(R.id.dca0404)
    RadioButton dca0404;
    @BindView(R.id.dca0405)
    RadioButton dca0405;
    @BindView(R.id.fldGrpdca05)
    LinearLayout fldGrpdca05;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.dca05)
    EditText dca05;
    @BindView(R.id.dca0501)
    RadioGroup dca0501;
    @BindView(R.id.dca050101)
    RadioButton dca050101;
    @BindView(R.id.dca050102)
    RadioButton dca050102;
    @BindView(R.id.dca0503)
    EditText dca0503;
    @BindView(R.id.dca0504)
    RadioGroup dca0504;
    @BindView(R.id.dca050401)
    RadioButton dca050401;
    @BindView(R.id.dca050402)
    RadioButton dca050402;
    @BindView(R.id.dca050403)
    RadioButton dca050403;
    @BindView(R.id.dca050404)
    RadioButton dca050404;
    @BindView(R.id.dca050405)
    RadioButton dca050405;
    @BindView(R.id.dca050406)
    RadioButton dca050406;
    @BindView(R.id.dca050407)
    RadioButton dca050407;
    @BindView(R.id.dca050408)
    RadioButton dca050408;
    @BindView(R.id.dca050499)
    RadioButton dca050499;
    @BindView(R.id.dca050488)
    RadioButton dca050488;
    @BindView(R.id.dca050496)
    RadioButton dca050496;
    @BindView(R.id.dca050496x)
    EditText dca050496x;
    @BindView(R.id.dca0505)
    RadioGroup dca0505;
    @BindView(R.id.dca050501)
    RadioButton dca050501;
    @BindView(R.id.dca050502)
    RadioButton dca050502;
    @BindView(R.id.dca050503)
    RadioButton dca050503;
    @BindView(R.id.dca050504)
    RadioButton dca050504;
    @BindView(R.id.dca050505)
    RadioButton dca050505;
    @BindView(R.id.dca050506)
    RadioButton dca050506;
    @BindView(R.id.dca050507)
    RadioButton dca050507;
    @BindView(R.id.dca050508)
    RadioButton dca050508;
    @BindView(R.id.dca050509)
    RadioButton dca050509;
    @BindView(R.id.dca050510)
    RadioButton dca050510;
    @BindView(R.id.dca050511)
    RadioButton dca050511;
    @BindView(R.id.dca050512)
    RadioButton dca050512;
    @BindView(R.id.dca050513)
    RadioButton dca050513;
    @BindView(R.id.dca050514)
    RadioButton dca050514;
    @BindView(R.id.dca050515)
    RadioButton dca050515;
    @BindView(R.id.dca050516)
    RadioButton dca050516;
    @BindView(R.id.dca050517)
    RadioButton dca050517;
    @BindView(R.id.dca050588)
    RadioButton dca050588;
    @BindView(R.id.dca050596)
    RadioButton dca050596;
    @BindView(R.id.dca050596x)
    EditText dca050596x;
    @BindView(R.id.dca06)
    EditText dca06;
    @BindView(R.id.dca0601)
    RadioGroup dca0601;
    @BindView(R.id.dca060101)
    RadioButton dca060101;
    @BindView(R.id.dca060102)
    RadioButton dca060102;
    @BindView(R.id.dca0602)
    EditText dca0602;
    @BindView(R.id.dca0603)
    RadioGroup dca0603;
    @BindView(R.id.dca060301)
    RadioButton dca060301;
    @BindView(R.id.dca060302)
    RadioButton dca060302;
    @BindView(R.id.dca060303)
    RadioButton dca060303;
    @BindView(R.id.dca060304)
    RadioButton dca060304;
    @BindView(R.id.dca060305)
    RadioButton dca060305;
    @BindView(R.id.dca060306)
    RadioButton dca060306;
    @BindView(R.id.dca060307)
    RadioButton dca060307;
    @BindView(R.id.dca060308)
    RadioButton dca060308;
    @BindView(R.id.dca060399)
    RadioButton dca060399;
    @BindView(R.id.dca060388)
    RadioButton dca060388;
    @BindView(R.id.dca060396)
    RadioButton dca060396;
    @BindView(R.id.dca060396x)
    EditText dca060396x;
    @BindView(R.id.dca0604)
    RadioGroup dca0604;
    @BindView(R.id.dca060401)
    RadioButton dca060401;
    @BindView(R.id.dca060402)
    RadioButton dca060402;
    @BindView(R.id.dca060403)
    RadioButton dca060403;
    @BindView(R.id.dca060404)
    RadioButton dca060404;
    @BindView(R.id.dca060405)
    RadioButton dca060405;
    @BindView(R.id.dca060406)
    RadioButton dca060406;
    @BindView(R.id.dca060407)
    RadioButton dca060407;
    @BindView(R.id.dca060408)
    RadioButton dca060408;
    @BindView(R.id.dca060409)
    RadioButton dca060409;
    @BindView(R.id.dca060410)
    RadioButton dca060410;
    @BindView(R.id.dca060411)
    RadioButton dca060411;
    @BindView(R.id.dca060412)
    RadioButton dca060412;
    @BindView(R.id.dca060413)
    RadioButton dca060413;
    @BindView(R.id.dca060414)
    RadioButton dca060414;
    @BindView(R.id.dca060415)
    RadioButton dca060415;
    @BindView(R.id.dca060416)
    RadioButton dca060416;
    @BindView(R.id.dca060417)
    RadioButton dca060417;
    @BindView(R.id.dca060488)
    RadioButton dca060488;
    @BindView(R.id.dca060496)
    RadioButton dca060496;
    @BindView(R.id.dca060496x)
    EditText dca060496x;
    @BindView(R.id.dca0701)
    EditText dca0701;
    @BindView(R.id.dca0702)
    EditText dca0702;
    @BindView(R.id.dca0703)
    EditText dca0703;
    @BindView(R.id.dca0801)
    EditText dca0801;
    @BindView(R.id.dca0802)
    EditText dca0802;
    @BindView(R.id.dca0803)
    EditText dca0803;
    @BindView(R.id.dca09)
    RadioGroup dca09;
    @BindView(R.id.dca0901)
    RadioButton dca0901;
    @BindView(R.id.dca0902)
    RadioButton dca0902;
    @BindView(R.id.dca0903)
    RadioButton dca0903;
    @BindView(R.id.fldGrpdca0901)
    LinearLayout fldGrpdca0901;
    @BindView(R.id.dca09m)
    EditText dca09m;
    @BindView(R.id.dca09y)
    EditText dca09y;
    @BindView(R.id.dca10a)
    EditText dca10a;
    @BindView(R.id.dca10b)
    EditText dca10b;


    @BindView(R.id.btn_Continue)
    Button btn_Continue;

    @BindView(R.id.btn_End)
    Button btn_End;

    @BindView(R.id.fldGrpdca10)
    LinearLayout fldGrpdca10;

    @BindView(R.id.fldGrpCheck)
    LinearLayout fldGrpCheck;

    @BindView(R.id.mp02_count)
    TextView mp02_count;

/*    @BindView(R.id.checkMembers)
    Button checkMembers;*/

    @BindView(R.id.checkDSSID)
    Button checkDSSID;

    Collection<MembersContract> members;
    DatabaseHelper db;

    Boolean isNew = false;

    boolean checked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);
        dca03.setText(MainApp.regionDss);
        dca03.setSelection(dca03.getText().length());
        MainApp.memFlag = 0;

        MainApp.familyMembersList = new ArrayList<>();
        Log.d(TAG, "onCreate: " + MainApp.familyMembersList.size());
        db = new DatabaseHelper(this);

        //==================== Permission Skip Check =================

        dca04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dca0401.isChecked()) {
                    fldGrpdca05.setVisibility(View.VISIBLE);

                    btn_Continue.setEnabled(true);
                    btn_End.setEnabled(false);
                } else {
                    fldGrpdca05.setVisibility(View.GONE);

                    dca05.setText(null);
                    dca0501.clearCheck();
                    //dca0502.clearCheck();
                    dca0503.setText(null);
                    dca0504.clearCheck();
                    dca050496x.setText(null);
                    dca0505.clearCheck();
                    dca050596x.setText(null);
                    dca06.setText(null);
                    dca0601.clearCheck();
                    dca0602.setText(null);
                    dca0603.clearCheck();
                    dca060396x.setText(null);
                    dca0604.clearCheck();
                    dca060496x.setText(null);
                    dca0701.setText(null);
                    dca0702.setText(null);
                    dca0703.setText(null);
                    dca0801.setText(null);
                    dca0802.setText(null);
                    dca0803.setText(null);
                    dca09.clearCheck();
                    dca09m.setText(null);
                    dca09y.setText(null);
                    dca10a.setText(null);
                    dca10b.setText(null);

                    btn_Continue.setEnabled(false);
                    btn_End.setEnabled(true);
                }
            }
        });

        dca09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (dca0903.isChecked()) {
                    fldGrpdca0901.setVisibility(View.VISIBLE);
                    fldGrpdca10.setVisibility(View.GONE);
                } else if (dca0902.isChecked()) {
                    fldGrpdca0901.setVisibility(View.GONE);
                    fldGrpdca10.setVisibility(View.VISIBLE);
                    dca09m.setText(null);
                    dca09y.setText(null);

                } else {
                    fldGrpdca0901.setVisibility(View.GONE);
                    fldGrpdca10.setVisibility(View.GONE);
                    dca09m.setText(null);
                    dca09y.setText(null);
                    dca10a.setText(null);
                    dca10b.setText(null);
                }
            }
        });

        /*// =================== If Respondent is male ===============

        dca0501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dca050102.isChecked()) {
                    dca050201.setEnabled(true);
                    dca050512.setEnabled(true);

                } else {
                    dca050201.setEnabled(false);
                    dca050201.setChecked(false);
                    dca050512.setEnabled(false);
                    dca050512.setChecked(false);

                }


            }
        });
*/
        //=============== Others Occupation ==============

/*        dca0505.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dca050596.isChecked()) {
                    dca050596x.setVisibility(View.VISIBLE);
                } else {
                    dca050596x.setVisibility(View.GONE);
                    dca050596x.setText(null);
                }
            }
        });*/

        //=============== Others Occupation ==============

/*        dca0604.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dca060496.isChecked()) {
                    dca060496x.setVisibility(View.VISIBLE);
                } else {
                    dca060496x.setVisibility(View.GONE);
                    dca060496x.setText(null);
                }
            }
        });*/

        // =================== If Respondent is male ===============

/*        dca0501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dca050101.isChecked()) {
                    dca050509.setEnabled(false);
                    dca050509.setChecked(false);
                } else {
                    dca050509.setEnabled(true);

                }
            }
        });

        dca050496.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dca050496x.setVisibility(View.VISIBLE);
                } else {
                    dca050496x.setVisibility(View.GONE);
                    dca050496x.setText(null);
                }
            }
        });

        dca060396.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dca060396x.setVisibility(View.VISIBLE);
                } else {
                    dca060396x.setVisibility(View.GONE);
                    dca060396x.setText(null);
                }
            }
        });*/


        dca03.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                fldGrpCheck.setVisibility(View.GONE);

//                Toast.makeText(getApplicationContext(), "Click on CHECK MEMBER button", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("check", dca0404.isChecked() ? true : dca0405.isChecked() ? true : false);
                startActivity(endSec);


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @OnClick(R.id.checkMembers)
    void onBtnCheckMemberClick() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        String member = "";

        int count = 0;
        for (MembersContract m : members) {
            member += (++count) + ")\t " + m.getName() + " \t- \t" +
                    (m.getMember_type().equals("mw") ? "(Married Women)" :
                            m.getMember_type().equals("h") ? "(Husband)" : "(Child)") + "\n";

        }

        alertDialogBuilder.setIcon(R.drawable.ic_warning_black_24dp)
                .setTitle("Members Name")
                .setMessage(member)
                .setCancelable(false);

        alertDialogBuilder.setNegativeButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    @OnClick(R.id.checkDSSID)
    void onBtnDSSIDClick() {

        membersExists.setVisibility(View.VISIBLE);

        if (!dca03.getText().toString().isEmpty()) {
            dca03.setError(null);
            members = db.getMembersByDSS(dca03.getText().toString().toUpperCase());
            mp02_count.setText(members.size() + " Members Found.");

            if (members.size() != 0) {

                for (MembersContract ec : members) {

                    MainApp.familyMembersList.add(new MembersContract(ec));
                }

                Toast.makeText(this, members.size() + "Members Found", Toast.LENGTH_LONG).show();
                MainApp.currentStatusCount = MainApp.familyMembersList.size();
                MainApp.TotalMembersCount = MainApp.familyMembersList.size();
                isNew = false;

                fldGrpCheck.setVisibility(View.VISIBLE);

            } else {
                isNew = true;
                Toast.makeText(this, "No Members Found", Toast.LENGTH_LONG).show();

                fldGrpCheck.setVisibility(View.GONE);
            }
        } else {
            dca03.setError("This data is Required!");
        }
        checked = true;
    }

    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {


        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                MainApp.NoMembersCount = Integer.parseInt(dca0701.getText().toString());
                MainApp.NoMaleCount = Integer.parseInt(dca0702.getText().toString());
                MainApp.NoFemaleCount = Integer.parseInt(dca0703.getText().toString());

                MainApp.totalChild = Integer.parseInt(dca0801.getText().toString());
                MainApp.NoBoyCount = Integer.parseInt(dca0802.getText().toString());
                MainApp.NoGirlCount = Integer.parseInt(dca0803.getText().toString());

                /*MainApp.familyMembersList = new ArrayList<>();

                members = db.getMembersByDSS(dca03.getText().toString().toUpperCase());
                if (members.size() != 0) {
                    for (MembersContract ec : members) {
                        MainApp.familyMembersList.add(new MembersContract(ec));
                    }
                }

                if (MainApp.familyMembersList.size() > 1) {
                    Toast.makeText(this, "Members Found", Toast.LENGTH_LONG).show();
                    MainApp.currentStatusCount = MainApp.familyMembersList.size();
                    MainApp.TotalMembersCount = MainApp.familyMembersList.size();
                    isNew = false;

                } else {

                    isNew = true;
                    Toast.makeText(this, "No Members Found", Toast.LENGTH_LONG).show();
                }*/
                startActivity(new Intent(this, SectionDActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        01
        if (dca03.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca03), Toast.LENGTH_SHORT).show();
            dca03.setError("This data is Required!");    // Set Error on last radio button
            return false;
        } else {
            dca03.setError(null);
        }
        if (dca03.getText().toString().length() < MainApp.regionDss.length() + 5) {
            Toast.makeText(this, dca03.getText().toString().substring(0, MainApp.regionDss.length()).toUpperCase() + "-" + MainApp.regionDss, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.dca03), Toast.LENGTH_LONG).show();
            dca03.setError("This ID is Invalid!");    // Set Error on last radio button
            return false;
        } else {
            dca03.setError(null);
        }

        if (!dca03.getText().toString().substring(0, MainApp.regionDss.length() - 4).toUpperCase().equals(MainApp.regionDss.substring(0, 2)) &&
                !dca03.getText().toString().substring(5, MainApp.regionDss.length()).toUpperCase().equals(MainApp.regionDss.substring(5, 6))) {
            Toast.makeText(this, dca03.getText().toString().substring(0, MainApp.regionDss.length()).toUpperCase() + "-" + MainApp.regionDss, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "ERROR(not matched): " + getString(R.string.dca03), Toast.LENGTH_LONG).show();
            dca03.setError("Did not match your block!");    // Set Error on last radio button
            return false;
        } else {
            dca03.setError(null);
        }

//        02
        if (dca04.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca04), Toast.LENGTH_SHORT).show();
            dca0402.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dca04: This data is Required!");
            return false;
        } else {
            dca0402.setError(null);
        }

//        03
        if (dca0401.isChecked()) {
 /*           if (dca05.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca05), Toast.LENGTH_SHORT).show();
                dca05.setError("This data is Required!");    // Set Error on last radio button
                return false;
            } else {
                dca05.setError(null);
            }

//        04
            if (dca0501.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0501), Toast.LENGTH_SHORT).show();
                dca050102.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0501: This data is Required!");
                return false;
            } else {
                dca050102.setError(null);
            }

//        05
            *//*if (dca0502.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0502), Toast.LENGTH_SHORT).show();
                dca050202.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0502: This data is Required!");
                return false;
            } else {
                dca050202.setError(null);
            }*//*

//        06
            if (dca0503.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0503), Toast.LENGTH_SHORT).show();
                dca0503.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0503: This data is Required!");
                return false;
            } else {
                dca0503.setError(null);
            }

            if ((Integer.parseInt(dca0503.getText().toString()) < 14) || (Integer.parseInt(dca0503.getText().toString()) > 99)) {
                Toast.makeText(this, "ERROR(Range): " + getString(R.string.dca0503), Toast.LENGTH_SHORT).show();
                dca0503.setError("Range is 14 - 99 Years!");    // Set Error on last radio button

                Log.i(TAG, "dca0503: Range is 14 - 99 Years!");
                return false;
            } else {
                dca0503.setError(null);
            }

//        06
            if (dca0504.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0504), Toast.LENGTH_SHORT).show();
                dca050496.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0504: This data is Required!");
                return false;
            } else {
                dca050496.setError(null);
            }

            if (dca050496.isChecked() && dca050496x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0504) + " - " + getString(R.string.dcother), Toast.LENGTH_SHORT).show();
                dca050496x.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca050496x: This data is Required!");
                return false;
            } else {
                dca050496x.setError(null);
            }

//        07
            if (dca0505.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0505), Toast.LENGTH_SHORT).show();
                dca050502.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0505: This data is Required!");
                return false;
            } else {
                dca050502.setError(null);
            }

            if (dca050596.isChecked() && dca050596x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0505), Toast.LENGTH_SHORT).show();
                dca050596x.setError("This data is Required!");    // Set Error on last radio button
                return false;
            } else {
                dca050596x.setError(null);
            }

//        08
            if (dca06.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca06), Toast.LENGTH_SHORT).show();
                dca06.setError("This data is Required!");    // Set Error on last radio button
                return false;
            } else {
                dca06.setError(null);
            }

//        09
            if (dca0601.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0601), Toast.LENGTH_SHORT).show();
                dca060102.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0601: This data is Required!");
                return false;
            } else {
                dca060102.setError(null);
            }

//        10
            if (dca0602.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0602), Toast.LENGTH_SHORT).show();
                dca0602.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0602: This data is Required!");
                return false;
            } else {
                dca0602.setError(null);
            }

            if ((Integer.parseInt(dca0602.getText().toString()) < 14) || (Integer.parseInt(dca0602.getText().toString()) > 99)) {
                Toast.makeText(this, "ERROR(Range): " + getString(R.string.dca0602), Toast.LENGTH_SHORT).show();
                dca0602.setError("Range is 14 - 99 Years!");    // Set Error on last radio button

                Log.i(TAG, "dca0602: Range is 14 - 99 Years!");
                return false;
            } else {
                dca0602.setError(null);
            }

//        11
            if (dca0603.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0603), Toast.LENGTH_SHORT).show();
                dca060396.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0603: This data is Required!");
                return false;
            } else {
                dca060396.setError(null);
            }

            if (dca060396.isChecked() && dca060396x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0603) + " - " + getString(R.string.dcother), Toast.LENGTH_SHORT).show();
                dca060396x.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca060396x: This data is Required!");
                return false;
            } else {
                dca060396x.setError(null);
            }

//        12
            if (dca0604.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0604), Toast.LENGTH_SHORT).show();
                dca060496.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0604: This data is Required!");
                return false;
            } else {
                dca060496.setError(null);
            }

            if (dca060496.isChecked() && dca060496x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca0604), Toast.LENGTH_SHORT).show();
                dca060496x.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca060496x: This data is Required!");
                return false;
            } else {
                dca060496x.setError(null);
            }*/

//        13
            if (dca0701.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca07), Toast.LENGTH_SHORT).show();
                dca0701.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0701: This data is Required!");
                return false;
            } else {
                dca0701.setError(null);
            }


            if (Integer.parseInt(dca0701.getText().toString()) < 1) {
                Toast.makeText(this, "Invalid Data: " + getString(R.string.dca07), Toast.LENGTH_SHORT).show();
                dca0701.setError("Invalid Data must me greater then 0");    // Set Error on last radio button

                Log.i(TAG, "dca0701: Invalid Data must me greater then 0");
                return false;
            } else {
                dca0701.setError(null);
            }

            if (dca0702.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca07), Toast.LENGTH_SHORT).show();
                dca0702.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0702: This data is Required!");
                return false;
            } else {
                dca0702.setError(null);
            }


            if (dca0703.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca07), Toast.LENGTH_SHORT).show();
                dca0703.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0703: This data is Required!");
                return false;
            } else {
                dca0703.setError(null);
            }

            int total = Integer.parseInt(dca0701.getText().toString());
            int male = Integer.parseInt(dca0702.getText().toString().isEmpty() ? "0" : dca0702.getText().toString());
            int female = Integer.parseInt(dca0703.getText().toString().isEmpty() ? "0" : dca0703.getText().toString());
            int totalCh = Integer.parseInt(dca0801.getText().toString().isEmpty() ? "0" : dca0801.getText().toString());
            int maleCh = Integer.parseInt(dca0802.getText().toString().isEmpty() ? "0" : dca0802.getText().toString());
            int femaleCh = Integer.parseInt(dca0803.getText().toString().isEmpty() ? "0" : dca0803.getText().toString());


            //=============== total should be equal to sum of male & female members
            if ((male + female) != total) {
                Toast.makeText(this, "Invalid: " + getString(R.string.dca07), Toast.LENGTH_SHORT).show();
                dca0701.setError("Invalid... Check Again");    // Set Error on last radio button

                Log.i(TAG, "dca0701: Invalid.... Check Again");
                return false;
            } else {
                dca0701.setError(null);
            }

            if (totalCh > total || totalCh == total) {
                Toast.makeText(this, "Invalid: " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0801.setError("Number of children cannot be equal to total members");    // Set Error on last radio button

                Log.i(TAG, "dca0801: Invalid.... Check Again");
                return false;
            } else {
                dca0801.setError(null);
            }

            if ((maleCh + femaleCh) != totalCh) {
                Toast.makeText(this, "Invalid: " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0801.setError("Invalid... Check Again");    // Set Error on last radio button

                Log.i(TAG, "dca0801: Invalid.... Check Again");
                return false;
            } else {
                dca0801.setError(null);
            }

            if (maleCh > male) {
                Toast.makeText(this, "Invalid: " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0802.setError("Children can not be greater than male members");    // Set Error on last radio button

                Log.i(TAG, "dca0802: Invalid.... Check Again");
                return false;
            } else {
                dca0802.setError(null);
            }

            if (femaleCh > female) {
                Toast.makeText(this, "Invalid: " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0803.setError("Children can not be greater than female members");    // Set Error on last radio button

                Log.i(TAG, "dca0803: Invalid.... Check Again");
                return false;
            } else {
                dca0803.setError(null);
            }


//        14
            if (dca0801.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0801.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0801: This data is Required!");
                return false;
            } else {
                dca0801.setError(null);
            }

            if (dca0802.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0802.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0802: This data is Required!");
                return false;
            } else {
                dca0802.setError(null);
            }

            if (dca0803.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca08), Toast.LENGTH_SHORT).show();
                dca0803.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca0803: This data is Required!");
                return false;
            } else {
                dca0803.setError(null);
            }

//        15
            if (dca09.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca09), Toast.LENGTH_SHORT).show();
                dca0902.setError("This data is Required!");    // Set Error on last radio button

                Log.i(TAG, "dca09: This data is Required!");
                return false;
            } else {
                dca0902.setError(null);
            }

//        16

            if (dca0902.isChecked()) {

                if (dca10a.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca10a), Toast.LENGTH_SHORT).show();
                    dca10a.setError("This data is Required!");    // Set Error on last radio button

                    Log.i(TAG, "dca10a: This data is Required!");
                    return false;
                } else {
                    dca10a.setError(null);
                }

//        18
                if (dca10b.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca10b), Toast.LENGTH_SHORT).show();
                    dca10b.setError("This data is Required!");    // Set Error on last radio button

                    Log.i(TAG, "dca10b: This data is Required!");
                    return false;
                } else {
                    dca10b.setError(null);
                }

            }

            if (dca0903.isChecked()) {
                if (dca09m.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca09m), Toast.LENGTH_SHORT).show();
                    dca09m.setError("This data is Required!");    // Set Error on last radio button
                    return false;
                } else {
                    dca09m.setError(null);
                }

                if (Integer.valueOf(dca09m.getText().toString()) > 11) {
                    Toast.makeText(this, "ERROR(Range): " + getString(R.string.dca09m), Toast.LENGTH_SHORT).show();
                    dca09m.setError("Range is 0 - 11 months");    // Set Error on last radio button
                    return false;
                } else {
                    dca09m.setError(null);
                }

                if (dca09y.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.dca09y), Toast.LENGTH_SHORT).show();
                    dca09y.setError("This data is Required!");    // Set Error on last radio button
                    return false;
                } else {
                    dca09y.setError(null);
                }
            }

        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setUUID(MainApp.familyMembersList.get(0).getUuid());
        MainApp.fc.setDSSID(dca03.getText().toString().toUpperCase());
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));

        MainApp.fc.setISNEW(isNew.toString());

        JSONObject sa = new JSONObject();

        sa.put("dca03", dca03.getText().toString());
        sa.put("dca04", dca0401.isChecked() ? "1" : dca0402.isChecked() ? "2" : dca0403.isChecked() ? "3" : dca0404.isChecked() ? "4" : dca0405.isChecked() ? "5" : "0");
        /*sa.put("dca05", dca05.getText().toString());
        sa.put("dca0501", dca050101.isChecked() ? "1" : dca050102.isChecked() ? "2" : "0");
        //sa.put("dca0502", dca050201.isChecked() ? "1" : dca050202.isChecked() ? "2" : "0");
        sa.put("dca0503", dca0503.getText().toString());
        sa.put("dca0504", dca050401.isChecked() ? "1" : dca050402.isChecked() ? "2" : dca050403.isChecked() ? "3"
                : dca050404.isChecked() ? "4" : dca050405.isChecked() ? "5" : dca050406.isChecked() ? "6" : dca050407.isChecked() ? "7"
                : dca050408.isChecked() ? "8" : dca050499.isChecked() ? "99" : dca050488.isChecked() ? "88" : dca050496.isChecked() ? "96"
                : "0");
        sa.put("dca050496x", dca050496x.getText().toString());
        sa.put("dca0505", dca050501.isChecked() ? "1" : dca050502.isChecked() ? "2" : dca050503.isChecked() ? "3"
                : dca050504.isChecked() ? "4" : dca050505.isChecked() ? "5" : dca050506.isChecked() ? "6"
                : dca050507.isChecked() ? "7" : dca050508.isChecked() ? "8" : dca050509.isChecked() ? "9"
                : dca050510.isChecked() ? "10" : dca050511.isChecked() ? "11" : dca050512.isChecked() ? "12"
                : dca050513.isChecked() ? "13" : dca050514.isChecked() ? "14" : dca050515.isChecked() ? "15"
                : dca050516.isChecked() ? "16" : dca050517.isChecked() ? "17" : dca050588.isChecked() ? "88"
                : dca050596.isChecked() ? "96" : "0");
        sa.put("dca050596x", dca050596x.getText().toString());
        sa.put("dca06", dca06.getText().toString());
        sa.put("dca0601", dca060101.isChecked() ? "1" : dca060102.isChecked() ? "2" : "0");
        sa.put("dca0602", dca0602.getText().toString());
        sa.put("dca0603", dca060301.isChecked() ? "1" : dca060302.isChecked() ? "2" : dca060303.isChecked() ? "3"
                : dca060304.isChecked() ? "4" : dca060305.isChecked() ? "5" : dca060306.isChecked() ? "6" : dca060307.isChecked() ? "7"
                : dca060308.isChecked() ? "8" : dca060399.isChecked() ? "99" : dca060388.isChecked() ? "88" : dca060396.isChecked() ? "96"
                : "0");
        sa.put("dca060396x", dca060396x.getText().toString());
        sa.put("dca0604", dca060401.isChecked() ? "1" : dca060402.isChecked() ? "2" : dca060403.isChecked() ? "3"
                : dca060404.isChecked() ? "4" : dca060405.isChecked() ? "5" : dca060406.isChecked() ? "6"
                : dca060407.isChecked() ? "7" : dca060408.isChecked() ? "8" : dca060409.isChecked() ? "9"
                : dca060410.isChecked() ? "10" : dca060411.isChecked() ? "11" : dca060412.isChecked() ? "12"
                : dca060413.isChecked() ? "13" : dca060414.isChecked() ? "14" : dca060415.isChecked() ? "15"
                : dca060416.isChecked() ? "16" : dca060417.isChecked() ? "17" : dca060488.isChecked() ? "88"
                : dca060496.isChecked() ? "96" : "0");
        sa.put("dca060496x", dca060496x.getText().toString());*/
        sa.put("dca0701", dca0701.getText().toString());
        sa.put("dca0702", dca0702.getText().toString());
        sa.put("dca0703", dca0703.getText().toString());
        sa.put("dca0801", dca0801.getText().toString());
        sa.put("dca0802", dca0802.getText().toString());
        sa.put("dca0803", dca0803.getText().toString());
        sa.put("dca09", dca0901.isChecked() ? "1" : dca0902.isChecked() ? "2" : dca0903.isChecked() ? "3" : "0");
        sa.put("dca09m", dca09m.getText().toString());
        sa.put("dca09y", dca09y.getText().toString());
        sa.put("dca10a", dca10a.getText().toString());
        sa.put("dca10b", dca10b.getText().toString());

        /*if (!dca0801.getText().toString().isEmpty()) {
            MainApp.totalChild = Integer.parseInt(dca0801.getText().toString());
        }*/

        MainApp.fc.setsA(String.valueOf(sa));

        setGPS();

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        Long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }


}
