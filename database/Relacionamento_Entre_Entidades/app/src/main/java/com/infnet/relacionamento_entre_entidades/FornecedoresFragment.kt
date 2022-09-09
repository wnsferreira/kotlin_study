package com.infnet.relacionamento_entre_entidades

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.room.Room

class FornecedoresFragment : Fragment() {

    private lateinit var fornecedorDAO : FornecedorDAO
    private lateinit var listIdsFornecedores: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fornecedores,container,false)
        val lstFornecedores = view.findViewById<ListView>(R.id.lstFornecedores)
        val txtRazaoSocial = view.findViewById<EditText>(R.id.txtRazaoSocial)
        val txtCnpj = view.findViewById<EditText>(R.id.txtCnpj)

        val appDatabase = Room.databaseBuilder(
            this.requireActivity(),
            AppDatabase::class.java,
            "room_extra.db"
        ).allowMainThreadQueries().build()

        fornecedorDAO = appDatabase.obterFornecedorDAO()

        val btnSalvar = view.findViewById<Button>(R.id.btnSalvarFornecedor)

        btnSalvar.setOnClickListener{
            this.inserirfornecedor()

        }

        val btnDeletar = view.findViewById<Button>(R.id.btnDeleteFornecedor)
        val btnAtualizar = view.findViewById<Button>(R.id.btnUpdateFornecedor)

        lstFornecedores.onItemClickListener =
            AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                val id = listIdsFornecedores.get(p2)
                val fornecedor = fornecedorDAO.obter(id)

                btnDeletar.setOnClickListener {
                    fornecedorDAO.excluir(fornecedor)
                    Toast.makeText(context,"Excluido com sucesso.",Toast.LENGTH_LONG).show()
                    atualizarFornecedores()
                }

                txtCnpj.setText(fornecedor.cnpj)
                txtRazaoSocial.setText(fornecedor.razaoSocial)
                txtRazaoSocial.requestFocus()

                btnAtualizar.setOnClickListener {

                    inserirfornecedor()
                    fornecedorDAO.excluir(fornecedor)
                    Toast.makeText(context,"Atualizado.",Toast.LENGTH_LONG).show()
                    txtRazaoSocial.setText(null)
                    txtCnpj.setText(null)

                    atualizarFornecedores()
                }

                atualizarFornecedores()

            }

        return view
    }

    override fun onResume() {
        super.onResume()
        this.atualizarFornecedores()
    }

    private fun inserirfornecedor(){
        val txtRazaoSocial = view?.findViewById<EditText>(R.id.txtRazaoSocial)
        val txtCnpj = view?.findViewById<EditText>(R.id.txtCnpj)

        val fornecedor = Fornecedor(
            null,
            txtRazaoSocial?.text.toString(),
            txtCnpj?.text.toString())

        fornecedorDAO.inserir(fornecedor)
        txtRazaoSocial?.setText(null)
        txtCnpj?.setText(null)
        this.atualizarFornecedores()
    }

    private fun atualizarFornecedores(){

        val fornecedores = fornecedorDAO.listar()
        val titulos = ArrayList<String>()
        listIdsFornecedores = ArrayList()
        for(fornecedor in fornecedores) {

            titulos.add("${fornecedor.razaoSocial} \n"+ "CNPJ: ${fornecedor.cnpj} \n")
            Log.i("Fornecedor", fornecedor.razaoSocial)
            listIdsFornecedores.add(fornecedor.id!!)
        }
        val lstFornecedores = this.requireView().findViewById<ListView>(R.id.lstFornecedores)
        val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_list_item_1,titulos)
        lstFornecedores.adapter = adapter
    }

}