package com.infnet.relacionamento_entre_entidades

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.room.Room


class ContatosFragment : Fragment() {

    private lateinit var contatoDAO : ContatoDAO
    private lateinit var fornecedorDAO : FornecedorDAO
    private var fornecedoresIds = ArrayList<Int>()
    private var fornecedoresNome = ArrayList<String>()
    private lateinit var listIdsContatos: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_contatos, container, false)
        val lstContato = view.findViewById<ListView>(R.id.lstContatos)

//        -----------------------------------------------------------------------
        val appDatabase = Room.databaseBuilder(
            this.requireActivity(),
            AppDatabase::class.java,
            "room_extra.db"
        ).allowMainThreadQueries().build()
        fornecedorDAO = appDatabase.obterFornecedorDAO()
        contatoDAO = appDatabase.obterContatoDAO()
//        ------------------------------------------------------------------------

        val btnSalvar = view.findViewById<Button>(R.id.btnSalvarContato)
        btnSalvar.setOnClickListener{

            val spnFornecedor = view.findViewById<Spinner>(R.id.spnFornecedores)
            val txtNomeContato = view.findViewById<EditText>(R.id.txtNomeContato)
            val txtEmailContato = view.findViewById<EditText>(R.id.txtEmailContato)
            val txtFoneContato = view.findViewById<EditText>(R.id.txtFoneContato)

            val idFornecedor = fornecedoresIds[spnFornecedor.selectedItemPosition]

            val contatoDados = Contato(
                null,
                idFornecedor,
                txtNomeContato.text.toString(),
                txtEmailContato.text.toString(),
                txtFoneContato.text.toString() )

            contatoDAO.inserir(contatoDados)
            spnFornecedor.setSelection(0)
            txtNomeContato.setText(null)
            txtEmailContato.setText(null)
            txtFoneContato.setText(null)
            this.atualizarFornecedores()
            this.atualizarContatos()
        }

        val btnDeletar = view.findViewById<Button>(R.id.btnDeleteContato)

        lstContato.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                val id = listIdsContatos.get(p2)
                val contato = contatoDAO.obter(id)

                btnDeletar.setOnClickListener {
                    contatoDAO.excluir(contato)
                    Toast.makeText(context,"Excluido com sucesso.",Toast.LENGTH_LONG).show()
                    atualizarContatos()
                }

            }

        return view
    }

    override fun onResume() {
        super.onResume()
        this.atualizarFornecedores()
        this.atualizarContatos()
    }


    private fun atualizarFornecedores(){

        val fornecedores = fornecedorDAO.listar()
        val titulos = ArrayList<String>()
        fornecedoresIds = ArrayList()
        fornecedoresNome = ArrayList()

        for(fornecedor in fornecedores) {

            titulos.add(fornecedor.razaoSocial)
            fornecedoresIds.add(fornecedor.id!!)
            fornecedoresNome.add(fornecedor.razaoSocial)

        }

        val spnFornecedor = view?.findViewById<Spinner>(R.id.spnFornecedores)
        val nome = spnFornecedor!!.selectedItemPosition
        Log.i("fornecedores", nome.toString())

        val spnFornecedores = this.requireView().findViewById<Spinner>(R.id.spnFornecedores)
        val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_list_item_1,titulos)
        spnFornecedores.adapter = adapter
    }


    private fun atualizarContatos(){
        val contatos = contatoDAO.listar()
        val tituloContato = ArrayList<String>()
        listIdsContatos = ArrayList()

        for (contato in contatos){
            tituloContato.add("${contato.nome} \n Id fornecedor: ${contato.idFornecedor} ")
            listIdsContatos.add(contato.id!!)
        }

        val lstContatos = this.requireView().findViewById<ListView>(R.id.lstContatos)
        val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_list_item_1,tituloContato)
        lstContatos.adapter = adapter

    }
}

