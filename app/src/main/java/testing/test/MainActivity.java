package testing.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout resultLay;
    EditText etOne, etTwo, etThree, etFour, etFive;
    RadioGroup radioGroup;
    RadioButton deskRadio;
    Boolean deskBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etOne = findViewById(R.id.et_one);
        etTwo = findViewById(R.id.et_two);
        etThree = findViewById(R.id.et_three);
        etFour = findViewById(R.id.et_four);
        etFive = findViewById(R.id.et_five);

        ArrayList <Array> Array;
        Array.add(0, etOne.getText().toString());

        resultLay = findViewById(R.id.sort_result);
        resultLay.setVisibility(View.GONE);

        deskRadio = findViewById(R.id.desk);
        deskRadio.setChecked(true);
        deskBool = true;
        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.desk){
                    deskBool = true;

                }
                else if (checkedId == R.id.asc)
                {
                    deskBool = false;
                }

            }
        });

        Button sortButton = findViewById(R.id.sort_bt);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etOne.getText().toString()) || TextUtils.isEmpty(etTwo.getText().toString())
                        || TextUtils.isEmpty(etThree.getText().toString()) || TextUtils.isEmpty(etFour.getText().toString())
                        || TextUtils.isEmpty(etFive.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, getString(R.string.all_input), Toast.LENGTH_SHORT).show();
                } else {
                    performSort();
                }
            }
        });
    }
    public void performSort(){
        resultLay.setVisibility(View.VISIBLE);
        if (deskBool)
        {
            Toast.makeText(this,getString(R.string.desk_check), Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, getString(R.string.asc_check), Toast.LENGTH_SHORT).show();
        }
    }


}
