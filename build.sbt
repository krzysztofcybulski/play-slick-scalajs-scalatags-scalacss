name          := "Play and ScalaJS"
organization  := "foo.playscalajs"
version       := "0.1-SNAPSHOT"

import sbt.Project.projectToRef
import sbt.Keys.libraryDependencies

import Dependencies._

lazy val versionOfScala = "2.11.11"

lazy val backend = (project in file("backend")).settings(
  scalaVersion := versionOfScala,
  scalaJSProjects := Seq(frontend),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,
  libraryDependencies ++= backendDeps.value
).enablePlugins(PlayScala)
  .dependsOn(sharedJvm)

lazy val frontend = (project in file("frontend")).settings(
  scalaVersion := versionOfScala,
  scalaJSUseMainModuleInitializer := true,
  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  libraryDependencies ++= frontendDeps.value
).enablePlugins(ScalaJSPlugin, ScalaJSWeb)
  .dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(
    scalaVersion := versionOfScala,
    libraryDependencies ++= sharedDeps.value
  ).jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

onLoad in Global := (Command.process("project backend", _: State)) compose (onLoad in Global).value