package com.mts.cow.nikolay.lifeofacow.screen.cowpassport;

import android.app.Activity;
import android.app.Dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.mts.cow.nikolay.lifeofacow.R;
import com.mts.cow.nikolay.lifeofacow.models.CowTTX;
import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AddCowMilkYieldFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static final String TAG_COW_PARAMS_SELECTED = "cow_params";

    AutoCompleteTextView date;
    AutoCompleteTextView milkyield;
    AutoCompleteTextView fat_content;
    AutoCompleteTextView weight;
    String[] cowttx;
    SimpleDateFormat simpleDateFormat;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "Введите достижения коровы";

        String Positivebutton1 = "Сохранить";
        String Negativebutton = "Закрыть";


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_milk_yield_frag,null);
        builder.setView(view);


        builder.setTitle(title);  // заголовок
        simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.US);




        date = view.findViewById(R.id.add_date_milkyield);
        date.setOnClickListener(v -> showDate(2013, 0, 1, R.style.NumberPickerStyle));
        milkyield = view.findViewById(R.id.add_milkyield);
        fat_content = view.findViewById(R.id.add_fat_content);
        weight = view.findViewById(R.id.add_weight);




        AlertDialog.Builder builder1 = builder.setPositiveButton(Positivebutton1, (dialog, which) -> {

            cowttx = new String[]{date.getText().toString(), milkyield.getText().toString(), fat_content.getText().toString(), weight.getText().toString()};
            Intent intent = new Intent();
            intent.putExtra(TAG_COW_PARAMS_SELECTED, cowttx);

            getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);

            Toast.makeText(getActivity(), "Вы внесли достижения коровы",Toast.LENGTH_LONG).show();
        });


        builder.setNegativeButton(Negativebutton, (dialog, id) ->{

            Toast.makeText(getActivity(), "Вы отменили ввод данных о корове", Toast.LENGTH_LONG).show();
            builder.setCancelable(true);

        });

        return builder.create();
    }


    void showDate(int year, int monthOfYear, int dayOfMonth, int spinnerTheme) {
        new SpinnerDatePickerDialogBuilder()
                .context(getContext())
                .callback(AddCowMilkYieldFragment.this)
                .spinnerTheme(spinnerTheme)
                .defaultDate(year, monthOfYear, dayOfMonth)
                .build()
                .show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        Calendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        date.setText(simpleDateFormat.format(calendar.getTime()));

    }
}
