package br.edu.fadergs.trabalhoextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OutraActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvIdade;
    private TextView tvSexo;
    private TextView tvPais;
    private TextView tvIdiomasQueDomina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        //Pegando o Intent da tela anterior e deste os valores enviados
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String sexo = intent.getStringExtra("sexo");
        String pais = intent.getStringExtra("pais");
        String idiomasQueDomina =  intent.getStringExtra("portugues") + ", " +
                                    intent.getStringExtra("ingles") + ", " +
                                    intent.getStringExtra("espanhol");


        //Pegando referência dos campos
        tvNome = findViewById(R.id.tvNome);
        tvIdade = findViewById(R.id.tvIdade);
        tvSexo = findViewById(R.id.tvSexo);
        tvPais = findViewById(R.id.tvPais);
        tvIdiomasQueDomina = findViewById(R.id.tvIdiomasQueDomina);

        //Populando os campos com os valores que vieram da tela anterior via Intent
        tvNome.setText(nome);
        tvIdade.setText(idade);
        tvSexo.setText(sexo);
        tvPais.setText(pais);
        tvIdiomasQueDomina.setText(idiomasQueDomina);

    }

    public void voltar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
