package br.com.alugames.utilitario

import br.com.alugames.modelo.Gamer
import br.com.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}