package br.com.alugames.principal

import br.com.alugames.modelo.Gamer
import br.com.alugames.modelo.Jogo
import br.com.alugames.servico.ConsumoApi
import br.com.alugames.utilitario.transformarEmIdade
import java.util.*

fun main() {
    println("Hello world!")
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluido. Dados do gamer: $gamer")
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite o ID para buscar o jogo: ")
        val busca = leitura.nextLine()
        val buscaApi = ConsumoApi()
        val informaJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(informaJogo.info.title, informaJogo.info.thumb)
        }

        resultado.onFailure {
            println("ID inválido, tente novamente")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? - S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição para o jogo.")
                val descricaoText = leitura.nextLine()
                meuJogo?.descricao = descricaoText
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar um novo jogo? [S/N]")

        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por titulo")
    gamer.jogosBuscados.sortBy{it?.titulo}
    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("Batman", true) ?: false
    }

    println("Jogos do batman: $jogosFiltrados")

    println("Deseja excluir algum jogo da lista original?")
    val opcao = leitura.nextLine()
    if(opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("Informe a posição do jogo que deseja excluir:")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("Lista atualizada:")
    println("Jogos buscados: ${gamer.jogosBuscados}")

    println("Busca finalizada com sucesso.")
}

