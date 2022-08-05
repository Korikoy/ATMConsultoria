package com.example.atmconsultoria.ui.sobre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.atmconsultoria.R
import mehdi.sakout.aboutpage.AboutPage


class SobreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val aboutPage: View = AboutPage(activity)
           .setImage(R.drawable.logo)
           .setDescription("A Atm consultoria tem como popoop pipipi asudhausydgayusgdauysgdasuydasgud")

           .addGroup("Entre em contato")
           .addEmail("Atendimento@atmconsultoria.com.br", "Envie um email")
           .addWebsite("https://www.google.com.br/","Acesse nosso Site")

           .addGroup("Redes sociais")
           .addFacebook("","FaceBook")
           .addInstagram("","Instagram")
           .addTwitter("","Twiter")
           .addYoutube("","Youtube")
           .addGitHub("","GitHub")




            .create()

        return aboutPage
        //return inflater.inflate(R.layout.fragment_sobre, container, false)
    }


}