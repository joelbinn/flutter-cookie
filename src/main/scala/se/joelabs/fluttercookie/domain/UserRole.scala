package se.joelabs.fluttercookie.domain

trait UserRole {
  def getName: String

  def getUsers: Seq[User]

  def getPermissions: Seq[Permission]
}

case class UserRoleBehaviour(userRole: UserRole)

object UserRole {
  implicit def toUserRole(userRole: UserRole): UserRoleBehaviour = UserRoleBehaviour(userRole)
}