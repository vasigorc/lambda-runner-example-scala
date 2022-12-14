import sbt._

object Dependencies {

  lazy val awsSdkVersion = "2.18.0"
  lazy val logbackVersion = "1.2.11"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.11"

  val compileDependencies: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "com.softwaremill.macwire" % "macros_2.13" % "2.5.8",
    "com.typesafe" % "config" % "1.4.2",
    "software.amazon.awssdk" % "auth" % awsSdkVersion,
    "software.amazon.awssdk" % "lambda" % awsSdkVersion
  )

  val testDependencies: Seq[ModuleID] = Seq(scalaTest % Test)
}
