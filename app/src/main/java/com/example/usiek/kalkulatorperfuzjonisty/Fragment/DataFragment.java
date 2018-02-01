package com.example.usiek.kalkulatorperfuzjonisty.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;

import com.example.usiek.kalkulatorperfuzjonisty.EditDialogListener;
import com.example.usiek.kalkulatorperfuzjonisty.ModelParametrow;
import com.example.usiek.kalkulatorperfuzjonisty.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by usiek on 28.01.2018.
 */

public class DataFragment extends DialogFragment {

    @BindView(R.id.editTextWzrost)
    EditText Wzrost;

    @BindView(R.id.editTextWaga)
    EditText Waga;

    @BindView(R.id.editTextTemp)
    EditText Temp;

    @BindView(R.id.switchPlec)
    Switch Plec;

    @BindView(R.id.editTextPrzeplywKrwi)
    EditText PrzeplywKrwi;

    @BindView(R.id.editTextWskaznikSercowy)
    EditText WskaznikSercowy;

    @BindView(R.id.editTextObjetoscPierwotna)
    EditText ObjetoscPierwotna;

    @BindView(R.id.editTextRoztworKardio)
    EditText RoztworKardio;

    @BindView(R.id.editTextHCT)
    EditText HCT;

    @BindView(R.id.editTextHctOczekiwane)
    EditText HctOczekiwane;

    private EditDialogListener mListener;

    public static DataFragment newInstance() {
        return new DataFragment();
    }

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (EditDialogListener) context;
        } catch (final ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnCompleteListener");
        }
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        this.setCancelable(false);
    }

    @OnClick(R.id.buttonCountData)
    public void saveData() {
        ModelParametrow model = new ModelParametrow();
        readData(model);
        model.obliczParametry();
        this.mListener.updateResult(model);
        //        EditDialogListener activity = (EditDialogListener) getActivity();
//        activity.updateResult(model);
        this.dismiss();
    }

    private void readData(ModelParametrow model) {
        model.wzrost = Double.parseDouble(Wzrost.getText().toString()
                .replace(",", "."));
        model.waga = Double.parseDouble(Waga.getText().toString()
                .replace(",", "."));
        model.temp = Double.parseDouble(Temp.getText().toString()
                .replace(",", "."));
        model.plec = Plec.isChecked();
        model.przeplywKrwi = Double.parseDouble(PrzeplywKrwi.getText().toString()
                .replace(",", "."));
        model.wskaznikIC = Double.parseDouble(WskaznikSercowy.getText().toString()
                .replace(",", "."));
        model.objetoscPierwotna = Double.parseDouble(ObjetoscPierwotna.getText().toString()
                .replace(",", "."));
        model.roztKardio = Double.parseDouble(RoztworKardio.getText().toString()
                .replace(",", "."));
        model.hct = Double.parseDouble(HCT.getText().toString()
                .replace(",", "."));
        model.hctOczekiwane = Double.parseDouble(HctOczekiwane.getText().toString()
                .replace(",", "."));
    }
}
