package br.com.alugames.dados

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(protected val maneger: EntityManager, protected val entityType: Class<TEntity>) {
  abstract fun toEntity(objeto: TModel): TEntity
  abstract fun toModel(entity: TEntity): TModel

  open fun getLista(): List<TModel> {
    val query = maneger.createQuery("FROM ${entityType.simpleName}", entityType)
    return query.resultList.map { entity -> toModel(entity) }
  }

  open fun adicionar(objeto: TModel){
    val entity = toEntity(objeto)
    maneger.transaction.begin()
    maneger.persist(entity)
    maneger.transaction.commit()
  }

  open fun recuperarPeloId(id: Int):TModel{
    val query = maneger.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
    query.setParameter("id", id)
    val entity = query.singleResult
    return toModel(entity)
  }

  open fun apagar(id:Int) {
    val query = maneger.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
    query.setParameter("id", id)
    val entity = query.singleResult
    maneger.transaction.begin()
    maneger.remove(entity)
    maneger.transaction.commit()
  }


}