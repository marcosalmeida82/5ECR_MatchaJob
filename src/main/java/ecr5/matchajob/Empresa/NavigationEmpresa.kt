package ecr5.matchajob.Empresa

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import ecr5.matchajob.R

class NavigationEmpresa : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {

            // REDIRECIONA PARA FRAGMENTO ESPECIFICO
            // VAGAS
            R.id.navigation_empresa_vagas -> {
                addFragment(FragmentEmpresaVagas())
                return@OnNavigationItemSelectedListener true
            }

            // TESTES
            R.id.navigation_empresa_testes -> {
                addFragment(FragmentEmpresaTestes())
                return@OnNavigationItemSelectedListener true
            }

            // BUSCAR CANDIDATOS
            R.id.navigation_empresa_candidato -> {
                addFragment(FragmentEmpresaCandidato())
                return@OnNavigationItemSelectedListener true
            }

            // TALENTOS
            R.id.navigation_empresa_talentos -> {
                addFragment(FragmentEmpresaTalentos())
                return@OnNavigationItemSelectedListener true
            }

            // OPCÕES
            R.id.navigation_empresa_opcoes -> {
                addFragment(FragmentEmpresaOpcoes())
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
        setContentView(R.layout.navigation_empresa)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // DEFINE PAGINA INICIAL COMO: VAGAS
        addFragment(FragmentEmpresaVagas())
    }
}
