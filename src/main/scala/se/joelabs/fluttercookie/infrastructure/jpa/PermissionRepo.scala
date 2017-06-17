package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.{Permission, Resource, UserRole}

trait PermissionRepo extends PagingAndSortingRepository[PermissionJPA, java.lang.Long] with JpaRepository[PermissionJPA, java.lang.Long] {
  def createPermission(userRole: UserRole, resource: Resource): Permission = {
    val permission = new PermissionJPA(resource.asInstanceOf[ResourceJPA], userRole.asInstanceOf[UserRoleJPA])
    save(permission)
    permission
  }
}
