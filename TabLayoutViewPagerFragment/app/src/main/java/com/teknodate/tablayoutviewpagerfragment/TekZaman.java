package com.teknodate.tablayoutviewpagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TekZaman extends Fragment {
    private CheckBox evcheck,ischeck;
    private Button hesapla;
    private EditText tutaret;
    private TextView enerjifon, trttv, etvtv, kdvtv, toplamtv;
    private float sabah, gece, puant, tuketim, enerji, TRT, etv, kdv, toplam;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentdemo2, container, false);

        tutaret = (EditText) v.findViewById(R.id.tutaredt);

        enerjifon = (TextView) v.findViewById(R.id.enerjifonb);
        trttv = (TextView) v.findViewById(R.id.trtb);
        etvtv = (TextView) v.findViewById(R.id.etvb);
        kdvtv = (TextView) v.findViewById(R.id.kdvb);
        toplamtv = (TextView) v.findViewById(R.id.tutarb);

        evcheck = (CheckBox) v.findViewById(R.id.birev);
        ischeck = (CheckBox) v.findViewById(R.id.birisyeri);

        hesapla = (Button) v.findViewById(R.id.birhesapla);
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (evcheck.isChecked()){
                    evFatura(); }
                else if (ischeck.isChecked()){
                    isFatura(); } }});
        return v; }
    private void evFatura() {
        tuketim = (float) (Integer.parseInt(tutaret.getText().toString()) * 0.7102);
        tutar(); }
    private void isFatura(){
        tuketim = (float) (Integer.parseInt(tutaret.getText().toString()) * 0.8071);
        tutar(); }
    private void tutar() {
        enerji = (float) (tuketim * 0.01);
        TRT = (float) (tuketim * 0.02);
        etv = (float) (tuketim * 0.05);
        kdv = (float) ((tuketim + enerji + TRT + etv) * 0.18);
        toplam = kdv + tuketim;
        enerjifon.setText("Enerji Fonu Bedeli: " + (int) enerji);
        trttv.setText("TRT Payı Bedeli: " + (int) TRT);
        etvtv.setText("ETV Tutarı: " + (int) etv);
        kdvtv.setText("KDV Tutarı: " + (int) kdv);
        toplamtv.setText("Toplam Fatura Tutarı: " + (int) toplam); }}
