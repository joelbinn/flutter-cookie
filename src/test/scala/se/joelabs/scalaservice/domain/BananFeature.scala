package se.joelabs.scalaservice.domain

import org.scalamock.scalatest.MockFactory
import org.scalatest._


class BananFeature extends FeatureSpec with GivenWhenThen with MockFactory with Matchers {

  info("As a developer")
  info("I want to be able to create MongoDB entities using scala case classes")
  info("So that I can leverage of the scala language features related to case classes")

  feature("Case classes as MongoDB entities") {
    scenario("Use case class in match statement") {

      Given("an entity exists")
      val banan: Banan = Banan(color = "yellow")

      When("matching entity")
      val color = banan match {
        case Banan(_, c) =>
          c
        case _ =>
          "red"
      }

      Then("matching works")
      color shouldBe "yellow"
      banan.color shouldEqual color
    }
  }
}
