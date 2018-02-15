import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.12.4",
  scalaBinaryVersion := "2.12"
)

lazy val root = (project in file("."))
  .settings(
    name := "car-park",
    commonSettings,
    //mainClass in Compile := Some("org.aeb.uk.carpark.Driver"),
    libraryDependencies ++= commonDependencies
  )

assemblyMergeStrategy in assembly := {
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}