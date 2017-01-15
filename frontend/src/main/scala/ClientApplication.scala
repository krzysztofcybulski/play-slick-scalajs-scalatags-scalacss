import scala.scalajs.js
import org.scalajs.dom
import shared.styles.MainStyle

import scalacss.ScalatagsCss._

object ClientApplication extends js.JSApp {

  import scalatags.JsDom.all._

  def main(): Unit =
    dom.document.getElementById("scalajsclientDiv")
      .appendChild(a(href := "https://www.scala-js.org/")(
        img(MainStyle.homeImg)(src := "assets/images/scalajs.png")
      ).render)

}
