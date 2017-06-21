package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.UserRole

trait UserRoleRepo extends PagingAndSortingRepository[UserRole, java.lang.Long] with JpaRepository[UserRole, java.lang.Long] {
  def findBy_name(name: String): UserRole
}
