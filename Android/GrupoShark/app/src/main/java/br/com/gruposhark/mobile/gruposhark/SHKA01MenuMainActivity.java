package br.com.gruposhark.mobile.gruposhark;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import adapter.SHKA01MennuAdapter;
import model.Celular;
import model.Mennu;
import model.Usuario;
import util.SoapSerEnv;


public class SHKA01MenuMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Celular> celulars;
    ArrayList<Usuario>usuarios;
    ArrayList<Mennu>mennus;
    Mennu mennu;
    SHKA01MennuAdapter adapter;


    ListView listViewSHKA01Menu;
    ProgressBar progressBarSHKA01;

    private String conexao;
    private String respErro = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shka01_menu_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewSHKA01Menu = (ListView) findViewById(R.id.listViewSHKA01Menu);
        progressBarSHKA01   = (ProgressBar) findViewById(R.id.progressBarSHKA01);
        progressBarSHKA01.setVisibility(View.GONE);


        Intent it = getIntent();
        celulars = it.getParcelableArrayListExtra("CELULAR");
        usuarios = it.getParcelableArrayListExtra("USUARIO");

        conexao = usuarios.get(0).getConexao();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shka01_menu_main, menu);

        View view;


        String empresa = usuarios.get(0).getEmpresa();

        view = findViewById(R.id.nav_header_shka01);

        ImageView imageViewLogo = (ImageView) findViewById(R.id.imageViewLogo);
        TextView textViewSHKA01MenuEmpresa = (TextView) findViewById(R.id.textViewSHKA01MenuEmpresa);
        TextView textViewSHKA01MenuUser = (TextView) findViewById(R.id.textViewSHKA01MenuUser);

        switch (empresa) {
            case "C":


                imageViewLogo.setImageResource(R.drawable.agricase);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_agricase));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#932c32"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#932c32"));
                textViewSHKA01MenuEmpresa.setText("AGRICASE");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());

                break;
            case "D":
                imageViewLogo.setImageResource(R.drawable.dismamassy);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_disma));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#FFED4F54"));
                textViewSHKA01MenuEmpresa.setText("DISMA");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;

            case "E":
                imageViewLogo.setImageResource(R.drawable.equagrilagriculture);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_equagril));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#FFFDC407"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#FFFDC407"));
                textViewSHKA01MenuEmpresa.setText("EQUAGRIL");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;

            case "M":
                imageViewLogo.setImageResource(R.drawable.sharkmaquinascons);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_shark_maquinas));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#FF020302"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#FF020302"));
                textViewSHKA01MenuEmpresa.setText("SHARK MAQUINAS");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;
            case "N":
                imageViewLogo.setImageResource(R.drawable.equagrilagriculture);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_nova_holanda));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#FF034581"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#FF034581"));
                textViewSHKA01MenuEmpresa.setText("NOVA HOLANDA");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;
            case "V":
                imageViewLogo.setImageResource(R.drawable.valtra);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_valtra));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#9a9da0"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#9a9da0"));
                textViewSHKA01MenuEmpresa.setText("VALTRA");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;
            case "X":
                imageViewLogo.setImageResource(R.drawable.sharktratores);
                view.setBackground(getResources().getDrawable(R.drawable.side_nav_bar_shark_tratores));
                textViewSHKA01MenuEmpresa.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHKA01MenuUser.setTextColor(Color.parseColor("#FF024D97"));
                textViewSHKA01MenuEmpresa.setText("SHARK TRATORES");
                textViewSHKA01MenuUser.setText(usuarios.get(0).getNome());
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intentSHKC00 = new Intent(SHKA01MenuMainActivity.this, SHKC00ConfiguracaoActivity.class);
            startActivity(intentSHKC00);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Context contexto = getApplicationContext();
        int id = item.getItemId();
        int duracao = Toast.LENGTH_SHORT;
        String msg = "Função em desenvolvimento!";

        if (id == R.id.nav_liberacao) {
            Log.e("SHK02MenuActivity -> ", "onResume");
            progressBarSHKA01.setVisibility(View.GONE);
            WebService webService = new WebService();
            webService.execute(conexao);
        } else if (id == R.id.nav_consulta) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();

        } else if (id == R.id.nav_vendas) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();

        } else if (id == R.id.nav_relatorio) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();

        } else if (id == R.id.nav_manage) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();

        } else if (id == R.id.nav_share) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();

        } else if (id == R.id.nav_send) {
            Toast toast = Toast.makeText(contexto, msg,duracao);
            toast.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private class WebService extends AsyncTask<String, Object, String> {

        //private final String NAMESPACE = "http://177.11.31.87:23973/";
        private final String NAMESPACE = "http://10.1.17.100:8013/";
        private final String SOAP_SERVICE = "ws/WSMOBILE02000.apw";
        private final String URL = NAMESPACE + SOAP_SERVICE;
        private final String METHOD = "SMOBA02001";;
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
            Log.e("SHK02MenuActivity -> ", "doInBackground");
            getSMOBA02000(params[0]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            Log.e("Funcionalidade/WebService -> ", "onPreExecute");

            progressBarSHKA01.setVisibility(View.VISIBLE);
            mennus = new ArrayList<Mennu>();
            listViewSHKA01Menu.setEnabled(false);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.e("Funcionalidade/WebService -> ", "onPostExecute");

            listViewSHKA01Menu.setEnabled(true);
            adapter = new SHKA01MennuAdapter(SHKA01MenuMainActivity.this,mennus);
            listViewSHKA01Menu.setAdapter((ListAdapter) adapter);
            progressBarSHKA01.setVisibility(View.GONE);


            if (erro == false){
                listViewSHKA01Menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        progressBarSHKA01.setVisibility(View.VISIBLE);
                        Intent intentSHK02 = new Intent(getBaseContext(), SHKA02MenuResumoActivity.class);
                        String cpo03 = "";
                        String cpo04 = "";
                        //int _id = position + 1;
                        cpo03 = mennus.get(position).getCpo03();
                        cpo04 = mennus.get(position).getCpo04();
                        int pos = cpo04.indexOf("(");
                        cpo04 = cpo04.substring(0, pos);

                        intentSHK02.putExtra("CPO03", cpo03);
                        intentSHK02.putExtra("CPO04", cpo04);
                        intentSHK02.putParcelableArrayListExtra("USUARIO", usuarios);
                        intentSHK02.putParcelableArrayListExtra("MENNU", mennus);
                        startActivity(intentSHK02);
                    }
                });
            }else {
                enviarErro(respErro);
            }


        }

        public void getSMOBA02000(String _conexao){
            Log.e("SHK02MenuActivity -> ", "getIdentificadorSMOBA02000");

            request = new SoapObject(NAMESPACE, METHOD);
            envelope = new SoapSerEnv(SoapEnvelope.VER11);
            androidHttpTransport = new HttpTransportSE(URL);

            envelope.implicitTypes = true;
            envelope.setAddAdornments(false);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);

            request.addProperty("_CCONEXAO", _conexao);

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
                    libera.getProperty(i).toString();
                    mennu = new Mennu(
                            libera.getProperty(0).toString(), // LIBERA
                            libera.getProperty(1).toString(), // LIBERACAO
                            libera.getProperty(2).toString(), // DEVVENDA
                            libera.getProperty(3).toString(), // DEV. VENDA
                            libera.getProperty(4).toString(), // 1
                            libera.getProperty(5).toString() // 0
                    );
                    mennus.add(mennu);
                }
                Log.v("DADOS_WS_CAPTURADO ", response.toString());
            }
            catch(Exception e){
                Log.e("SHK02MenuActivity", "Error on soapObjectData() " + e.getMessage());
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
        Intent intentSHK99 = new Intent(SHKA01MenuMainActivity.this, SHKA99ErroActivity.class);
        intentSHK99.putExtra("ERRO", erro);
        startActivity(intentSHK99);
    }
}
