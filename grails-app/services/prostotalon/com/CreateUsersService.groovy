package prostotalon.com

import prostotalon.com.admin.*

class CreateUsersService {
    static transactional = false

    void createUsers() {
        def roles = ['ROLE_ADMIN','ROLE_USER','ROLE_AGENT']
        for (it in roles) {
           def role = new SecRole(authority: it).save(flush: true)
        }

        def adminUser = new SecUser(username: 'prostotalon.com', enabled: true, password: 'prostotalon.com')
        adminUser.save(flush: true)

        SecUserSecRole.create adminUser, SecRole.findByAuthority('ROLE_ADMIN'), true
    }

    void dropAllUsers(){
        SecUserSecRole.removeAll()
        SecUser.executeUpdate('delete from SecUser')
        SecRole.executeUpdate('delete from SecRole')
    }

}
