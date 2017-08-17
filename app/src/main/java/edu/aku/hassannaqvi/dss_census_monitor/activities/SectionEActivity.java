package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.dss_census_monitor.R;
import edu.aku.hassannaqvi.dss_census_monitor.core.DatabaseHelper;
import edu.aku.hassannaqvi.dss_census_monitor.core.MainApp;

public class SectionEActivity extends Activity {

    private static final String TAG = SectionEActivity.class.getSimpleName();

    @BindView(R.id.dce01)
    RadioGroup dce01;
    @BindView(R.id.dce0101)
    RadioButton dce0101;
    @BindView(R.id.dce0102)
    RadioButton dce0102;
    @BindView(R.id.dce0103)
    RadioButton dce0103;
    @BindView(R.id.dce0196)
    RadioButton dce0196;
    @BindView(R.id.dce0196x)
    EditText dce0196x;
    @BindView(R.id.dce02)
    RadioGroup dce02;
    @BindView(R.id.dce0201)
    RadioButton dce0201;
    @BindView(R.id.dce0202)
    RadioButton dce0202;
    @BindView(R.id.dce03)
    RadioGroup dce03;
    @BindView(R.id.dce0301)
    RadioButton dce0301;
    @BindView(R.id.dce0302)
    RadioButton dce0302;
    @BindView(R.id.dce0303)
    RadioButton dce0303;
    @BindView(R.id.dce0304)
    RadioButton dce0304;
    @BindView(R.id.dce0396)
    RadioButton dce0396;
    @BindView(R.id.dce0396x)
    EditText dce0396x;
    @BindView(R.id.dce04)
    RadioGroup dce04;
    @BindView(R.id.dce0401)
    RadioButton dce0401;
    @BindView(R.id.dce0402)
    RadioButton dce0402;
    @BindView(R.id.dce05)
    RadioGroup dce05;
    @BindView(R.id.dce0501)
    RadioButton dce0501;
    @BindView(R.id.dce0502)
    RadioButton dce0502;
    @BindView(R.id.dce0503)
    RadioButton dce0503;
    @BindView(R.id.dce0504)
    RadioButton dce0504;
    @BindView(R.id.dce0596)
    RadioButton dce0596;
    @BindView(R.id.dce0596x)
    EditText dce0596x;
    @BindView(R.id.fldGrpdce05)
    LinearLayout fldGrpdce05;
    @BindView(R.id.fldGrpdce02)
    LinearLayout fldGrpdce02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_e);
        ButterKnife.bind(this);

        // ========================= Q 1 Others============================

        dce0196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dce0196x.setVisibility(View.VISIBLE);
                    dce0196x.requestFocus();

                } else {
                    dce0196x.setVisibility(View.GONE);
                    dce0196x.setText(null);
                }
            }
        });
        dce01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (dce0101.isChecked()) {
                    fldGrpdce02.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdce02.setVisibility(View.GONE);
                    dce02.clearCheck();
                    dce03.clearCheck();
                    dce0396x.setText(null);

                }
            }
        });

        // ========================= Q 3 Others============================
        dce03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == dce0396.getId()) {

                    dce0396x.setVisibility(View.VISIBLE);
                    dce0396x.requestFocus();

                } else {

                    dce0396x.setVisibility(View.GONE);
                    dce0396x.setText(null);
                }
            }
        });

        // ========================= Q 5 Others============================
        dce05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == dce0596.getId()) {

                    dce0596x.setVisibility(View.VISIBLE);
                    dce0596x.requestFocus();

                } else {

                    dce0596x.setVisibility(View.GONE);
                    dce0596x.setText(null);
                }
            }
        });

        dce04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (dce0401.isChecked()) {
                    fldGrpdce05.setVisibility(View.VISIBLE);
                } else {
                    fldGrpdce05.setVisibility(View.GONE);
                    dce05.clearCheck();
                    dce0596x.setText(null);
                }
            }
        });


    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
//        finish();
//                Intent endSec = new Intent(this, EndingActivity.class);
//                endSec.putExtra("check", false);
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

                finish();

//                startActivity(new Intent(this, MotherListActivity.class));
                if (MainApp.totalChild > 0) {
                    startActivity(new Intent(this, SectionKActivity.class));
                } else {
                    startActivity(new Intent(this, EndingActivity.class).putExtra("check",true));
                }
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSE();

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

        JSONObject sE = new JSONObject();

        // Radio Group
        sE.put("dce01", dce0101.isChecked() ? "1" : dce0102.isChecked() ? "2" : dce0103.isChecked() ? "3"
                : dce0196.isChecked() ? "96" : "0");
        // Edit Text
        sE.put("dce0196x", dce0196x.getText().toString());
        // Radio Group
        sE.put("dce02", dce0201.isChecked() ? "1" : dce0202.isChecked() ? "2" : "0");
        // Radio Group
        sE.put("dce03", dce0301.isChecked() ? "1" : dce0302.isChecked() ? "2" : dce0303.isChecked() ? "3"
                : dce0304.isChecked() ? "4" : dce0396.isChecked() ? "96" : "0");
        // Edit Text
        sE.put("dce0396x", dce0396x.getText().toString());
//        sE.put("dce03", dce0301.isChecked() ? "1" : dce0302.isChecked() ? "2" : "0");
        sE.put("dce04", dce0401.isChecked() ? "1" : dce0402.isChecked() ? "2" : "0");
        sE.put("dce05", dce0501.isChecked() ? "1" : dce0502.isChecked() ? "2" : dce0503.isChecked() ? "3"
                : dce0504.isChecked() ? "4" : dce0596.isChecked() ? "96" : "0");
        // Edit Text
        sE.put("dce0596x", dce0596x.getText().toString());
        MainApp.fc.setsE(String.valueOf(sE));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();


    }

    public boolean formValidation() {

        // ====================== Q 1 ==============

        if (dce01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce01), Toast.LENGTH_SHORT).show();
            dce0196.setError("This data is Required!");
            Log.i(TAG, "dce01: This data is Required!");
            return false;
        } else {
            dce0196.setError(null);
        }
        if (dce0196.isChecked()) {
            if (dce0196x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce01), Toast.LENGTH_SHORT).show();
                dce0196x.setError("This data is Required!");
                Log.i(TAG, "dce0196x: This data is Required!");
                return false;
            } else {
                dce0196x.setError(null);
            }
        }


        // ======================  Q 2 =================
        if (dce0101.isChecked()) {
            if (dce02.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce02), Toast.LENGTH_SHORT).show();
                dce0202.setError("This data is Required!");
                Log.i(TAG, "dce02: This data is Required!");
                return false;
            } else {
                dce0202.setError(null);
            }

            // ======================  Q 3 =================

            if (dce03.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce03), Toast.LENGTH_SHORT).show();
                dce0396.setError("This data is Required!");
                Log.i(TAG, "dce03: This data is Required!");
                return false;
            } else {
                dce0396.setError(null);
            }

            if (dce0396.isChecked()) {
                if (dce0396x.getText().toString().isEmpty()) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce03), Toast.LENGTH_SHORT).show();
                    dce0396x.setError("This data is Required!");
                    Log.i(TAG, "dce0396x: This data is Required!");
                    return false;
                } else {
                    dce0396x.setError(null);
                }
            }
        }

        if (dce04.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce04), Toast.LENGTH_SHORT).show();
            dce0402.setError("This data is Required!");
            Log.i(TAG, "dce04: This data is Required!");
            return false;
        } else {
            dce0402.setError(null);
        }

        if (dce0401.isChecked()) {
            if (dce05.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce05), Toast.LENGTH_SHORT).show();
                dce0596.setError("This data is Required!");
                Log.i(TAG, "dce05: This data is Required!");
                return false;
            } else {
                dce0596.setError(null);
            }

            if (dce0596.isChecked() && dce0596x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.dce05) + " - " + getString(R.string.dcother), Toast.LENGTH_LONG).show();
                dce0596x.setError("This data is Required!");    // Set Error on last radio button
                Log.i(TAG, "dce0596x: This data is Required!");
                return false;
            } else {
                dce0596x.setError(null);
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}

