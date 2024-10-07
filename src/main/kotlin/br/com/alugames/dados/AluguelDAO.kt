package br.com.alugames.dados

import br.com.alugames.modelo.Aluguel
import br.com.alugames.utilitario.toEntity
import br.com.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDAO(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.gamer.toEntity(), objeto.jogo.toEntity(), objeto.periodo)
            .apply { valorDoAluguel = objeto.valorDoAluguel
                id = objeto.id}
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id
            }
    }

}