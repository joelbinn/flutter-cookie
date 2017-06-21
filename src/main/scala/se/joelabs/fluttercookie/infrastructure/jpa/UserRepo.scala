package se.joelabs.fluttercookie.infrastructure.jpa

import java.sql.Date

import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import se.joelabs.fluttercookie.domain.{CompoundAttribute, User}

/**
  * A repository for users.
  */
@Bean
trait UserRepo extends PagingAndSortingRepository[User, java.lang.Long] with JpaRepository[User, java.lang.Long] {
  def createUser(signum: String, firstName: String, lastName: String): User = {
    val user = new User(signum, firstName, lastName, null, new CompoundAttribute(List("Banan", "Bulle"), Map("ZZUPP" -> new Date(2017,6, 21))))
    save(user)
    user
  }

  def findBy_signum(@Param("signum") signum: String): User
}
