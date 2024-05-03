package com.example.pruebarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pruebarecyclerview.adaptadores.UsuarioAdaptador;
import com.example.pruebarecyclerview.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener {

    RecyclerView rcv_usuarios;
    List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario usu1 = new Usuario("https://www.lapatilla.com/wp-content/uploads/2019/06/2019-06-09T204127Z_1067488173_RC164F69BFB0_RTRMADP_3_SOCCER-UEFANATIONS-POR-NLD.jpg?fit=2300%2C1619", "CRISTIANO", "THE BEST");
        Usuario usu2 = new Usuario("https://www.xtrafondos.com/wallpapers/resoluciones/19/lionel-messi-barcelona_2560x1440_3260.jpg", "MESSI", "FUTBOLISTA");
        Usuario usu3 = new Usuario("https://superstarsbio.com/wp-content/uploads/2019/01/Neymar.jpg", "NEY", "JUGADOR");

        usuarioList.add(usu1);
        usuarioList.add(usu2);
        usuarioList.add(usu3);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(usuarioList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(usuarioList);
        rcv_usuarios.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Usuario usuario) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}