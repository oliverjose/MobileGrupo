package br.com.gruposhark.mobile.gruposhark;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import adapter.SHKA02MennuResAdapter;
import model.Celular;
import model.Mennu;
import model.MennuResumo;
import model.Usuario;
import util.SoapSerEnv;

public class SHKA02MenuResumoActivity extends AppCompatActivity {

    ArrayList<Celular> celulars;
    ArrayList<Usuario>usuarios;
    ArrayList<Mennu>mennus;
    ArrayList<MennuResumo>mennuResumos;
    ArrayList<MennuResumo>mennuRotulos;
    SHKA02MennuResAdapter adapter;
    MennuResumo mennuResumo;

    ListView listViewSHKA02MenuResumo;

    TextView textViewSHKA02CPO01Rot;
    TextView textViewSHKA02CPO02Rot;
    TextView textViewSHKA02CPO03Rot;
    TextView textViewSHKA02CPO04Rot;
    TextView textViewSHKA02CPO05Rot;
    TextView textViewSHKA02CPO06Rot;
    TextView textViewSHKA02CPO07Rot;
    TextView textViewSHKA02CPO08Rot;
    TextView textViewSHKA02CPO09Rot;
    TextView textViewSHKA02CPO10Rot;
    TextView textViewSHKA02CPO11Rot;
    TextView textViewSHKA02CPO12Rot;
    TextView textViewSHKA02CPO13Rot;
    TextView textViewSHKA02CPO14Rot;
    TextView textViewSHKA02CPO15Rot;
    TextView textViewSHKA02CPO16Rot;
    TextView textViewSHKA02CPO17Rot;
    TextView textViewSHKA02CPO18Rot;
    TextView textViewSHKA02CPO19Rot;
    TextView textViewSHKA02CPO20Rot;
    TextView textViewSHKA02CPO21Rot;
    TextView textViewSHKA02CPO22Rot;
    TextView textViewSHKA02CPO23Rot;
    TextView textViewSHKA02CPO24Rot;
    TextView textViewSHKA02CPO25Rot;
    TextView textViewSHKA02CPO26Rot;
    TextView textViewSHKA02CPO27Rot;
    TextView textViewSHKA02CPO28Rot;


    ImageView imageViewSHKA02Grupo;
    //TextView textViewSHK02Menu;
    TextView textViewSHKA02GrupoShark;

    Button buttonSHKA02Voltar;

    ProgressBar progressBarSHKA02;

    private String cpo03;
    private String cpo04;
    private String conexao;
    private String respErro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shka02_menu_resumo);
        Log.e("SHKA02MenuResumoActivity -> ", "onCreate");


        mennuResumos = new ArrayList<MennuResumo>();
        mennuRotulos = new ArrayList<MennuResumo>();

        listViewSHKA02MenuResumo = (ListView) findViewById(R.id.listViewSHKA02MenuResumo);

        textViewSHKA02CPO01Rot = (TextView) findViewById(R.id.textViewSHKA02CPO01Rot);
        textViewSHKA02CPO02Rot = (TextView) findViewById(R.id.textViewSHKA02CPO02Rot);
        textViewSHKA02CPO03Rot = (TextView) findViewById(R.id.textViewSHKA02CPO03Rot);
        textViewSHKA02CPO04Rot = (TextView) findViewById(R.id.textViewSHKA02CPO04Rot);
        textViewSHKA02CPO05Rot = (TextView) findViewById(R.id.textViewSHKA02CPO05Rot);
        textViewSHKA02CPO06Rot = (TextView) findViewById(R.id.textViewSHKA02CPO06Rot);
        textViewSHKA02CPO07Rot = (TextView) findViewById(R.id.textViewSHKA02CPO07Rot);
        textViewSHKA02CPO08Rot = (TextView) findViewById(R.id.textViewSHKA02CPO08Rot);
        textViewSHKA02CPO09Rot = (TextView) findViewById(R.id.textViewSHKA02CPO09Rot);
        textViewSHKA02CPO10Rot = (TextView) findViewById(R.id.textViewSHKA02CPO10Rot);

        textViewSHKA02CPO11Rot = (TextView) findViewById(R.id.textViewSHKA02CPO11Rot);
        textViewSHKA02CPO12Rot = (TextView) findViewById(R.id.textViewSHKA02CPO12Rot);
        textViewSHKA02CPO13Rot = (TextView) findViewById(R.id.textViewSHKA02CPO13Rot);
        textViewSHKA02CPO14Rot = (TextView) findViewById(R.id.textViewSHKA02CPO14Rot);
        textViewSHKA02CPO15Rot = (TextView) findViewById(R.id.textViewSHKA02CPO15Rot);
        textViewSHKA02CPO16Rot = (TextView) findViewById(R.id.textViewSHKA02CPO16Rot);
        textViewSHKA02CPO17Rot = (TextView) findViewById(R.id.textViewSHKA02CPO17Rot);
        textViewSHKA02CPO18Rot = (TextView) findViewById(R.id.textViewSHKA02CPO18Rot);
        textViewSHKA02CPO19Rot = (TextView) findViewById(R.id.textViewSHKA02CPO19Rot);
        textViewSHKA02CPO20Rot = (TextView) findViewById(R.id.textViewSHKA02CPO20Rot);

        textViewSHKA02CPO21Rot = (TextView) findViewById(R.id.textViewSHKA02CPO21Rot);
        textViewSHKA02CPO22Rot = (TextView) findViewById(R.id.textViewSHKA02CPO22Rot);
        textViewSHKA02CPO23Rot = (TextView) findViewById(R.id.textViewSHKA02CPO23Rot);
        textViewSHKA02CPO24Rot = (TextView) findViewById(R.id.textViewSHKA02CPO24Rot);
        textViewSHKA02CPO25Rot = (TextView) findViewById(R.id.textViewSHKA02CPO25Rot);
        textViewSHKA02CPO26Rot = (TextView) findViewById(R.id.textViewSHKA02CPO26Rot);
        textViewSHKA02CPO27Rot = (TextView) findViewById(R.id.textViewSHKA02CPO27Rot);
        textViewSHKA02CPO28Rot = (TextView) findViewById(R.id.textViewSHKA02CPO28Rot);

        buttonSHKA02Voltar = (Button) findViewById(R.id.buttonSHKA02Voltar);

        progressBarSHKA02   = (ProgressBar) findViewById(R.id.progressBarSHKA02);
        progressBarSHKA02.setVisibility(View.GONE);

        imageViewSHKA02Grupo = (ImageView) findViewById(R.id.imageViewSHKA02Grupo);
        //textViewSHK02Menu = (TextView) findViewById(R.id.textViewSHK02Menu);
        textViewSHKA02GrupoShark = (TextView) findViewById(R.id.textViewSHKA02GrupoShark);

        Intent it = getIntent();
        celulars = it.getParcelableArrayListExtra("CELULAR");
        usuarios = it.getParcelableArrayListExtra("USUARIO");
        mennus = it.getParcelableArrayListExtra("MENNU");
        cpo03 = it.getStringExtra("CPO03");
        cpo04 = it.getStringExtra("CPO04");
        textViewSHKA02GrupoShark.setText(cpo04);

        conexao = usuarios.get(0).getConexao();

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SHKA02MenuResumoActivity -> ", "onResume");

        WebService webService = new WebService();
        webService.execute(conexao, cpo03);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SHKA02MenuResumoActivity -> ", "onPause");
    }

    public void voltarSHK02_onClick(View view) {
        onBackPressed();
        //Intent intentSHKA02 = new Intent(this, SHK02MenuActivity.class);
        //startActivity(intentSHKA02);
    }


    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE03000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA03001";;
        private final String SOAP_ACTION = NAMESPACE + METHOD;

        private SoapObject request = null;
        private SoapObject results = null;
        private SoapObject response = null;
        private SoapObject liberacao = null;
        private SoapObject libera = null;
        private SoapSerEnv envelope = null;
        private HttpTransportSE androidHttpTransport = null;

        boolean erro = false;

        public WebService() {
        }

        @Override
        protected String doInBackground(String... params) {
            Log.e("SHKA02MenuResumoActivity -> ", "doInBackground");

            getSMOBA03000(params[0], params[1]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.e("Funcionalidade/WebService -> ", "onPreExecute");
            progressBarSHKA02.setVisibility(View.VISIBLE);
            mennus = new ArrayList<Mennu>();
            mennuRotulos = new ArrayList<MennuResumo>();
            mennuResumos = new ArrayList<MennuResumo>();
            buttonSHKA02Voltar.setEnabled(false);
            listViewSHKA02MenuResumo.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("Funcionalidade/WebService -> ", "onPostExecute");

            if (erro == false){
                buttonSHKA02Voltar.setEnabled(true);
                listViewSHKA02MenuResumo.setEnabled(true);
                textViewSHKA02CPO01Rot.setText(mennuRotulos.get(0).getCpo01());
                textViewSHKA02CPO02Rot.setText(mennuRotulos.get(0).getCpo02());
                textViewSHKA02CPO03Rot.setText(mennuRotulos.get(0).getCpo03());
                textViewSHKA02CPO04Rot.setText(mennuRotulos.get(0).getCpo04());
                textViewSHKA02CPO05Rot.setText(mennuRotulos.get(0).getCpo05());
                textViewSHKA02CPO06Rot.setText(mennuRotulos.get(0).getCpo06());
                textViewSHKA02CPO07Rot.setText(mennuRotulos.get(0).getCpo07());
                textViewSHKA02CPO08Rot.setText(mennuRotulos.get(0).getCpo08());
                textViewSHKA02CPO09Rot.setText(mennuRotulos.get(0).getCpo09());
                textViewSHKA02CPO10Rot.setText(mennuRotulos.get(0).getCpo10());
                textViewSHKA02CPO11Rot.setText(mennuRotulos.get(0).getCpo11());
                textViewSHKA02CPO12Rot.setText(mennuRotulos.get(0).getCpo12());
                textViewSHKA02CPO13Rot.setText(mennuRotulos.get(0).getCpo13());
                textViewSHKA02CPO14Rot.setText(mennuRotulos.get(0).getCpo14());
                textViewSHKA02CPO15Rot.setText(mennuRotulos.get(0).getCpo15());
                textViewSHKA02CPO16Rot.setText(mennuRotulos.get(0).getCpo16());
                textViewSHKA02CPO17Rot.setText(mennuRotulos.get(0).getCpo17());
                textViewSHKA02CPO18Rot.setText(mennuRotulos.get(0).getCpo18());
                textViewSHKA02CPO19Rot.setText(mennuRotulos.get(0).getCpo19());
                textViewSHKA02CPO20Rot.setText(mennuRotulos.get(0).getCpo20());
                textViewSHKA02CPO21Rot.setText(mennuRotulos.get(0).getCpo21());
                textViewSHKA02CPO22Rot.setText(mennuRotulos.get(0).getCpo22());
                textViewSHKA02CPO23Rot.setText(mennuRotulos.get(0).getCpo23());
                textViewSHKA02CPO24Rot.setText(mennuRotulos.get(0).getCpo24());
                textViewSHKA02CPO25Rot.setText(mennuRotulos.get(0).getCpo25());
                textViewSHKA02CPO26Rot.setText(mennuRotulos.get(0).getCpo26());
                textViewSHKA02CPO27Rot.setText(mennuRotulos.get(0).getCpo27());
                textViewSHKA02CPO28Rot.setText(mennuRotulos.get(0).getCpo28());

                //listViewSHKA02MenuResumo.

                adapter = new SHKA02MennuResAdapter(SHKA02MenuResumoActivity.this,mennuResumos);
                listViewSHKA02MenuResumo.setAdapter((ListAdapter) adapter);

                progressBarSHKA02.setVisibility(View.GONE);

                listViewSHKA02MenuResumo.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Intent intentSHK02 = new Intent(getBaseContext(), SHK04MenuDetalhe.class);
                        Intent intentSHK02 = new Intent(getBaseContext(), SHKA02MenuResumoActivity.class);


                        intentSHK02.putExtra("ID", position);
                        intentSHK02.putExtra("CPO03", cpo03);
                        intentSHK02.putExtra("CPO04", cpo04);
                        intentSHK02.putParcelableArrayListExtra("USUARIO", usuarios);
                        intentSHK02.putParcelableArrayListExtra("MENNU", mennus);
                        intentSHK02.putParcelableArrayListExtra("MENNUROT", mennuRotulos);
                        intentSHK02.putParcelableArrayListExtra("MENNURES", mennuResumos);

                        startActivity(intentSHK02);
                    }
                });
            }else{
                enviarErro(respErro);
            }

        }

        public void getSMOBA03000(String _conexao, String _cpo03){
            Log.e("SHKA02MenuResumoActivity -> ", "getSMOBA03000");


            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);
            request.addProperty("_CLOTE", "");
            request.addProperty("_CTPRET", "R");
            request.addProperty("_CGRUPO", _cpo03);

            try {
                androidHttpTransport.getServiceConnection().setRequestProperty("Connection", "close");
                System.setProperty("http.keepAlive", "false");

                androidHttpTransport.call(SOAP_ACTION, envelope);

                results = (SoapObject) envelope.bodyIn;
                response = (SoapObject) envelope.getResponse();
                liberacao = (SoapObject) results.getProperty(0);

                for (int i = 0; i < liberacao.getPropertyCount(); i++) {
                    libera = (SoapObject) liberacao.getProperty(i);
                    Log.d("CONEXAO_WS_EFETUADA: ", response.toString());
                    //libera.getProperty(i).toString();
                    mennuResumo = new MennuResumo(
                            libera.getProperty(0).toString(),
                            libera.getProperty(1).toString(),
                            libera.getProperty(2).toString(),
                            libera.getProperty(3).toString(),
                            libera.getProperty(4).toString(),
                            libera.getProperty(5).toString(),
                            libera.getProperty(6).toString(),
                            libera.getProperty(7).toString(),
                            libera.getProperty(8).toString(),
                            libera.getProperty(9).toString(),
                            libera.getProperty(10).toString(),
                            libera.getProperty(11).toString(),
                            libera.getProperty(12).toString(),
                            libera.getProperty(13).toString(),
                            libera.getProperty(14).toString(),
                            libera.getProperty(15).toString(),
                            libera.getProperty(16).toString(),
                            libera.getProperty(17).toString(),
                            libera.getProperty(18).toString(),
                            libera.getProperty(19).toString(),
                            libera.getProperty(20).toString(),
                            libera.getProperty(21).toString(),
                            libera.getProperty(22).toString(),
                            libera.getProperty(23).toString(),
                            libera.getProperty(24).toString(),
                            libera.getProperty(25).toString(),
                            libera.getProperty(26).toString(),
                            libera.getProperty(27).toString()
                    );

                    if (i == 0){
                        mennuRotulos.add(mennuResumo);
                    }else {
                        mennuResumos.add(mennuResumo);
                    }

                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHKA02MenuResumoActivity -> ", "Error on soapObjectData() " + e.getMessage());
                if(envelope.bodyIn != null){
                    respErro = envelope.bodyIn.toString();
                }else {
                    Class c = e.getClass();
                    respErro = c.getName();
                }
                erro = true;//1
            }
        }
    }

    public void enviarErro(String _erro){
        String erro = _erro;
        respErro = null;
        Intent intentSHK99 = new Intent(SHKA02MenuResumoActivity.this, SHKA99ErroActivity.class);
        intentSHK99.putExtra("ERRO", erro);
        startActivity(intentSHK99);
    }

}
