class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/apiUser/$id"(controller: "apiUser") {
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}
		
		"/customer/$id"(controller: "customer", parseRequest: true) {
			action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
