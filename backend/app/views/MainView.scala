package views

import scalatags.Text._
import scalacss.Defaults._
import scalacss.ScalatagsCss._

import shared.styles.MainStyle

object MainView {

  import scalatags.Text.all._
  import scalatags.Text.tags2.title

  def apply(content: Seq[Modifier], pageTitle: String)(implicit env: play.Environment) =
    html(
      head(
        title(pageTitle),
        link(rel := "stylesheet", href := "assets/stylesheets/bootstrap.min.css"),
        MainStyle.render[scalatags.Text.TypedTag[String]]
      ),
      body(
        content,
        scripts("frontend")
      )
    )

  def scripts(projectName: String)(implicit env: play.Environment) = Seq(selectScript(projectName), launcher(projectName))

  def selectScript(projectName: String)(implicit env: play.Environment): TypedTag[String] =
    if (env.isProd)
      script(src := s"/assets/${projectName.toLowerCase}-opt.js", `type` := "text/javascript")
    else
      script(src := s"/assets/${projectName.toLowerCase}-fastopt.js", `type` := "text/javascript")

  def launcher(projectName: String) =
    script(src := s"/assets/${projectName.toLowerCase}-launcher.js", `type` := "text/javascript")

}
