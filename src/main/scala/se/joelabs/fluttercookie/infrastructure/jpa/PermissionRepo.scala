package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.{Permission, Resource, UserRole}

trait PermissionRepo extends PagingAndSortingRepository[Permission, java.lang.Long] with JpaRepository[Permission, java.lang.Long] {
  def createPermission(userRole: UserRole, resource: Resource): Permission = {
    val permission = new Permission(userRole, resource)
    save(permission)
    permission
  }
}
