package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String msg = "";
    Boolean dark = true;
    EditText editText;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch (id) {
            case R.id.action_location: {
                location();
            }
            break;
            case R.id.action_theme_dark: {
                switchDark();
            }
            break;
            case R.id.action_format_Temperaturi: {
                formatTemperaturi();
            }
            break;

            case R.id.action_author: {
                autor();
            }
            break;
            default:

        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);

    }

    private void location() {

        msg = "action_locations";

        final AlertDialog locationsDialog = new AlertDialog.Builder(MainActivity.this).create();
        locationsDialog.setTitle("Выбрать локацию");
        locationsDialog.setMessage("Выбираем населенный пункт");
        locationsDialog.setView(getLayoutInflater().inflate(R.layout.location, null));
        locationsDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//надо брать данные у locationsDialog
                        editText = locationsDialog.findViewById(R.id.location_editText);
                        msg = editText.getText().toString();

                        Toast.makeText(MainActivity.this, msg /*editText.getText()*/, Toast.LENGTH_SHORT).show();
                        // dialog.dismiss();
                    }
                });

        locationsDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        locationsDialog.show();
    }

    private void switchDark() {
        //       msg = "theme_dark";
        final AlertDialog themeDialog = new AlertDialog.Builder(MainActivity.this).create();
        //   themeDialog.setTitle("Выбор темы");
        //   themeDialog.setMessage("");
        themeDialog.setView(getLayoutInflater().inflate(R.layout.switch_dark, null));
        themeDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        aSwitch = themeDialog.findViewById(R.id.switch_Dark);
                        dark = aSwitch.isChecked();//Состояние switch_Dark вкл выкл
                        msg = dark ? "Select Dark" : "Select No dark";

                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        themeDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        themeDialog.create();
        themeDialog.show();
    }

    private void formatTemperaturi() {
        AlertDialog.Builder temperatureDialog = new AlertDialog.Builder(MainActivity.this);
        temperatureDialog.setTitle("Формат температуры");
        String[] items = {"Фаренгейт", "Цельсий"};

        int checkedItem = 0;
        temperatureDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        msg = "Фаренгейт";
                        break;
                    case 1:
                        msg = "Цельсий";
                        break;
                }
//                        dialog.dismiss();
            }
        });
        temperatureDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        temperatureDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = temperatureDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    private void autor() {

        msg = "author";
        AlertDialog aboutDialog = new AlertDialog.Builder(MainActivity.this).create();
        aboutDialog.setTitle("Разработчик программы");
        aboutDialog.setMessage("(c)2020 студент академии ШАГ\nБугаенко Евгений.");
        aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        aboutDialog.show();
    }

    public boolean switchDark(View view) {
        return view.isClickable();
    }
}