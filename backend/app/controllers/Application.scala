package controllers

import play.api.mvc._
import javax.inject.Inject

import play.api.http.ContentTypes
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import views.{IndexView, MainView}

import scalatags.Text

class Application @Inject()(implicit env: play.Environment, val messagesApi: MessagesApi)  extends Controller with  I18nSupport {

  val appName = "Play & ScalaJS"

  def index = ok(IndexView(Messages("hello", appName)))

  def ok(view: Seq[Text.TypedTag[String]]) = Action {
    implicit val codec = Codec.utf_8
    Ok(MainView(view, appName).toString).as(ContentTypes.HTML)
  }

}
