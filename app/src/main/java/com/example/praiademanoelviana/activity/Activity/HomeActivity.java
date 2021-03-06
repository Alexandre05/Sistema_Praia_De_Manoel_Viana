package com.example.praiademanoelviana.activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.praiademanoelviana.R;
import com.example.praiademanoelviana.activity.Helper.ConfiruFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth autenticacao;
    private MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarComponentes();
        autenticacao = ConfiruFirebase.getFirebaseAutenticacao();



        //Configurações Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarNova);
        toolbar.setTitle(" Praia e Camping Rainha do Sol");
        setSupportActionBar(toolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_usuario, menu);
         MenuItem item = menu.findItem(R.id.menuPesquisa);
         searchView.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSair :
                deslogarUsuario();
                break;
            case R.id.menuConfigurações :
                abrirConfiguracoes();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

 private  void inicializarComponentes(){
searchView = findViewById(R.id.materialS);



 }
    private void deslogarUsuario(){
        try {
            autenticacao.signOut();
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void abrirConfiguracoes(){
        startActivity(new Intent(HomeActivity.this, ConfiguracoesUsuariosActivity.class));
    }

}
