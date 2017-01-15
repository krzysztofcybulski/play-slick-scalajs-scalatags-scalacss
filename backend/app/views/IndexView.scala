package views

import shared.styles.{Bootstrap, MainStyle}

import scalacss.ScalatagsCss._

object IndexView {
  import scalatags.Text.all._

  def apply(title: String) = Seq(
    div(MainStyle.home)(
      h1(MainStyle.homeTitle)(title),
      div(Bootstrap.row)(
        div(MainStyle.homeImgContainer)(
          a(href := "https://www.playframework.com/")(img(MainStyle.homeImg)(src := "assets/images/play.png"))
        ),
        div(MainStyle.homeImgContainer)(id := "scalajsclientDiv")
      )
    )
  )

}
