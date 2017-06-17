package se.joelabs.fluttercookie.infrastructure.jpa

import java.util
import javax.persistence._

import se.joelabs.fluttercookie.domain.{Permission, Resource}

import scala.annotation.meta.field
import scala.collection.JavaConverters._

@Entity
@Table(name = "RESOURCE")
private[infrastructure] class ResourceJPA extends Resource {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "ID")
  private var id: Long = _
  @(Column@field)(name = "NAME", unique = true)
  private var name: String = _
  @(Column@field)(name = "URI", unique = true)
  private var uri: String = _
  @(ManyToMany@field)(mappedBy = "resource")
  private var permissions: java.util.List[PermissionJPA] = new util.ArrayList

  def getName = name

  def getUri = uri

  def getId = id

  def getPermissions: Seq[Permission] = permissions.asScala
}


