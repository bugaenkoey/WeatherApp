package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String msg = "";
    Boolean dark = true;
    EditText editText;

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
                msg = "action_locations";

                AlertDialog locationsDialog = new AlertDialog.Builder(MainActivity.this).create();
                locationsDialog.setTitle("Выбрать локацию");
                locationsDialog.setMessage("Выбираем населенный пункт");
                locationsDialog.setView(getLayoutInflater().inflate(R.layout.location, null));
                locationsDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                editText=(EditText)findViewById(R.id.location_editText);
                                msg=String.valueOf(editText.getText());


                             //   Log.v("EditText value=", text.getText().toString());
                              //  String value = text.getText().toString();
                              //  EditText locateText = (EditText) findViewById(R.id.location_editText);
                                //     msg = String.valueOf(locateText.getText());
                                //    msg = String.valueOf((R.string.action_location_text));
                                //     msg = String.valueOf((findViewById(R.id.location_editText)).
                                //     getContext().getText(R.string.action_location_text));

                                Toast.makeText(MainActivity.this,msg /*editText.getText()*/, Toast.LENGTH_SHORT).show();
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
            break;
            case R.id.action_theme_dark: {
                //       msg = "theme_dark";
                final AlertDialog themeDialog = new AlertDialog.Builder(MainActivity.this).create();
                themeDialog.setTitle("Выбор темной темы");
                themeDialog.setMessage("Пустрь будет темная тема");
                //  aboutDialog.set
                View vdark = getLayoutInflater().inflate(R.layout.theme_checkbox, null);
                themeDialog.setView(vdark);

                themeDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                            }
                        });

                themeDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                themeDialog.create();
//                AlertDialog alert = themeDialog.create();
//                alert.setCanceledOnTouchOutside(false);
//                alert.show();
                themeDialog.show();


            }
            break;
            case R.id.action_format_Temperaturi: {
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
            break;

            case R.id.action_author: {
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
            break;
            default:

        }
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            msg = "Dark on";
            Toast.makeText(this, "Cheese me", Toast.LENGTH_SHORT).show();

        } else {
            msg = "Ligt";
            Toast.makeText(this, "I'm lactose intolerant", Toast.LENGTH_SHORT).show();
        }
    }

    public void toggleDark(View view) {
        boolean checked = ((ToggleButton) view).isChecked();

        if (checked) {
            msg = "Dark on";
            Toast.makeText(this, "Dark on", Toast.LENGTH_SHORT).show();

        } else {
            msg = "Ligt";
            Toast.makeText(this, "Ligt", Toast.LENGTH_SHORT).show();
        }
    }
}