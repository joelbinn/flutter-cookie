package se.joelabs.fluttercookie.infrastructure.jpa

import java.util
import javax.persistence._

import se.joelabs.fluttercookie.domain.{User, UserRole}

import scala.annotation.meta.field
import scala.collection.JavaConverters._

@Entity
@Table(name = "USER")
private[infrastructure] class UserJPA(_signum: String, _firstName: String, _lastName: String) extends User {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "ID")
  private var id: Long = _
  @(Column@field)(name = "SIGNUM", unique = true)
  private var signum: String = _signum
  @(Column@field)(name = "FIRST_NAME")
  private var firstName: String = _firstName
  @(Column@field)(name = "LAST_NAME")
  private var lastName: String = _lastName
  @(ManyToMany@field)
  @(JoinTable@field)(name = "USER_TO_USERROLE",
    joinColumns = Array(new JoinColumn(name = "USER")),
    inverseJoinColumns = Array(new JoinColumn(name = "USERROLE"))
  )
  private var userRoles: java.util.List[UserRoleJPA] = new util.ArrayList[UserRoleJPA]

  def getSignum = signum

  def getFirstName = firstName

  def getLastName = lastName

  def getId = id

  def getUserRoles: Seq[UserRole] = userRoles.asScala

  private def this() = this(null, null, null)
}

