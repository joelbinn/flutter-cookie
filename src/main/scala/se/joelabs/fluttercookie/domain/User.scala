package se.joelabs.fluttercookie.domain

import java.util

import com.fasterxml.jackson.annotation.JsonGetter

import scala.collection.JavaConverters._

class User(pSignum: String, pFirstName: String, pLastName: String, pCompundAttribute: CompoundAttribute, pExtra: CompoundAttribute = null) {
  private var _signum: String = pSignum
  private var _firstName: String = pFirstName
  private var _lastName: String = pLastName
  private var _userRoles: java.util.List[UserRole] = new util.ArrayList()
  private var _extra: CompoundAttribute = pExtra

  @JsonGetter
  def signum = _signum

  @JsonGetter
  def firstName = _firstName

  @JsonGetter
  def lastName = _lastName

  @JsonGetter
  def extra = _extra

  def hasWriteAccess(uri: String): Boolean = userRoles
    .flatMap(ur => ur.permissions)
    .filter(_.isWritable)
    .exists(p => p.resource.uri == uri)

  def userRoles = _userRoles.asScala

  def hasRole(role: UserRole): Boolean = userRoles.contains(role)

  private def this() = this(null, null, null, null, null)
}
