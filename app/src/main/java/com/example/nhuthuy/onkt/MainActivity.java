package com.example.nhuthuy.onkt;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText taik, taik1;
    CheckBox luu;
    Button dangnhap;
    Button out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taik = (EditText)findViewById(R.id.ed_taiKhoan);
        taik1 = (EditText)findViewById(R.id.ed_taiKhoan1);
        luu = (CheckBox)findViewById(R.id.ckb_luuTT);

        dangnhap = (Button)findViewById(R.id.btn_dangNhap);
        out = (Button)findViewById(R.id.btn_thoat);

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoia = taik.getText().toString();
                String chuoib = taik1.getText().toString();
                if (chuoia .isEmpty() || chuoia .length() == 0 || chuoia .equals("") || chuoia == null){
                    Toast.makeText(MainActivity.this,"A chưa có Dữ liệu!",Toast.LENGTH_LONG).show();

                }else if (chuoib .isEmpty() || chuoib .length() == 0 || chuoib .equals("") || chuoib == null){
                    Toast.makeText(MainActivity.this,"B chưa có Dữ liệu!",Toast.LENGTH_LONG).show();

                } else {
                    if(luu.isChecked()){
                        Toast.makeText(MainActivity.this, "Chao mung ban dang nhap he thong, thong tin cua ban da duoc luu", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Chao mung ban dang nhap he thong, thong tin cua ban khong duoc luu", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thong bao");
                builder.setMessage("Ban co muon thoat khong?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }
}
