ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "quill-2",
    libraryDependencies ++= Seq(
      "io.getquill"          %% "quill-jdbc-zio" % "3.12.0",
      "io.github.kitlangton" %% "zio-magic"      % "0.3.11",
      "org.postgresql"       %  "postgresql"     % "42.3.1"
    )
  )
