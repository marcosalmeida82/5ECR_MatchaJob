package ecr5.matchajob.Candidato

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import ecr5.matchajob.MainActivity
import ecr5.matchajob.R
import kotlinx.android.synthetic.main.activity_cadastro_mentor.*

class CadastroCandidato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_candidato)


        btnCadastrar.setOnClickListener {

            var nome = (findViewById(R.id.txtNome) as EditText).text
            var idade = (findViewById(R.id.txtIdade) as EditText).text
            var cpf = (findViewById(R.id.txtCPF) as EditText).text
            var email = (findViewById(R.id.txtEmail) as EditText).text
            var senha = (findViewById(R.id.txtPassword) as EditText).text

            var valida = true

            if(idade.toString().toInt() < 15)
                valida = false

            if(valida) {
                Toast.makeText(this, "Conta cadastrada com sucesso. \nEfetue o Login", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Idade minima permitida: 15 anos", Toast.LENGTH_LONG).show()

        }

    }
}
