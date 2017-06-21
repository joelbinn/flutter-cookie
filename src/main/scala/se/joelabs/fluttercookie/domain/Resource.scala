package se.joelabs.fluttercookie.domain

import java.util

import scala.collection.JavaConverters._

class Resource {
  private var _id: java.lang.Long = null.asInstanceOf[java.lang.Long]
  private var _name: String = _
  private var _uri: String = _
  private var _permissions: java.util.List[Permission] = new util.ArrayList()

  def name = _name

  def uri = _uri

  def permissions = _permissions.asScala
}
