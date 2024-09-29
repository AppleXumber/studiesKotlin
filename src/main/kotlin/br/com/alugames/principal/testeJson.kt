package br.com.alugames.principal

import br.com.alugames.modelo.Periodo
import br.com.alugames.modelo.PlanoAssinatura
import br.com.alugames.servico.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
  val consumo = ConsumoApi()
  val listaGamer = consumo.listaGamer()
  val listaJogosJson = consumo.buscaJogosJson()

  val gamerCaroline = listaGamer[3]
  val jogoREVillage = listaJogosJson[10]
  val jogoSpider = listaJogosJson[13]
  val jogoTLOU = listaJogosJson[2]

  val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
  val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(14))
  val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(23))

  gamerCaroline.alugaJogo(jogoREVillage, periodo1)
  gamerCaroline.alugaJogo(jogoSpider, periodo2)
  gamerCaroline.alugaJogo(jogoTLOU, periodo3)

  //println(gamerCaroline.jogosAlugados)

  val gamerCamila = listaGamer[5]
  gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
  gamerCamila.alugaJogo(jogoREVillage, periodo2)
  gamerCamila.alugaJogo(jogoSpider, periodo1)
  gamerCamila.alugaJogo(jogoTLOU, periodo3)
  gamerCamila.alugaJogo(jogoREVillage, periodo3)
  gamerCamila.recomendar(7)
  gamerCamila.recomendar(10)
  gamerCamila.recomendar(9)
  gamerCamila.alugaJogo(jogoREVillage, periodo2)
  gamerCamila.recomendarJogo(jogoREVillage, 10)
  gamerCamila.recomendarJogo(jogoSpider, 9)
  gamerCamila.recomendarJogo(jogoTLOU, 6)
  gamerCaroline.recomendarJogo(jogoREVillage, 7)
  gamerCaroline.recomendarJogo(jogoSpider, 10)
  gamerCaroline.recomendarJogo(jogoTLOU, 9)
  val jogoTheLastOfUs = listaJogosJson[2]
  val jogoDandara = listaJogosJson[5]
  val jogoAssassins = listaJogosJson[4]
  val jogoCyber = listaJogosJson[6]
  val jogoGod = listaJogosJson[7]
  val jogoSkyrim = listaJogosJson[18]

  gamerCamila.recomendarJogo(jogoREVillage, 7)
  gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
  gamerCamila.recomendarJogo(jogoAssassins, 8)
  gamerCamila.recomendarJogo(jogoCyber, 7)
  gamerCamila.recomendarJogo(jogoGod, 10)
  gamerCamila.recomendarJogo(jogoDandara, 8)
  gamerCamila.recomendarJogo(jogoSkyrim, 8)
  gamerCamila.recomendarJogo(jogoSpider, 6)

  val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
  val serializedGames = gson.toJson(gamerCamila.jogosRecomendados)
  println(serializedGames)

  val arquivo = File("recomendacao-${gamerCamila.nome}.json")
  arquivo.writeText(serializedGames)
  println(arquivo.absolutePath)



}