package se.joelabs.fluttercookie.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._
import se.joelabs.fluttercookie.application.UserService
import se.joelabs.fluttercookie.domain.User


@RestController
class UserServiceRestController {
  @Autowired
  private var userService: UserService = _

  @RequestMapping(Array("/users/has-write-access"))
  def hasWriteAccess(@RequestParam("signum") signum: String, @RequestParam("resource-uri") resourceUri: String) =
    userService.hasWriteAcess(signum, resourceUri)

  @RequestMapping(path = Array("/users"), method = Array(RequestMethod.GET))
  def getAllUSers(): Seq[User] =
    userService.getUsers()

  @RequestMapping(path = Array("/userrole/{name}/grantaccess"), method = Array(RequestMethod.POST))
  def grantUserRoleAccess(@PathVariable name: String, @RequestParam("resource-uri") resourceUri: String, @RequestParam("write-access") writeAccess: Boolean) {
    userService.grantUserRoleAccessToResource(name, resourceUri, writeAccess)
  }

  @RequestMapping(path = Array("/users"), method = Array(RequestMethod.POST))
  def createUser(@RequestParam("signum") signum: String, @RequestParam("first-name") firstName: String, @RequestParam("last-name") lastName: String): User =
    userService.createUser(signum, firstName, lastName)
}
