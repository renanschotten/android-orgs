package com.renanschotten.orgs.dao

import com.renanschotten.orgs.model.Produto

class ProdutoDao {
    fun adicionaProduto(produto: Produto) {
        produtos.add(produto)
    }
    fun busca(): List<Produto> = produtos.toList()

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}