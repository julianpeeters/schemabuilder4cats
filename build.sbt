lazy val ApacheAvroV = "1.11.1"
lazy val CatsEffectV = "3.5.1"
lazy val MUnitCEV = "1.0.7"

ThisBuild / description := "A referentially transparent FFI to `org.apache.avro.SchemaBuilder`"
ThisBuild / organization := "com.julianpeeters"
ThisBuild / scalaVersion := "3.3.0"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / versionScheme := Some("semver-spec")

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-Werror",
    "-source:future",
    "-Wunused:all",
    "-Wvalue-discard"
  )
)

lazy val schemabuilder4cats = (project in file("."))
  .settings(
    commonSettings,
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
      "VERSION" -> version.value
    )
  )
  .dependsOn(schemabuilder4cats)
  .enablePlugins(MdocPlugin)