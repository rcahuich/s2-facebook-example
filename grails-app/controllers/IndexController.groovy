import com.the6hours.example.FacebookUser
import com.the6hours.example.User
import grails.plugins.springsecurity.SpringSecurityService

class IndexController {

    SpringSecurityService springSecurityService

    def show() {
        //def model = [:]
        User user
        FacebookUser facebookUser
        if (springSecurityService.isLoggedIn()) {
            user = springSecurityService.currentUser
            facebookUser = FacebookUser.findByUser(user)
            log.debug("############### " + facebookUser.accessTokenExpires)
        }
        render (view: '/index', model: [user: user, facebookUser: facebookUser])
    }
}
