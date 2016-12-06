package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gruposhark.mobile.gruposhark.R;
import model.MennuResumo;

/**
 * Created by jose.oliveira on 06/12/2016.
 */

public class SHKA02MennuResAdapter extends BaseAdapter {

    private Context context;
    private List<MennuResumo> mennuResumoList;

    public SHKA02MennuResAdapter(Context context, List<MennuResumo> mennuResumoList) {
        this.context = context;
        this.mennuResumoList = mennuResumoList;
    }


    @Override
    public int getCount() {
        return mennuResumoList.size();
    }

    @Override
    public Object getItem(int position) {


        return mennuResumoList.get(position);
    }

    @Override
    public long getItemId(int position) {


        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MennuResumo mennuResumo = mennuResumoList.get(position);
        View linha = LayoutInflater.from(context).inflate(R.layout.layout_shka02_mennu_resumo, null);

        //textViewSHKA02CPO01
        TextView textViewSHKA02CPO01Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO01Res);
        TextView textViewSHKA02CPO02Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO02Res);
        TextView textViewSHKA02CPO03Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO03Res);
        TextView textViewSHKA02CPO04Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO04Res);
        TextView textViewSHKA02CPO05Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO05Res);
        TextView textViewSHKA02CPO06Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO06Res);
        TextView textViewSHKA02CPO07Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO07Res);
        TextView textViewSHKA02CPO08Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO08Res);
        TextView textViewSHKA02CPO09Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO09Res);
        TextView textViewSHKA02CPO10Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO10Res);
        TextView textViewSHKA02CPO11Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO11Res);
        TextView textViewSHKA02CPO12Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO12Res);
        TextView textViewSHKA02CPO13Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO13Res);
        TextView textViewSHKA02CPO14Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO14Res);
        TextView textViewSHKA02CPO15Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO15Res);
        TextView textViewSHKA02CPO16Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO16Res);
        TextView textViewSHKA02CPO17Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO17Res);
        TextView textViewSHKA02CPO18Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO18Res);
        TextView textViewSHKA02CPO19Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO19Res);
        TextView textViewSHKA02CPO20Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO20Res);
        TextView textViewSHKA02CPO21Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO21Res);
        TextView textViewSHKA02CPO22Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO22Res);
        TextView textViewSHKA02CPO23Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO23Res);
        TextView textViewSHKA02CPO24Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO24Res);
        TextView textViewSHKA02CPO25Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO25Res);
        TextView textViewSHKA02CPO26Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO26Res);
        TextView textViewSHKA02CPO27Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO27Res);
        TextView textViewSHKA02CPO28Res = (TextView) linha.findViewById(R.id.textViewSHKA02CPO28Res);

        textViewSHKA02CPO01Res.setText(mennuResumo.getCpo01());
        textViewSHKA02CPO02Res.setText(mennuResumo.getCpo02());
        textViewSHKA02CPO03Res.setText(mennuResumo.getCpo03());
        textViewSHKA02CPO04Res.setText(mennuResumo.getCpo04());
        textViewSHKA02CPO05Res.setText(mennuResumo.getCpo05());
        textViewSHKA02CPO06Res.setText(mennuResumo.getCpo06());
        textViewSHKA02CPO07Res.setText(mennuResumo.getCpo07());
        textViewSHKA02CPO08Res.setText(mennuResumo.getCpo08());
        textViewSHKA02CPO09Res.setText(mennuResumo.getCpo09());
        textViewSHKA02CPO10Res.setText(mennuResumo.getCpo10());
        textViewSHKA02CPO11Res.setText(mennuResumo.getCpo11());
        textViewSHKA02CPO12Res.setText(mennuResumo.getCpo12());
        textViewSHKA02CPO13Res.setText(mennuResumo.getCpo13());
        textViewSHKA02CPO14Res.setText(mennuResumo.getCpo14());
        textViewSHKA02CPO15Res.setText(mennuResumo.getCpo15());
        textViewSHKA02CPO16Res.setText(mennuResumo.getCpo16());
        textViewSHKA02CPO17Res.setText(mennuResumo.getCpo17());
        textViewSHKA02CPO18Res.setText(mennuResumo.getCpo18());
        textViewSHKA02CPO19Res.setText(mennuResumo.getCpo19());
        textViewSHKA02CPO20Res.setText(mennuResumo.getCpo20());
        textViewSHKA02CPO21Res.setText(mennuResumo.getCpo21());
        textViewSHKA02CPO22Res.setText(mennuResumo.getCpo22());
        textViewSHKA02CPO23Res.setText(mennuResumo.getCpo23());
        textViewSHKA02CPO24Res.setText(mennuResumo.getCpo24());
        textViewSHKA02CPO25Res.setText(mennuResumo.getCpo25());
        textViewSHKA02CPO26Res.setText(mennuResumo.getCpo26());
        textViewSHKA02CPO27Res.setText(mennuResumo.getCpo27());
        textViewSHKA02CPO28Res.setText(mennuResumo.getCpo28());

        return linha;
    }
}
