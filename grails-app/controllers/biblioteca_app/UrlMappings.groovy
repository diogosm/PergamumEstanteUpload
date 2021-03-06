package biblioteca_app

class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/estante/upload"(controller:"estante", action: "upload", method: "POST")
        "/estante/list"(controller:"estante", action: "list", method: "POST")
        "/estante/delete/$arquivo"(controller:"estante", action: "deletar", method: "POST")
    }
}
