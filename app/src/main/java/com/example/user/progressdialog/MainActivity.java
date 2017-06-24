package com.example.user.progressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog t= new dialog();
        t.start();

    }
    class dialog extends Thread{
        ProgressDialog progressDialog;
        Handler handler;
        dialog(){
            handler=new Handler();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading....");
            //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }

        @Override
        public void run(){
            int count=(int)(Math.random()*10);
            while(true){
                final int assign=count;
                if(count>=100){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                        }
                    });
                    break;
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setProgress(assign);
                        }
                    });
                }
                count+=(int)(Math.random()*15);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){e.printStackTrace();}
            }
        }
    }
}
