package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.UserRole

trait UserRoleRepo extends PagingAndSortingRepository[UserRoleJPA, java.lang.Long] with JpaRepository[UserRoleJPA, java.lang.Long] {
  def findByName(name: String): UserRole
}
