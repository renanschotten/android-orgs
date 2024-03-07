package com.renanschotten.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.renanschotten.orgs.R
import com.renanschotten.orgs.dao.ProdutoDao
import com.renanschotten.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {
    val dao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(this, dao.busca())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.busca())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraRecyclerView() {
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        rv.adapter = adapter
    }
}
