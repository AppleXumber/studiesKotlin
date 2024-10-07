package br.com.alugames.dados

import br.com.alugames.modelo.Plano
import br.com.alugames.modelo.PlanoAssinatura
import br.com.alugames.modelo.PlanoAvulso
import br.com.alugames.utilitario.toEntity
import br.com.alugames.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {
    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}