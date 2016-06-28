package biblioteca_app


class EstanteInterceptor {

    boolean before() {
	def cliente    = request.getHeader("User-Agent")
        def ip         = request.getRemoteAddr()

	//IP do Ecampus
	println "IP_ECAMPUS = ${ip}"
	if(ip!='200.129.163.9')
	    return false
	return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
