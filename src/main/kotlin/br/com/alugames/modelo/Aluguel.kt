package br.com.alugames.modelo

import java.time.Period

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo) {
  private val valorDoAluguel = gamer.plano.getValor(this)
  override fun toString(): String {
    return "Aluguel do ${jogo.titulo} por ${gamer.nome}, custando R$ $valorDoAluguel"
  }

}