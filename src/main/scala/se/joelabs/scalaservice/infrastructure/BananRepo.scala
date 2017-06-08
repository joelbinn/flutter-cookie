package se.joelabs.scalaservice.infrastructure

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import se.joelabs.scalaservice.domain.Banan

/**
 * A repository of banan entities.
 */
trait BananRepo extends MongoRepository[Banan, java.lang.Long] {

  def findByColor(@Param("color") color: String): java.util.List[Banan]

  def findById(id: String): Banan
}
