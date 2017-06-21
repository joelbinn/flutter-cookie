package se.joelabs.fluttercookie.infrastructure.jpa

import javax.persistence.AttributeConverter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import se.joelabs.fluttercookie.domain.CompoundAttribute

class CompoundAttributeConverter extends AttributeConverter[CompoundAttribute, String] {
  private val mapper = new ObjectMapper(new YAMLFactory)


  override def convertToEntityAttribute(dbData: String): CompoundAttribute =
    Option(dbData)
      .map(s => mapper.readValue(s, classOf[CompoundAttribute]))
      .orNull


  override def convertToDatabaseColumn(attribute: CompoundAttribute): String =
    Option(attribute)
      .map(d => mapper.writeValueAsString(d))
      .orNull
}
