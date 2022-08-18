package com.infnet.relacionamento_entre_entidades

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.room.Room


class ContatosFragment : Fragment() {


    private lateinit var contatoDAO : ContatoDAO
    private lateinit var fornecedorDAO : FornecedorDAO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_contatos, container, false)

//        -----------------------------------------------------------------------
        val appDatabase = Room.databaseBuilder(
            this.requireActivity(),
            AppDatabase::class.java,
            "room_extra.db"
        ).allowMainThreadQueries().build()
        fornecedorDAO = appDatabase.obterFornecedorDAO()
        contatoDAO = appDatabase.obterContatoDAO()
//        ------------------------------------------------------------------------

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.atualizarFornecedores()

    }

    private fun atualizarFornecedores(){

        val fornecedores = fornecedorDAO.listar()
        val titulos = ArrayList<String>()
        for(fornecedor in fornecedores) {

            titulos.add(fornecedor.razaoSocial)
        }
        val spnFornecedores = this.requireView().findViewById<Spinner>(R.id.spnFornecedores)
        val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_list_item_1,titulos)
        spnFornecedores.adapter = adapter
    }

}