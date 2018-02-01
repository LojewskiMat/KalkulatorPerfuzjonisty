package com.example.usiek.kalkulatorperfuzjonisty;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.widget.TextView;

import com.example.usiek.kalkulatorperfuzjonisty.Fragment.DataFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity implements EditDialogListener {

    @BindView(R.id.zylnaSVCwynik)
    TextView SVC;

    @BindView(R.id.zylnaWspolnaWynik)
    TextView Wspolna;

    @BindView(R.id.tetniczaMaxPrzeplywWynik)
    TextView TetniczaPrzeplyw;

    @BindView(R.id.tetniczaDLPWynik)
    TextView DLPwynik;

    @BindView(R.id.aortalnaWynik)
    TextView AortalnaWynik;

    @BindView(R.id.CPBwynik)
    TextView CPB;

    @BindView(R.id.ObjętoscKrwiKrazacejWynik)
    TextView KrewKrazaca;

    @BindView(R.id.WskaznikHemodylucjiWynik)
    TextView Hemodylucja;

    @BindView(R.id.PodazKoncentratuWynik)
    TextView PodazKrwi;

    @BindView(R.id.HenatokrytCPBwynik)
    TextView HEmatokrytOczekiwany;

    ModelParametrow model = new ModelParametrow();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogFragment newDialogFragment = DataFragment.newInstance();
        newDialogFragment.show(getSupportFragmentManager(), "dialog");
//        DataFragment.newInstance().show(getSupportFragmentManager(), "");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public void updateResult(ModelParametrow modelParametrow) {
        this.model = modelParametrow;

        SVC.setText(model.kaniuleSVC);
        Wspolna.setText(String.valueOf(model.kaniulaWspolna));
        DLPwynik.setText(String.valueOf(model.DLP));
        TetniczaPrzeplyw.setText(model.wymiarKaniuliTetniczej);
        AortalnaWynik.setText(String.valueOf(model.rozmiarAortalnej));
        CPB.setText(String.valueOf(model.cbp));
        KrewKrazaca.setText(String.valueOf(model.objetoscKrwiKrazacej));
        Hemodylucja.setText(String.valueOf(model.wskaznikHemodilucji));
        HEmatokrytOczekiwany.setText(String.valueOf(model.hematocrytOczekiwany));
        PodazKrwi.setText(String.valueOf(model.vkk));
    }
}
