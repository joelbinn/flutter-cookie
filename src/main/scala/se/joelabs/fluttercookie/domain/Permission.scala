package se.joelabs.fluttercookie.domain

class Permission(pUserRole: UserRole, pResource: Resource) {
  private var _id: java.lang.Long = null.asInstanceOf[java.lang.Long]
  private var _writable: Boolean = true
  private var _resource: Resource = pResource
  private var _userRole: UserRole = pUserRole

  def grantWriteAccess(writable: Boolean) {
    _writable = writable
  }

  def isWritable: Boolean = _writable

  def resource = _resource

  def userRole = _userRole

  private def this() = this(null, null)
}
