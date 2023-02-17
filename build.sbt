ThisBuild / scalaVersion     := "3.2.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "quill-2",
    resolvers ++= Seq(
      Resolver.mavenLocal,
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
    ),
    libraryDependencies ++= Seq(
      "io.getquill"          %% "quill-jdbc-zio" % "4.+",
      "org.postgresql"       %  "postgresql"     % "42.3.1",
      "org.slf4j"            % "slf4j-api" % "1.7.5",
      "org.slf4j"            % "slf4j-simple" % "1.7.5"
    )
  )
