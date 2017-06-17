package se.joelabs.fluttercookie.domain

import org.scalamock.scalatest.MockFactory
import org.scalatest._


class UserBehaviourFeature extends FeatureSpec with GivenWhenThen with MockFactory with Matchers {

  info("As a developer")
  info("I want to be able to create MongoDB entities using scala case classes")
  info("So that I can leverage of the scala language features related to case classes")

  feature("Case classes as MongoDB entities") {
    scenario("Use case class in match statement") {

      Given("an entity exists")
//      val banan: UserBehaviour = UserBehaviour(color = "yellow")

      When("matching entity")
//      val color = banan match {
//        case UserBehaviour(_, c) =>
//          c
//        case _ =>
//          "red"
//      }

      Then("matching works")
//      color shouldBe "yellow"
//      banan.color shouldEqual color
    }
  }
}
