package se.joelabs.fluttercookie.infrastructure.jpa

import java.util
import javax.persistence._

import se.joelabs.fluttercookie.domain.{Permission, User, UserRole}

import scala.annotation.meta.field
import scala.collection.JavaConverters._

@Entity
@Table(name = "USER_ROLE")
private[infrastructure] class UserRoleJPA extends UserRole {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "ID")
  private var id: Long = _
  @(Column@field)(name = "NAME", unique = true)
  private var name: String = _
  @(ManyToMany@field)(mappedBy = "userRoles")
  private var users: java.util.List[UserJPA] = new util.ArrayList
  @(OneToMany@field)(mappedBy = "userRole")
  private var permissions: java.util.List[PermissionJPA] = new util.ArrayList

  def getId = id

  def getName = name

  def getUsers: Seq[User] = users.asScala

  def getPermissions: Seq[Permission] = permissions.asScala

}