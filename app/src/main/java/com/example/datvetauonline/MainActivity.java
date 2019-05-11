package com.example.datvetauonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.AlertDialog;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Your_name = (EditText) findViewById(R.id.your_name);
        final EditText Your_phone = (EditText) findViewById(R.id.your_phone);

        final RadioButton Type_VIP = (RadioButton) findViewById(R.id.Type_VIP);
        final RadioButton Type_Normal = (RadioButton) findViewById(R.id.Type_Normal);

        final RadioButton Type_bed = (RadioButton) findViewById(R.id.Type_bed);
        final RadioButton Type_chair = (RadioButton) findViewById(R.id.Type_chair);

        final CheckBox  Cb_dichvu = (CheckBox) findViewById(R.id.cb_dichvu);

        final Spinner Type_money = (Spinner) findViewById(R.id.type_money);

        final int GiuongNam = 1200000;
        final int GheNgoi = 800000;
        final int DichVu = 60000;


        Button button = (Button) findViewById(R.id.btn_xacnhan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float tt = 0;
                String a = "VND";
                String b = Type_money.getSelectedItem().toString();
                String msg = "Tên: " + Your_name.getText().toString() +
                        System.getProperty("line.separator") +
                        "Sdt: " + Your_phone.getText().toString()
                        + System.getProperty("line.separator") +
                        "Thàh viên: ";

                Your_name.setText("");
                Your_phone.setText("");

                if(Type_VIP.isChecked())
                    msg += Type_VIP.getText().toString()+ System.getProperty("line.separator") +"Loại vé ";
                if(Type_Normal.isChecked())
                    msg += Type_Normal.getText().toString()+ System.getProperty("line.separator") +"Loại vé ";

                if(Type_bed.isChecked())
                    msg += Type_bed.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";
                if(Type_chair.isChecked())
                    msg += Type_chair.getText().toString()+ System.getProperty("line.separator") +"Dịch vụ: ";


                if(Cb_dichvu.isChecked())
                    msg += "Có";
                else
                    msg += "Không";


                msg += System.getProperty("line.separator") + "Hìnhh thức thanh toán: " +
                        Type_money.getSelectedItem().toString();

                if(Type_VIP.isChecked())
                {
                    if(Type_bed.isChecked()&& Cb_dichvu.isChecked()){
                        tt = (GiuongNam + DichVu)*70/100;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_chair.isChecked() && Cb_dichvu.isChecked())
                    {
                        tt = (GheNgoi + DichVu)*70/100;

                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_bed.isChecked())
                    {
                        tt = GiuongNam*70/100;

                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_chair.isChecked())
                    {
                        tt = GheNgoi*70/100;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }

                }
                if(Type_Normal.isChecked())
                {
                    if(Type_bed.isChecked()&& Cb_dichvu.isChecked()){
                        tt = GiuongNam + DichVu;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_chair.isChecked() && Cb_dichvu.isChecked())
                    {
                        tt = GheNgoi + DichVu;

                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_bed.isChecked())
                    {
                        tt = GiuongNam;

                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + "USD";
                        }
                    }
                    else if(Type_chair.isChecked())
                    {
                        tt = GheNgoi;
                        if(b.equals(a))
                            msg += System.getProperty("line.separator") + "Thành tièn: " +  tt + "VND";
                        else {
                            tt = tt/20000;
                            msg += System.getProperty("line.separator") + "Thành tiền: " +  tt + " USD";
                        }
                    }

                }

                msg +=System.getProperty("line.separator") + "Cảm ơn quý khách !!!";

                xac_nhan(v, msg);

                Type_VIP.setChecked(false);
                Type_Normal.setChecked(false);
                Type_bed.setChecked(false);
                Type_chair.setChecked(false);
                Cb_dichvu.setChecked(false);
            }
        });

        Button close = (Button) findViewById(R.id.btn_huybo);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    private void xac_nhan(View v, String msg)
    {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thong tin hien thi");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
