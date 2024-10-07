package br.com.alugames.principal

import br.com.alugames.dados.AluguelDAO
import br.com.alugames.dados.Banco
import br.com.alugames.dados.GamersDAO
import br.com.alugames.dados.JogosDAO
import br.com.alugames.modelo.Periodo

fun main() {
  val manager = Banco.getEntityManager()
  val jogoDAO = JogosDAO(manager)
  val gamerDAO = GamersDAO(manager)
  val aluguelDAO = AluguelDAO(manager)

  val gamer = gamerDAO.recuperarPeloId(1)
  val jogo = jogoDAO.recuperarPeloId(3)
  val aluguel = gamer.alugaJogo(jogo, Periodo())

  aluguelDAO.adicionar(aluguel)

  val listaAluguel = aluguelDAO.getLista()
  println(listaAluguel)

  manager.close()
}