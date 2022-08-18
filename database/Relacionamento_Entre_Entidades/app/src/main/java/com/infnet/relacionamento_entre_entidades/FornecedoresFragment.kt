package com.infnet.relacionamento_entre_entidades

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.room.Room

class FornecedoresFragment : Fragment() {

    private lateinit var fornecedorDAO : FornecedorDAO

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fornecedores,container,false)
//        ----------------------------------------------------------------------
        val appDatabase = Room.databaseBuilder(
            this.requireActivity(),
            AppDatabase::class.java,
            "room_extra.db"
        ).allowMainThreadQueries().build()

        fornecedorDAO = appDatabase.obterFornecedorDAO()

        //        ----------------------------------------------------------------------

        val btnSalvar = view.findViewById<Button>(R.id.btnSalvarFornecedor)
        btnSalvar.setOnClickListener{

            val txtRazaoSocial = view.findViewById<EditText>(R.id.txtRazaoSocial)
            val txtCnpj = view.findViewById<EditText>(R.id.txtCnpj)
            val fornecedor = Fornecedor(null, txtRazaoSocial.text.toString(), txtCnpj.text.toString())
            fornecedorDAO.inserir(fornecedor)
            txtRazaoSocial.setText(null)
            txtCnpj.setText(null)
            this.atualizarFornecedores()
        }

        return view

    }

    private fun atualizarFornecedores(){

        val fornecedores = fornecedorDAO.listar()
        val titulos = ArrayList<String>()
        for(fornecedor in fornecedores) {

            titulos.add(fornecedor.razaoSocial)
        }
        val lstFornecedores = this.requireActivity().findViewById<ListView>(R.id.lstFornecedores)
        val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_list_item_1,titulos)
        lstFornecedores.adapter = adapter
    }

}