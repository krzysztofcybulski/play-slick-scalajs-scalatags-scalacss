package controllers

import play.api.mvc._
import javax.inject.Inject

import play.api.http.ContentTypes
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import views.{IndexView, MainView}
import shared.SharedMessages

import scalatags.Text

class Application @Inject()(implicit env: play.Environment, val messagesApi: MessagesApi)  extends Controller with  I18nSupport {

  def index = ok(IndexView(Messages("hello", SharedMessages.title)))

  def ok(view: Seq[Text.TypedTag[String]]) = Action {
    implicit val codec = Codec.utf_8
    Ok(MainView(view, SharedMessages.title).toString).as(ContentTypes.HTML)
  }

}
