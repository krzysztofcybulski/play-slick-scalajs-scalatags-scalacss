import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Dependencies {

  val scalatagsVersion          = "0.6.2"
  val scalaCSSVersion           = "0.5.1"

  val playSlickVersion          = "1.1.0"
  val mysqlJavaConnectorVersion = "5.1.34"
  val scalaCSSScalaTagsVersion  = "0.5.1"

  val scalaJSdomVersion         = "0.9.1"

  val backendDeps =  Def.setting(Seq[ModuleID](
    "mysql"   % "mysql-connector-java"      % mysqlJavaConnectorVersion,
    "com.typesafe.play" %% "play-slick"     % playSlickVersion,
    "com.typesafe.play" %% "play-slick-evolutions" % playSlickVersion,
    "com.lihaoyi" %% "scalatags" % scalatagsVersion,
    "com.github.japgolly.scalacss" %% "core" % scalaCSSVersion,
    "com.github.japgolly.scalacss" %% "ext-scalatags" % scalaCSSScalaTagsVersion
  ))

  val frontendDeps = Def.setting(Seq[ModuleID](
    "org.scala-js" %%% "scalajs-dom" % scalaJSdomVersion,
    "com.lihaoyi" %%% "scalatags" % scalatagsVersion,
    "com.github.japgolly.scalacss" %%% "core" % scalaCSSVersion,
    "com.github.japgolly.scalacss" %%% "ext-scalatags" % scalaCSSScalaTagsVersion
  ))

  val sharedDeps = Def.setting(Seq[ModuleID](
    "com.github.japgolly.scalacss" %% "core" % scalaCSSVersion
  ))

  val jsDeps = Def.setting(Seq[org.scalajs.sbtplugin.JSModuleID](
  ))

}