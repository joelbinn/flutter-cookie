package se.joelabs.fluttercookie.domain

trait User {
  def getSignum: String

  def getFirstName: String

  def getLastName: String

  def getUserRoles: Seq[UserRole]
}

case class UserBehaviour(user: User) {
  def hasWriteAccess(uri: String): Boolean = user.getUserRoles
    .flatMap(ur => ur.getPermissions)
    .filter(_.isWritable)
    .exists(p => p.getResource.getUri == uri)

  def hasRole(role: UserRole): Boolean = user.getUserRoles.contains(role)
}

object User {
  implicit def toUser(user: User): UserBehaviour = UserBehaviour(user)
}
