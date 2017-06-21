package se.joelabs.fluttercookie.infrastructure.jpa

import java.sql.Date

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}
import se.joelabs.fluttercookie.domain.CompoundAttribute

class CompoundAttributeConverterTest extends FunSpec with Matchers with MockitoSugar with BeforeAndAfter {
  describe ("CompoundAttributeConverter") {
    it("should convert a CompoundAttribute to a YAML and back") {
      val yaml = bananConverter.convertToEntityAttribute(banan)
      val newBanan = bananConverter.convertToDatabaseColumn(yaml)
      newBanan should equal (banan)
    }
  }

  before {
    banan = new CompoundAttribute(List("Kalle","Banan"), Map("Bogga" -> new Date(123L), "Bilbo" -> new Date(9999L)))
  }
  private var banan: CompoundAttribute = _
  private var bananConverter: CompoundAttributeConverter = new CompoundAttributeConverter
}
