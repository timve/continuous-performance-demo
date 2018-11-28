package simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SorterAppSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8080")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg"""), WhiteList("""(.*)localhost(.+)"""))
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("nl,en;q=0.7,en-US;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:63.0) Gecko/20100101 Firefox/63.0")

	val headers_0 = Map("Pragma" -> "no-cache")

	val scn = scenario("SorterAppSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_1")
			.get("/?count=15000")
			.headers(headers_0))

	setUp(scn.inject(rampUsers(300) during (5 seconds))).protocols(httpProtocol)
}