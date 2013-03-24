import prostotalon.com.CreateUsersService
import prostotalon.com.admin.*
import grails.util.GrailsUtil

class BootStrap {
    def createUsersService

    def init = { servletContext ->
        switch (GrailsUtil.environment) {
            case "development":
                createUsersService.dropAllUsers()
                createUsersService.createUsers()
                break
            case "test":

                break
            case "production":

                break
        }
    }
    def destroy = {
    }
}
