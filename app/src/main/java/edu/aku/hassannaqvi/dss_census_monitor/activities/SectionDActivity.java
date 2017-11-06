package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class SectionDActivity extends Activity {

    private static final String TAG = SectionDActivity.class.getSimpleName();


    @BindView(R.id.dcd01)
    RadioGroup dcd01;
    @BindView(R.id.dcd0101)
    RadioButton dcd0101;
    @BindView(R.id.dcd0102)
    RadioButton dcd0102;
    @BindView(R.id.dcd0103)
    RadioButton dcd0103;
    @BindView(R.id.dcd0104)
    RadioButton dcd0104;
    @BindView(R.id.dcd06)
    RadioGroup dcd06;
    @BindView(R.id.dcd0601)
    RadioButton dcd0601;
    @BindView(R.id.dcd0602)
    RadioButton dcd0602;
    @BindView(R.id.dcd0603)
    RadioButton dcd0603;
    @BindView(R.id.dcd13)
    RadioGroup dcd13;
    @BindView(R.id.dcd1301)
    RadioButton dcd1301;
    @BindView(R.id.dcd1302)
    RadioButton dcd1302;
    @BindView(R.id.dcd1303)
    RadioButton dcd1303;
    @BindView(R.id.dcd1304)
    RadioButton dcd1304;
    @BindView(R.id.dcd1305)
    RadioButton dcd1305;
    @BindView(R.id.dcd1306)
    RadioButton dcd1306;
    @BindView(R.id.dcd1307)
    RadioButton dcd1307;
    @BindView(R.id.dcd1396)
    RadioButton dcd1396;
    @BindView(R.id.dcd1396x)
    EditText dcd1396x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d);
        ButterKnife.bind(this);

        // ========================= Q 10 Others============================
        dcd13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == dcd1396.getId()) {

                    dcd1396x.setVisibility(View.VISIBLE);
                    dcd1396x.requestFocus();

                } else {

                    dcd1396x.setVisibility(View.GONE);
                    dcd1396x.setText(null);
                }
            }
        });

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {
        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
//        Intent end_intent = new Intent(this, EndingActivity.class);
//        end_intent.putExtra("check", false);
//        startActivity(end_intent);

        MainApp.endActivity(this, this);
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

                Intent secNext = new Intent(this, SectionEActivity.class);
                startActivity(secNext);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (dcd01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcd01), Toast.LENGTH_SHORT).show();
            dcd0104.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcd01: This data is Required!");
            return false;
        } else {
            dcd0104.setError(null);
        }


//        03

        if (dcd06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcd06), Toast.LENGTH_SHORT).show();
            dcd0601.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcd06: This data is Required!");
            return false;
        } else {
            dcd0601.setError(null);
        }

//        10

        if (dcd13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcd13), Toast.LENGTH_SHORT).show();
            dcd1396.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcd13: This data is Required!");
            return false;
        } else {
            dcd1396.setError(null);
        }

        if (dcd1396.isChecked() && dcd1396x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcd13), Toast.LENGTH_SHORT).show();
            dcd1396x.setError("This data is Required!");    // Set Error on last radio button
            Log.i(TAG, "dcd1396x: This data is Required!");
            return false;
        } else {
            dcd1396x.setError(null);
        }

        return true;
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSD();

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

        JSONObject sD = new JSONObject();

        // Radio Group


        sD.put("dcd01", dcd0101.isChecked() ? "1" : dcd0102.isChecked() ? "2"
                : dcd0103.isChecked() ? "3" : dcd0104.isChecked() ? "4" : "0");

        sD.put("dcd06", dcd0601.isChecked() ? "1" : dcd0602.isChecked() ? "2"
                : dcd0603.isChecked() ? "3" : "0");

//        10
        sD.put("dcd13", dcd1301.isChecked() ? "1" : dcd1302.isChecked() ? "2" : dcd1303.isChecked() ? "3"
                : dcd1304.isChecked() ? "4" : dcd1305.isChecked() ? "5" : dcd1306.isChecked() ? "6" :
                dcd1307.isChecked() ? "7" : dcd1396.isChecked() ? "96" : "0");
        // Edit Text
        sD.put("dcd1396x", dcd1396x.getText().toString());

        MainApp.fc.setsD(String.valueOf(sD));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
