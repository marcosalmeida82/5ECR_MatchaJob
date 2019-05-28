package ecr5.matchajob

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import ecr5.matchajob.Candidato.CadastroCandidato
import ecr5.matchajob.Candidato.NavigationCandidato
import ecr5.matchajob.Empresa.CadastroEmpresa
import ecr5.matchajob.Empresa.NavigationEmpresa
import ecr5.matchajob.Mentor.CadastroMentor
import ecr5.matchajob.Mentor.NavigationMentor
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar.setOnClickListener {

            var username = (findViewById(R.id.txtLoginUser) as EditText).text.toString()
            var userpass = (findViewById(R.id.txtLoginPass) as EditText).text.toString()

            // REDIRECIONA PARA PAGINA DE PERFIL CORRESPONDENTE
            // EMPRESA
            if(username.toLowerCase() == "empresa"){
                val intent = Intent(this, NavigationEmpresa::class.java)
                startActivity(intent)

            // CANDIDATO
            } else if(username.toLowerCase() == "candidato"){
                val intent = Intent(this, NavigationCandidato::class.java)
                startActivity(intent)

            // MENTOR
            } else if(username.toLowerCase() == "mentor") {
                val intent = Intent(this, NavigationMentor::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this@MainActivity, "Usuário incorreto. \n\n [TEMPORÁRIO]\n Digite \"Empresa\", \"Candidato\", ou \"Mentor\" como usuário para entrar", Toast.LENGTH_LONG).show()
            }

        }

        btnCadastrarEmpresa.setOnClickListener {
            val intent = Intent(this, CadastroEmpresa::class.java)
            startActivity(intent)
        }

        btnCadastrarCandidato.setOnClickListener {
            val intent = Intent(this, CadastroCandidato::class.java)
            startActivity(intent)
        }

        btnCadastrarMentor.setOnClickListener {
            val intent = Intent(this, CadastroMentor::class.java)
            startActivity(intent)
        }

    }


}
