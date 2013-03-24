class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')

        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")

        "/authentication" {
            controller = "login"
            action = "auth"
        }

        "/logout" {
            controller = "logout"
            action = "index"
        }
	}
}
