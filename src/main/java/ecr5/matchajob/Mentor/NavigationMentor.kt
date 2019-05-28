package ecr5.matchajob.Mentor

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import ecr5.matchajob.R

class NavigationMentor : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {

            // REDIRECIONA PARA FRAGMENTO ESPECIFICO
            // VAGAS
            R.id.navigation_mentor_vagas -> {
                addFragment(FragmentMentorVagas())
                return@OnNavigationItemSelectedListener true
            }

            // REDE DE CONTATOS
            R.id.navigation_mentor_rede -> {
                addFragment(FragmentMentorRede())
                return@OnNavigationItemSelectedListener true
            }

            // PERFIL
            R.id.navigation_mentor_perfil -> {
                addFragment(FragmentMentorPerfil())
                return@OnNavigationItemSelectedListener true
            }

            // OPCÕES
            R.id.navigation_mentor_opcoes -> {
                addFragment(FragmentMentorOpcoes())
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
        setContentView(R.layout.navigation_mentor)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // DEFINE PAGINA INICIAL COMO: VAGAS
        addFragment(FragmentMentorVagas())
    }
}
