package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.gruposhark.mobile.gruposhark.R;
import model.Mennu;

/**
 * Created by Admin on 30/10/2016.
 */
public class SHKA01MennuAdapter extends BaseAdapter {

    private Context context;
    private List<Mennu> mennuList;
    //private LayoutInflater layoutInflater;

    public SHKA01MennuAdapter(Context context, List<Mennu> mennuList) {
        this.context = context;
        this.mennuList = mennuList;
        //this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        return mennuList.size();
    }

    @Override
    public Object getItem(int position) {

        return mennuList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Mennu mennu = mennuList.get(position);
        View linha = LayoutInflater.from(context).inflate(R.layout.layout_shka01_menu_list, null);

        TextView textViewSHK02CPO04 = (TextView) linha.findViewById(R.id.textViewSHK02CPO04);
        textViewSHK02CPO04.setText(mennu.getCpo04());
        //textViewSHK02CPO04.setBackgroundColor(Color.parseColor("#FFFDC407"));
        return linha;
    }
}
