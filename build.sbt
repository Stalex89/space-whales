name := """edukacja2-v1"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

routesGenerator := InjectedRoutesGenerator

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
// resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  guice,
  javaJdbc,
  cacheApi,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.6.3",
  "org.webjars" % "bootstrap" % "4.0.0-1",
  "org.webjars" % "jquery" % "3.3.1-1",
  "org.webjars" % "font-awesome" % "5.0.6",
  "com.h2database" % "h2" % "1.4.192",
  "com.adrianhurt" %% "play-bootstrap" % "1.4-P26-B4-SNAPSHOT"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

fork in run := true

includeFilter in (Assets, LessKeys.less) := "footer.less"