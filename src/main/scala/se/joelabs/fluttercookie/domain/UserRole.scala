package se.joelabs.fluttercookie.domain

import java.util

import scala.collection.JavaConverters._

class UserRole {
  private var _id: java.lang.Long = null.asInstanceOf[java.lang.Long]
  private var _name: String = _
  private var _users: util.List[User] = new util.ArrayList()
  private var _permissions: util.List[Permission] = new util.ArrayList()

  def name = _name

  def users = _users.asScala

  def permissions = _permissions.asScala
}
