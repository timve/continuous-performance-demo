import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class MyFirstSimulation extends Simulation {

  val protocol = http
    .baseURL("http://www.google.nl")
    .userAgentHeader("Gatling @ JavaOne")

  val scn = scenario("My first test")
    .exec(
      http("main page")
        .get("/")
        .check(status.is(200))
    )
    .pause(1)
    .exec(
      http("search")
        .get("/search?q=gatling")
        .check(status.is(200))
        .check(regex("<title>gatling - .*</title>"))
    )

  setUp(scn.inject(rampUsers(1) over (10 seconds))).protocols(protocol)

}