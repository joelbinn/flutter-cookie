package se.joelabs.fluttercookie.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import se.joelabs.fluttercookie.domain.Resource

trait ResourceRepo extends PagingAndSortingRepository[ResourceJPA, java.lang.Long] with JpaRepository[ResourceJPA, java.lang.Long] {
  def findByUri(uri: String): Resource
}
