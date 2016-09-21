import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SorterAppSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg"""), WhiteList("""(.*)localhost(.+)"""))

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://localhost:8080"

	val scn = scenario("SorterAppSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(9)
		.exec(http("request_1")
			.get("/?count=15000")
			.headers(headers_1))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}