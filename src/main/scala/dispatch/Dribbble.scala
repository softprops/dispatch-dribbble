package dispatch.dribbble

import dispatch._
import json._
import JsHttp._

object Dribbble {

  val host = :/("api.dribbble.com")

  def page_map(page: Int, per_page: Int) = Map(
    "page" -> page,
    "per_page" -> per_page
  )

}
import Dribbble._

case class Shot(id: Long)
     extends Request(Dribbble.host / "shots" / id.toString) with Js {

  def rebounds(page: Int, per_page: Int) =
    this / "rebounds" <<? page_map(page, per_page)

  def comments(page: Int, per_page: Int) =
    this / "comments" <<? page_map(page, per_page)

}

object Shots extends Request(Dribbble.host / "shots") {

  def debuts(page: Int, per_page: Int) =
    this / "debuts" <<? page_map(page, per_page)

  def popular(page: Int, per_page: Int) =
    this / "popular" <<? page_map(page, per_page)

  def everyone(page: Int, per_page: Int) =
    this / "everyone" <<? page_map(page, per_page)

}

case class Player(name: String)
     extends Request(Dribbble.host / "players" / name) with Js {

  def shots(page: Int, per_page: Int) =
    this / "shots" <<? page_map(page, per_page)

  def shots_following(page: Int, per_page: Int) =
    this / "shots" / "following" <<? page_map(page, per_page)

  def shots_liked(page: Int, per_page: Int) =
    this / "shots" / "likes" <<? page_map(page, per_page)

  def followers(page: Int, per_page: Int) =
    this / "followers" <<? page_map(page, per_page)

  def following(page: Int, per_page: Int) =
    this / "following" <<? page_map(page, per_page)

  def draftees(page: Int, per_page: Int) =
    this / "draftees" << page_map(page, per_page)

}

object Player extends Js {
  val id = 'id ? num
  val name = 'name ? str
  val username = 'username ? str
  val url = 'url ? str
  val avatar_url = 'avatar_url ? str
  val location = 'location ? str
  val twitter_screen_name = 'twitter_screen_name ? str
  val drafted_by_player_id = 'drafted_by_player_id ? num
  val shots_count = 'shots_count ? num
  val draftees_count = 'draftees_count ? num
  val followers_count = 'followers_count ? num
  val comments_count = 'comments_count ? num
  val comments_recieved_count = 'comments_recieved_count ? num
  val likes_count = 'likes_count ? num
  val likes_recieved_count = 'likes_recieved_count ? num
  val rebounds_count = 'rebounds_count ? num
  val rebounds_recieved_count = 'rebounds_recieved_count ? num
  val created_at = 'created_at ? str
}

object Shot extends Js {
  val id = 'id ? num
  val title = 'title ? str
  val short_url = 'short_url ? str
  val image_url = 'image_url ? str
  val image_teaser_url = 'image_teaser_url ? str
  val width = 'width ? num
  val height = 'height ? num
  val views_count = 'views_count ? num
  val likes_count = 'likes_count ? num
  val comments_count = 'comments_count ? num
  val rebounds_count = 'rebounds_count ? num
  val rebound_source_id = 'rebound_source_id ? num
  val created_at = 'created_at ? str
}

trait Paginated extends Js {
  val page = 'page ? num
  val pages = 'pages ? num
  val per_page = 'per_page ? num
  val total = 'total ? num
}
