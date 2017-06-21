package se.joelabs.fluttercookie.domain

import java.sql.Date

import com.fasterxml.jackson.annotation.JsonProperty

import scala.collection.JavaConverters._

class CompoundAttribute(pNames: List[String] = Nil, pMap: Map[String, Date]) {
  def names = _names.asScala
  def map = _map.asScala

  @JsonProperty
  private var _names:java.util.List[String] = pNames.asJava
  @JsonProperty
  private var _map:java.util.Map[String, Date] = pMap.asJava
  private def this() = this(Nil, Map[String, Date]())


  def canEqual(other: Any): Boolean = other.isInstanceOf[CompoundAttribute]

  override def equals(other: Any): Boolean = other match {
    case that: CompoundAttribute =>
      (that canEqual this) &&
        _names == that._names
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(_names)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
