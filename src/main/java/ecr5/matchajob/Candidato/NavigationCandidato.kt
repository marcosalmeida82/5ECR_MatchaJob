package ecr5.matchajob.Candidato

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import ecr5.matchajob.R

class NavigationCandidato : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {

            // REDIRECIONA PARA FRAGMENTO ESPECIFICO
            // VAGAS
            R.id.navigation_candidato_vagas -> {
                addFragment(FragmentCandidatoVagas())
                return@OnNavigationItemSelectedListener true
            }

            // MENTORES
            R.id.navigation_candidato_mentores -> {
                addFragment(FragmentCandidatoMentores())
                return@OnNavigationItemSelectedListener true
            }

            // PROCESSOS
            R.id.navigation_candidato_processos -> {
                addFragment(FragmentCandidatoProcessos())
                return@OnNavigationItemSelectedListener true
            }

            // PERFIL
            R.id.navigation_candidato_perfil -> {
                addFragment(FragmentCandidatoPerfil())
                return@OnNavigationItemSelectedListener true
            }

            // OPCÕES
            R.id.navigation_candidato_opcoes -> {
                addFragment(FragmentCandidatoOpcoes())
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.fragment_container, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_candidato)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // DEFINE PAGINA INICIAL COMO: VAGAS
        addFragment(FragmentCandidatoVagas())

    }
}
