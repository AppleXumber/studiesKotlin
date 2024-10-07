package br.com.alugames.principal

import br.com.alugames.dados.Banco
import br.com.alugames.dados.GamersDAO
import br.com.alugames.dados.PlanosDAO
import br.com.alugames.modelo.Gamer

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

    gamer.plano = planosDAO.recuperarPeloId(3)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}