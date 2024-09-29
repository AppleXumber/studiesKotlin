package br.com.alugames.modelo

class PlanoAvulso(tipo: String):Plano(tipo) {
    override fun getValor(aluguel: Aluguel): Double {
        var originalValue = super.getValor(aluguel)
        if(aluguel.gamer.media > 8) { originalValue -= originalValue * .1}
        return originalValue
    }

}
