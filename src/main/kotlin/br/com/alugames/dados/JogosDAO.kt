package br.com.alugames.dados

import br.com.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(maneger: EntityManager): DAO<Jogo, JogoEntity>(maneger, JogoEntity::class.java) {
  override fun toEntity(objeto: Jogo) : JogoEntity {
    return JogoEntity(objeto.titulo, objeto.capa, objeto.preco, objeto.descricao, objeto.id)
  }

  override fun toModel(entity: JogoEntity): Jogo {
    return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
  }
}