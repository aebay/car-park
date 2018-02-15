import sbt._

object Dependencies {

  // versions
  lazy val scalaTestVersion = "3.0.4"

  // libraries
  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % Test

  // projects
  val commonDependencies =
    Seq( scalaTest )

}