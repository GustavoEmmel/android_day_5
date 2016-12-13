package com.example.aluno.asynctask;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView)findViewById(R.id.iv_image);
        final EditText text = (EditText) findViewById(R.id.editText);

        Button btnDownload = (Button) findViewById(R.id.btn_download);

        final AsyncTask<String, Integer, Bitmap> downloadImage = new AsyncTask<String, Integer, Bitmap>() {

            @Override
            protected Bitmap doInBackground(String... params) {

                return DownloadUtil.downloadBitmap(params[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap){

                if (bitmap == null){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Errouuuuuuu")
                            .setMessage("Sem mensagem para mostrar")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }

                imageView.setImageBitmap(bitmap);
                progressDialog.cancel();
            }

            @Override
            protected void onProgressUpdate(Integer... values){
                super.onProgressUpdate(values);
            }

        };

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Você tem certeza que quer fazer o download da imagem...")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                progressDialog = ProgressDialog.show(MainActivity.this, "Carregando", "Carregando a imagem...");

                                downloadImage.execute(text.getText().toString());
                            }
                        })
                        .setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }
}

//"https://s.yimg.com/bt/api/res/1.2/MpRfqo7EbzEeMzzGFEMeuA--/YXBwaWQ9eW5ld3NfbGVnbztxPTg1/http://media.zenfs.com/pt-BR/homerun/pt.goal.com/d0e8670d04b7e2d4926935ff26fb4a19"