package com.renanschotten.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.renanschotten.orgs.R
import com.renanschotten.orgs.dao.ProdutoDao
import com.renanschotten.orgs.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val botao = findViewById<Button>(R.id.botao)
        botao.setOnClickListener {
            configuraBotaoSalvar()
        }
    }

    private fun configuraBotaoSalvar() {
        ProdutoDao().adicionaProduto(criarProduto())
        finish()
    }

    private fun criarProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.nome)
        val nome = campoNome.text.toString()
        val campoDesc = findViewById<EditText>(R.id.descricao)
        val desc = campoDesc.text.toString()
        val campoPreco = findViewById<EditText>(R.id.preco)
        val precoString = campoPreco.text.toString()
        val preco = if (precoString.isBlank()) BigDecimal.ZERO else BigDecimal(precoString)
        return Produto(nome, desc, preco)
    }


}