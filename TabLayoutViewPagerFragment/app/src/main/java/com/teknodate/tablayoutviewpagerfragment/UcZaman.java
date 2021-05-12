package com.teknodate.tablayoutviewpagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class UcZaman extends Fragment {
    private CheckBox evcheck,ischeck;
    private Button hesapla;
    private EditText geceet,gunduzet,puantet;
    private TextView enerjifon, trttv, etvtv, kdvtv, toplamtv;
    private float sabah, gece, puant, tuketim, enerji, TRT, etv, kdv, toplam;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragmentdemo, container, false);
       gunduzet = (EditText) v.findViewById(R.id.gunduzedt);
       geceet = (EditText) v.findViewById(R.id.geceedt);
       puantet = (EditText) v.findViewById(R.id.puantedt);
       enerjifon = (TextView) v.findViewById(R.id.enerjifon);
       trttv = (TextView) v.findViewById(R.id.trt);
       etvtv = (TextView) v.findViewById(R.id.etv);
       kdvtv = (TextView) v.findViewById(R.id.kdv);
       toplamtv = (TextView) v.findViewById(R.id.tutar);
       evcheck = (CheckBox) v.findViewById(R.id.ucev);
       ischeck = (CheckBox) v.findViewById(R.id.ucisyeri);
       hesapla = (Button) v.findViewById(R.id.uchesapla);
       hesapla.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                if (evcheck.isChecked()){
                    evFatura(); }
                else if (ischeck.isChecked()){
                    isFatura(); }
           }
       });
       return v; }
    private void isFatura() {
        sabah = (float) (Integer.parseInt(gunduzet.getText().toString()) * 0.95);
        gece = (float) (Integer.parseInt(geceet.getText().toString()) * 0.6);
        puant = (float) (Integer.parseInt(puantet.getText().toString()) * 1.4);
        tuketim = sabah + gece + puant;
        tutar(); }
    private void evFatura() {
        sabah = (float) (Integer.parseInt(gunduzet.getText().toString()) * 0.7194);
        gece = (float) (Integer.parseInt(geceet.getText().toString()) * 0.4498);
        puant = (float) (Integer.parseInt(puantet.getText().toString()) * 1.0567);
        tuketim = sabah + gece + puant;
        tutar();
    }
    private void tutar()
    {
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
