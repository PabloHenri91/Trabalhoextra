package br.edu.fadergs.trabalhoextra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    // Nome e idade são EditText
    private EditText nome;
    private EditText idade;

    // Sexo é o Radio
    private RadioGroup sexo;

    //País: Spinner é um widget "combobox"
    private Spinner spPais;

    //Idioma que domina
    private CheckBox idiomasDominaPortugues;
    private CheckBox idiomasDominaIngles;
    private CheckBox idiomasDominaEspanhol;

    //Botão de enviar
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Nome... pegando referência do campo
        nome = findViewById(R.id.edtNome);

        // Idade... pegando referência do campo
        idade = findViewById(R.id.edtIdade);

        // Sexo... pegando referência do campo
        sexo = findViewById(R.id.rgSexo);

        //****************** País - INÍCIO ***************************
        //País... pegando referência do campo
        spPais = (Spinner) findViewById(R.id.spPaises);

        //Obtém os nomes dos países do arquivo de strings e cria com este, um array de Strings ao invés de colocar hardcode os valores
        String[] nomePaises = new String[] {getString(R.string.selecione_opcao), getString(R.string.argentina), getString(R.string.brasil), getString(R.string.bolivia)};

        //Criar Adapter com o array de Strings do passo anterior.
        //Está utilizando layout pronto do Android: android.R.layout.simple_spinner_item
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nomePaises);

        //Configura layout do Android para qdo fechar dropdown: android.R.layout.simple_spinner_dropdown_item
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Configura o Spinner com o adapter criado
        spPais.setAdapter(adapter);
        //****************** País - FINAL ***************************


        // Idiomas... pegando referência de cada campo, cada opção
        idiomasDominaPortugues = findViewById(R.id.cbPortugues);
        idiomasDominaIngles = findViewById(R.id.cbIngles);
        idiomasDominaEspanhol = findViewById(R.id.cbEspanhol);

        enviar = findViewById(R.id.btnEnviar);

        //Listener no Botão "Enviar"
        enviar.setOnClickListener(new View.OnFocusChangeListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, OutraActivity.class);

                //*************** Pegando valores dos EditText ***************
                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("idade", idade.getText().toString());

                //***************  Observe como obtem-se o valor de um Radio...
                int idRadioSelecionado = sexo.getCheckedRadioButtonId();
                RadioButton radio = findViewById(idRadioSelecionado);
                intent.putExtra("sexo", radio.getText().toString());

                //***************  Observe como obtem-se o valor de um Combobox (Spinner, no Android)
                String paisSelecionado = spPais.getSelectedItem().toString();
                intent.putExtra("pais", paisSelecionado);

                //*************** Checkbox se domina Inglês
                String idiomaIngles = idiomasDominaIngles.isChecked() ? getString(R.string.ingles) : "-";
                intent.putExtra("ingles", idiomaIngles);

                //*************** Checkbox se domina Espanhol
                String idiomaEspanhol = idiomasDominaEspanhol.isChecked() ? getString(R.string.espanhol) : "-";
                intent.putExtra("espanhol", idiomaEspanhol);

                startActivity(intent);
                finish();

            }
        });


    }

    private Integer validar() {

        String paisSelecionado =  spPais.getSelectedItem().toString();
        Log.d(TAG, "O país selecionado foi " + paisSelecionado);

        String idadeInformada = idade.getText().toString();
        Log.d(TAG, "A idade informada foi " + idadeInformada);



    }
}
