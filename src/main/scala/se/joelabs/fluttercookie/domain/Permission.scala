package se.joelabs.fluttercookie.domain

trait Permission {
  def grantWriteAccess(writable: Boolean)

  def isWritable: Boolean

  def getResource: Resource

  def getUserRole: UserRole
}

case class PermissionBehaviour(permission: Permission)

object Permission {
  implicit def toPermissionBehaviour(permission: Permission): PermissionBehaviour = PermissionBehaviour(permission)
}