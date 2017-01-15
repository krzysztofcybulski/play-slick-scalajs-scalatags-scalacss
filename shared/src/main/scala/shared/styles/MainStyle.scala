package shared.styles

import scalacss.Defaults._

object MainStyle extends StyleSheet.Inline {
  import dsl._

  val homeTitle = style(
    textAlign.center
  )

  val home = style(
    width(400 px),
    margin.auto
  )

  val homeImgContainer = style(
    addClassName("col-md-6"),
    height(100 px)
  )

  val homeImg = style(
    position.absolute,
    margin.auto,
    height(100 px),
    left(0 px),
    right(0 px)
  )

}