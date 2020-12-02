ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organizationName := "mharlin"

lazy val root = (project in file("."))
  .settings(
    name := "adventOfCode2020",
    libraryDependencies ++= {
      Seq(
        "org.scalatest" %% "scalatest" % "3.2.2" % Test
      )
    }
  )
