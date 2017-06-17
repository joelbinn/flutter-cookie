package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import se.joelabs.fluttercookie.domain.User

/**
  * A repository for users.
  */
@Bean
trait UserRepo extends PagingAndSortingRepository[UserJPA, java.lang.Long] with JpaRepository[UserJPA, java.lang.Long] {
  def createUser(signum: String, firstName: String, lastName: String): User = {
    val user = new UserJPA(signum, firstName, lastName)
    save(user)
    user
  }

  def findBySignum(@Param("signum") signum: String): User

  def findById(@Param("id") id: String): User
}
