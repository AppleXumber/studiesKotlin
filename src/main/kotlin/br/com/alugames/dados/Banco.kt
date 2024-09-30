package br.com.alugames.dados

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {
  /*fun obterConexao(): Connection? {
    return try {
      DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/alugames",
        "root",
         System.getenv("DB_PASSWORD")
      )
    } catch (e: SQLException) {
      e.printStackTrace()
      null
    }
  }*/

  fun getEntityManager(): EntityManager {
    val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")
    return factory.createEntityManager()
  }

}