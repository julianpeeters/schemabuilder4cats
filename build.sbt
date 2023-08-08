lazy val ApacheAvroV = "1.11.1"
lazy val CatsEffectV = "3.5.1"
lazy val MUnitCEV = "1.0.7"

inThisBuild(List(
  crossScalaVersions := Seq(scalaVersion.value),
  description := "A referentially transparent FFI to `org.apache.avro.SchemaBuilder`",
  organization := "com.julianpeeters",
  homepage := Some(url("https://github.com/julianpeeters/schemabuilder4cats")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "julianpeeters",
      "Julian Peeters",
      "julianpeeters@gmail.com",
      url("http://github.com/julianpeeters")
    )
  ),
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-Werror",
    "-source:future",
    "-Wunused:all",
    "-Wvalue-discard"
  ),
  scalaVersion := "3.3.0",
  versionScheme := Some("semver-spec"),
))

lazy val schemabuilder4cats = (project in file("."))
  .settings(
    name := "schemabuilder4cats",
    libraryDependencies ++= Seq(
      // main
      "org.apache.avro" % "avro" % ApacheAvroV,
      "org.typelevel" %% "cats-effect" % CatsEffectV,
      // test
      "org.typelevel" %% "munit-cats-effect-3" % MUnitCEV % Test,
    )
  )

lazy val docs = project.in(file("docs/gitignored"))
  .settings(
    mdocOut := schemabuilder4cats.base,
    mdocVariables := Map(
      "AVRO" -> ApacheAvroV,
      "SCALA" -> crossScalaVersions.value.mkString(", "),
      "VERSION" -> version.value.takeWhile(_ != '+'),
    )
  )
  .dependsOn(schemabuilder4cats)
  .enablePlugins(MdocPlugin)
  .enablePlugins(NoPublishPlugin)