package shared.styles

import scalacss.Defaults._

object Bootstrap extends StyleSheet.Inline {
  import dsl._

  val row = style(addClassName("row"))

}
