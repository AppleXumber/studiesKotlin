package br.com.alugames.modelo

class PlanoAssinatura(tipo:String, val mensalidade: Double, val jogosIncluidos: Int, val percentualDescontoReputacao: Double):Plano(tipo){
  override fun getValor(aluguel: Aluguel): Double {

    val jogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1
    return if(jogosNoMes <= jogosIncluidos) {
      0.0
    } else {
      var valorOriginal = super.getValor(aluguel)
      if(aluguel.gamer.media > 8) {
        valorOriginal -= valorOriginal * percentualDescontoReputacao
      }
      valorOriginal
    }
  }

}
