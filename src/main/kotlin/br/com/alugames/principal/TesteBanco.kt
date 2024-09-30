package br.com.alugames.principal

import br.com.alugames.dados.Banco
import br.com.alugames.dados.JogosDAO
import br.com.alugames.modelo.Jogo

fun main() {
  val jogo = Jogo(
    "The Last of Us Part I",
    "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
    5.99,
    "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
  )
  val jogo2 = Jogo(
    "Dandara",
    "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
    9.99,
    "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
  )
  val maneger = Banco.getEntityManager()
  val jogosDAO = JogosDAO(maneger)
  //jogosDAO.adicionarJogo(jogo2)
  val jogoRecuperado = jogosDAO.recuperarPeloId(3)


  val listaJogos: List<Jogo> = jogosDAO.getLista()
  println(listaJogos)
  println("Jogo recuperado: $jogoRecuperado")
  println(listaJogos)

  maneger.close()


}
