name := "josephus-problem"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val log4jVersion = "2.7"
  Seq(
    "com.github.scopt" %% "scopt" % "3.5.0",
    "org.apache.logging.log4j" % "log4j-api" % log4jVersion,
    "org.apache.logging.log4j" % "log4j-core" % log4jVersion,
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % log4jVersion,
    "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
  )
}
    