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
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    LinearLayout resultLay;
    EditText etOne, etTwo, etThree, etFour, etFive;
    EditText sortOne, sortTwo, sortThree, sortFo, sortFi;
    RadioGroup radioGroup;
    RadioButton descRadio;
    Boolean descBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button sortButton = findViewById(R.id.sort_bt);
        etOne = findViewById(R.id.et_one);
        etTwo = findViewById(R.id.et_two);
        etThree = findViewById(R.id.et_three);
        etFour = findViewById(R.id.et_four);
        etFive = findViewById(R.id.et_five);

        sortOne =findViewById(R.id.sort_one);
        sortTwo =findViewById(R.id.sort_two);
        sortThree =findViewById(R.id.sort_three);
        sortFo =findViewById(R.id.sort_four);
        sortFi = findViewById(R.id.sort_five);

        resultLay = findViewById(R.id.sort_result);
        resultLay.setVisibility(View.GONE);

        descRadio = findViewById(R.id.desk);
        descRadio.setChecked(true);
        descBool = true;
        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.desk){
                    descBool = true;
                }
                else if (checkedId == R.id.asc)
                {
                    descBool = false;
                }

            }
        });


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
        TextView whatSort = findViewById(R.id.what_sort);
        Integer one = Integer.parseInt(etOne.getText().toString());
        Integer two = Integer.parseInt(etTwo.getText().toString());
        Integer three = Integer.parseInt(etThree.getText().toString());
        Integer four = Integer.parseInt(etFour.getText().toString());
        Integer five = Integer.parseInt(etFive.getText().toString());
        Integer array [] = {one, two, three, four, five};
        if (descBool)
        {
            Toast.makeText(this,getString(R.string.desc_check), Toast.LENGTH_SHORT).show();
            sortDesc(array);
//       або так  Arrays.sort(array, Collections.<Integer>reverseOrder());
            whatSort.setText(getString(R.string.desc_check));

        } else {
            Toast.makeText(this, getString(R.string.asc_check), Toast.LENGTH_SHORT).show();
            sortAsc(array);
 //     або    Arrays.sort(array);
            whatSort.setText(getString(R.string.asc_check));
        }
        sortOne.setText(String.valueOf(array[0]));
        sortTwo.setText(String.valueOf(array[1]));
        sortThree.setText(String.valueOf(array[2]));
        sortFo.setText(String.valueOf(array[3]));
        sortFi.setText(String.valueOf(array[4]));
        resultLay.setVisibility(View.VISIBLE);

    }
public static void sortAsc (Integer arr[])
{
    for (int i=1; i<arr.length; ++i){
        int j = i-1;
        int temp = arr[i];
        while (j>=0 && temp<arr[j])
        {
            arr[j+1] = arr[j];
            arr[j] = temp;
            --j;
        }
    }
}

    public static void sortDesc (Integer arr[])
    {
        for (int i=1; i<arr.length; ++i){
            int j = i-1;
            int temp = arr[i];
            while (j>=0 && temp>arr[j])
            {
                arr[j+1] = arr[j];
                arr[j] = temp;
                --j;
            }
        }
    }
}
