package br.com.alugames.dados

import br.com.alugames.modelo.Jogo
import br.com.alugames.utilitario.toEntity
import br.com.alugames.utilitario.toModel
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager) : DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

  override fun toEntity(objeto: Jogo): JogoEntity {
    return objeto.toEntity()
  }

  override fun toModel(entity: JogoEntity): Jogo {
    return entity.toModel()
  }
}