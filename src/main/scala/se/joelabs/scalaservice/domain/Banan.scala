package se.joelabs.scalaservice.domain

import org.springframework.data.annotation.Id

import scala.annotation.meta.field

case class Banan(
  @(Id@field)
  id: String = null,
  color: String = null
) {
  def this() = this(null, null)
}
