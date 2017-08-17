package edu.aku.hassannaqvi.dss_census_monitor.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class SectionGActivity extends Activity {

    private static final String TAG = SectionGActivity.class.getSimpleName();

    @BindView(R.id.dcg02)
    RadioGroup dcg02;
    @BindView(R.id.dcg0201)
    RadioButton dcg0201;
    @BindView(R.id.dcg0202)
    RadioButton dcg0202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_g);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_End)
    void onBtnEndClick() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();

//        finish();
        MainApp.finishActivity(this,this);
    }

    @OnClick(R.id.btn_Continue)
    void onBtnContinueClick() {
        //TODO implement

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

                startActivity(new Intent(this, SectionHActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


//        02
        if (dcg02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.dcg02), Toast.LENGTH_SHORT).show();
            dcg0202.setError("This data is Required!");    // Set Error on last radio button

            Log.i(TAG, "dcg02: This data is Required!");
            return false;
        } else {
            dcg0202.setError(null);
        }

        return true;
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSG();

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

        JSONObject sG = new JSONObject();

        // Edit Text

//        02
        sG.put("dcg02", dcg0201.isChecked() ? "1" : dcg0202.isChecked() ? "2" : "0");

        MainApp.mc.setsG(String.valueOf(sG));

        Toast.makeText(this, "Validation SuccessGul! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}
