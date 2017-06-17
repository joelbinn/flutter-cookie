package se.joelabs.fluttercookie.domain

trait Resource {
  def getName: String

  def getUri: String

  def getPermissions: Seq[Permission]
}

case class ResourceBehaviour(resource: Resource)

object Resource {
  implicit def toResource(resource: Resource): ResourceBehaviour = ResourceBehaviour(resource)
}
