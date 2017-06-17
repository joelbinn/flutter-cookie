package se.joelabs.fluttercookie.infrastructure.jpa

import javax.persistence._

import se.joelabs.fluttercookie.domain.{Permission, Resource, UserRole}

import scala.annotation.meta.field

@Entity
@Table(name = "PERMISSION")
class PermissionJPA(resourceJPA: ResourceJPA, userRoleJPA: UserRoleJPA) extends Permission {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "ID")
  private var id: Long = _
  @(ManyToOne@field)
  @(JoinColumn@field)(name = "RESOURCE")
  private var resource: ResourceJPA = _
  @(ManyToOne@field)
  @(JoinColumn@field)(name = "USERROLE")
  private var userRole: UserRoleJPA = _
  @(Column@field)(name = "WRITABLE")
  private var writable: Boolean = _

  def getResource: Resource = resource

  def getUserRole: UserRole = userRole

  def isWritable: Boolean = writable

  def grantWriteAccess(writable: Boolean) {
    this.writable = writable
  }

  private def this() = this(null, null)
}
