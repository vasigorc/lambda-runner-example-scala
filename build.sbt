import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "ca.vgorcinschi"
ThisBuild / organizationName := "vgorcinschi"

lazy val mainClass = "ca.vgorcinschi.lambdarunner.app.LambdaRunnerApp"

lazy val root = (project in file("."))
  .settings(
    name := "lambda-runner-example-scala",
    libraryDependencies ++= compileDependencies ++ testDependencies
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
