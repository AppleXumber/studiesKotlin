package br.com.alugames.dados

import br.com.alugames.modelo.Gamer
import javax.persistence.EntityManager
/*
class GamerDao(maneger: EntityManager) : DAO<Gamer, GamerEntity>(maneger, GamerEntity::class.java) {
  override fun toModel(entity: GamerEntity): Gamer {
    return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario)
  }

  override fun toEntity(objeto: Gamer): GamerEntity {
    return GamerEntity(objeto.nome, objeto.email, objeto.dataNascimento, objeto.usuario)
  }
}*/