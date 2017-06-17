package se.joelabs.fluttercookie.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import se.joelabs.fluttercookie.domain.User._
import se.joelabs.fluttercookie.domain.{Permission, User}
import se.joelabs.fluttercookie.infrastructure.jpa.{PermissionRepo, ResourceRepo, UserRepo, UserRoleRepo}

import scala.collection.JavaConverters._
import scala.util.Try

@Component
class UserService {
  @Autowired
  private var userRepo: UserRepo = _
  @Autowired
  private var resourceRepo: ResourceRepo = _
  @Autowired
  private var userRoleRepo: UserRoleRepo = _
  @Autowired
  private var permissionRepo: PermissionRepo = _

  def getUsers(): Seq[User] = userRepo.findAll().asScala

  def createUser(signum: String, firstName: String, lastName: String): User =
    userRepo.createUser(signum, firstName, lastName)

  def grantUserRoleAccessToResource(userRoleName: String, resourceUri: String, writePermission: Boolean): Unit = {
    Option(resourceRepo.findByUri(resourceUri))
      .orElse(throw new RuntimeException(s"Resource URI: $resourceUri could no be found"))
      .zip {
        Option(userRoleRepo.findByName(userRoleName))
          .orElse(throw new RuntimeException(s"User role: $userRoleName, could no be found"))
      }
      .headOption
      .foreach {
        case (resource, userRole) =>
          val permission: Permission = userRole.getPermissions
            .find(p => p.getResource.getUri == resourceUri)
            .getOrElse(permissionRepo.createPermission(userRole, resource))
          permission.grantWriteAccess(true)
      }
  }

  def hasWriteAcess(userSignum: String, resourceUri: String): Boolean =
    Try(userRepo.findBySignum(userSignum))
      .map(user => user.hasWriteAccess(resourceUri))
      .getOrElse(false)

}
