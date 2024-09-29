package br.com.alugames.modelo

abstract class Plano (var tipo:String) {
  open fun getValor(aluguel: Aluguel): Double {
    return aluguel.jogo.preco * aluguel.periodo.emDias
  }
}