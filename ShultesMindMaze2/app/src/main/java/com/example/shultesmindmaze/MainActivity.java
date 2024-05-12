package com.example.shultesmindmaze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23,bt24,bt25;
    TextView zavdannya;
    Button masBt[]= {bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23,bt24,bt25};
    String masId[] = {"bt1","bt2","bt3","bt4","bt5","bt6","bt7","bt8","bt9","bt10","bt11","bt12","bt13","bt14","bt15","bt16","bt17","bt18","bt19","bt20","bt21","bt22","bt23","bt24","bt25"};
    int masChusel[] = new int[25];
    int numberCounter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zavdannya = (TextView)findViewById(R.id.zavdannya);

        for (int i=0; i<masBt.length; i++){
            int temp = getResources().getIdentifier(masId[i], "id", getPackageName());
            masBt[i] = (Button)findViewById(temp);
        }

        for (int i=0; i<masChusel.length; i++){
            masChusel[i]=i+1;
        }
        for (int i=0; i<masChusel.length; i++){
            int nomer = new Random().nextInt(25);
            int temp = masChusel[i];
            masChusel[i] = masChusel[nomer];
            masChusel[nomer] = temp;
        }
        for (int i=0; i<masBt.length; i++){
            masBt[i].setText(masChusel[i]+"");
        }
        for (int i=0; i<masBt.length; i++){
            masBt[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        int temp = v.getId();
                Button bt = (Button)findViewById(temp);

                if(Integer.parseInt(bt.getText().toString())==numberCounter){
                    bt.setEnabled(false);
//                    bt.setVisibility(View.INVISIBLE);
                    numberCounter++;

                }
                if(numberCounter==26){
                    zavdannya.setText("МОЛОДЕЦЬ!");
                }
    }

}
