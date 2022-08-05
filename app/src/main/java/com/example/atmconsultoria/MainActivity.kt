package com.example.atmconsultoria

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.atmconsultoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            enviarEmail()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,R.id.nav_contato,R.id.nav_sobre
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    fun enviarEmail(){
        var email = arrayOf("consultoria@atmconsultoria.com.br")
        var celular = "tel:11996352894"
        var endereco = "https://www.google.com/maps/search/candeias+bompreco/@-8.2049895,-34.9211123,17z/data=!3m1!4b1"
        var imagem = "https://magazine.zarpo.com.br/wp-content/uploads/2022/01/Praia-Vermelha_Zarpo.jpg"
        //val intent = Intent(Intent.ACTION_DIAL, Uri.parse(celular) )
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imagem) )
        //val intent = Intent(Intent.ACTION_VIEW, Uri.parse(endereco) )
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,email )
        intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo app" )
        intent.putExtra(Intent.EXTRA_TEXT,"Mensagem automatica" )
            intent.type = "message/rfc822"
            //intent.type = "text/plain"
            //intent.type = "image/*"
            //intent.type = "application/pdf"

        startActivity(Intent.createChooser(intent, "Compartilhar"))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}