name := "SoulmatesAnonymiser"

scalaVersion := "2.9.0-1"

libraryDependencies ++= Seq(
  "com.mongodb.casbah" %% "casbah" % "2.1.5.0",
  "org.slf4j" % "slf4j-api" % "1.6.1",
  "org.slf4j" % "slf4j-simple" % "1.6.1",
  "org.scalatest" %% "scalatest" % "1.6.1" % "test"
)


retrieveManaged := true