package br.com.alugames.utilitario

import br.com.alugames.dados.PlanoAssinaturaEntity
import br.com.alugames.dados.PlanoAvulsoEntity
import br.com.alugames.dados.PlanoEntity
import br.com.alugames.modelo.Plano
import br.com.alugames.modelo.PlanoAssinatura
import br.com.alugames.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}