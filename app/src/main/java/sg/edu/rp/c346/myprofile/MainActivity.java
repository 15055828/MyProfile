package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;
    @Override
    protected void onPause() {
        super.onPause();
        String name = etName.getText().toString();
        Float gpa = Float.parseFloat(etGPA.getText().toString());
        boolean like = ckbLike.isChecked();
        int genderid = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", name);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putBoolean("Yes?", like);
        prefEdit.putInt("radio", genderid);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("name", "NULL");
        Float gpa = prefs.getFloat("gpa", 0);
        boolean checked = prefs.getBoolean("Yes?", false);
        int genderid = prefs.getInt("radio", 1);
        etName.setText(name);
        etGPA.setText(gpa.toString());
        rgGender.check(genderid);
        ckbLike.setChecked(checked);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText)findViewById(R.id.editTextName);
        etGPA = (EditText)findViewById(R.id.editTextGPA);
        rgGender = (RadioGroup)findViewById(R.id.RadioGroupGender);
        ckbLike = (CheckBox)findViewById(R.id.checkBoxLikeProgramming);
        if(ckbLike.isChecked())
        {
            ckbLike.setChecked(true);
        }
        else
        {
            ckbLike.setChecked(false);
        }
    }
}
