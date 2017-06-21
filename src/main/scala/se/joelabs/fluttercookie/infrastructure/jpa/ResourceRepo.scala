package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.Resource

trait ResourceRepo extends PagingAndSortingRepository[Resource, java.lang.Long] with JpaRepository[Resource, java.lang.Long] {
  def findBy_uri(uri: String): Resource
}
