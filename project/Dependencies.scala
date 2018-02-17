import sbt._

object Dependencies {

  // versions
  lazy val log4jVersion = "2.10.0"
  lazy val log4jScalaVersion = "11.0"
  lazy val scalaTestVersion = "3.0.4"

  // libraries
  val log4jCore = "org.apache.logging.log4j" % "log4j-core" % log4jVersion
  val log4jApi = "org.apache.logging.log4j" % "log4j-api" % log4jVersion
  val log4jScala = "org.apache.logging.log4j" %% "log4j-api-scala" % log4jScalaVersion
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test

  // projects
  val commonDependencies =
    Seq( log4jCore, log4jApi, log4jScala, scalaTest )

}