package br.com.alugames.modelo

import com.google.gson.annotations.Expose
import javax.persistence.*

data class Jogo(@Expose val titulo: String, @Expose val capa: String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    private var listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if(nota> 10 || nota < 1) throw Exception("Valor fora do intervalo permitido")
        listaNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id:Int = 0):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao\n" +
                "Preço: $preco\n" +
                "Reputação: $media\n" +
                "Id: $id"
    }

}
