package com.example.at2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.at2.ViewModel.CadastroViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro.*

class CadastroFragment : Fragment() {
    private lateinit var viewModel:CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        cadastroBtn.setOnClickListener {
            var email = editTxtEmail.text.toString()
            var senha = editTxtPassword.text.toString()
            var senhaConf = confirmPassword.text.toString()
            var nome = editTxtNome.text.toString()

            if (senha.compareTo(senhaConf) == 0){
                var task = viewModel.createUser(email, senha)
                task
                    .addOnSuccessListener {
                        viewModel.storeUser(it.user!!.uid, nome)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    requireContext(),
                                    "Usuario cadastrado com sucesso",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            .addOnFailureListener {
                                Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG)
                                    .show()
                            }
                            .addOnCompleteListener {
                                FirebaseAuth.getInstance().signOut()
                                var intent = Intent(activity,PlaylistActivity::class.java)
                                startActivity(intent)
                            }
                    }
                    .addOnFailureListener{
                        Toast.makeText(requireContext(),it.message, Toast.LENGTH_LONG).show()
                    }
            }else
            {
                Toast.makeText(requireContext(),"As senhas não estão iguais", Toast.LENGTH_LONG).show()
            }
        }
    }
}