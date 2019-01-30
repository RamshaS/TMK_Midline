package edu.aku.ramshasaeed.tmk_midline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.ramshasaeed.tmk_midline.R;
import edu.aku.ramshasaeed.tmk_midline.core.DatabaseHelper;
import edu.aku.ramshasaeed.tmk_midline.core.MainApp;
import edu.aku.ramshasaeed.tmk_midline.databinding.ActivitySectionEBinding;
import edu.aku.ramshasaeed.tmk_midline.databinding.ActivitySectionKBinding;
import edu.aku.ramshasaeed.tmk_midline.validation.validatorClass;

public class SectionKActivity extends AppCompatActivity {
    ActivitySectionKBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k);
        bi.setCallback(this);

    }

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

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sM = new JSONObject();

        sM.put("tm01", bi.tm01a.isChecked() ? "1" : bi.tm01b.isChecked() ? "2" : "0");
        sM.put("tm02", bi.tm02a.isChecked() ? "1" : bi.tm02b.isChecked() ? "2" : "0");
        sM.put("tm03", bi.tm03a.isChecked() ? "1" : bi.tm03b.isChecked() ? "2" : "0");
        sM.put("tm04", bi.tm04a.isChecked() ? "1" : bi.tm04b.isChecked() ? "2" : "0");
        sM.put("tm05", bi.tm05a.isChecked() ? "1" : bi.tm05b.isChecked() ? "2" : "0");
        sM.put("tm06", bi.tm06a.isChecked() ? "1" : bi.tm06b.isChecked() ? "2" : "0");
        sM.put("tm07", bi.tm07a.isChecked() ? "1" : bi.tm07b.isChecked() ? "2" : "0");
        sM.put("tm08", bi.tm08a.isChecked() ? "1" : bi.tm08b.isChecked() ? "2" : "0");
        sM.put("tm09", bi.tm09a.isChecked() ? "1" : bi.tm09b.isChecked() ? "2" : "0");
        sM.put("tm10", bi.tm10a.isChecked() ? "1" : bi.tm10b.isChecked() ? "2" : "0");
        sM.put("tm11", bi.tm11a.isChecked() ? "1" : bi.tm11b.isChecked() ? "2" : "0");
        sM.put("tm12", bi.tm12a.isChecked() ? "1" : bi.tm12b.isChecked() ? "2" : "0");


        /*sM.put("tm13", tm13a.isChecked() ? "1" : tm13b.isChecked() ? "2" : "0");
        sM.put("tm14", tm14a.isChecked() ? "1" : tm14b.isChecked() ? "2" : "0");
        sM.put("tm15", tm15a.isChecked() ? "1" : tm15b.isChecked() ? "2" : "0");*/

        MainApp.fc.setsM(String.valueOf(sM));
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSM();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.tm01, bi.tm01a, getString(R.string.tm01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm02, bi.tm02a, getString(R.string.tm02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm03, bi.tm03a, getString(R.string.tm03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm04, bi.tm04a, getString(R.string.tm04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm05, bi.tm05a, getString(R.string.tm05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm06, bi.tm06a, getString(R.string.tm06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm07, bi.tm07a, getString(R.string.tm07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm08, bi.tm08a, getString(R.string.tm08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm09, bi.tm09a, getString(R.string.tm09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm10, bi.tm10a, getString(R.string.tm10))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm11, bi.tm11a, getString(R.string.tm11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.tm12, bi.tm12a, getString(R.string.tm12))) {
            return false;
        }
        return true;
    }
}