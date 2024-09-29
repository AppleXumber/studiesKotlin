package br.com.alugames.principal

import br.com.alugames.modelo.Gamer

fun main() {
    val gamer = Gamer("Airo", "Airo@gmail.com")
    val gamer2 = Gamer("Brunao", "Brunao@gmail.com", "19/01/2000", "BrunoGamer")
    println(gamer)
    println(gamer2)

    gamer.let {
        it.dataNascimento = "11/01/2005"
        it.usuario = "AppleXumber"
    }.also {
        println(gamer.idInterno)
    }
    println(gamer)
}
