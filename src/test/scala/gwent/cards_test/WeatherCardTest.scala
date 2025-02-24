package cl.uchile.dcc
package gwent.cards_test

import munit.FunSuite
import gwent.cards.{Card, WeatherCard}

import cl.uchile.dcc.gwent.board.Board
import cl.uchile.dcc.gwent.cards.unit_cards.CloseCombatCard
import cl.uchile.dcc.gwent.effects.weather_effects.{BitingFrost, ClearWeather, TorrentialRain, WeatherEffect}
import cl.uchile.dcc.gwent.player.Player

import scala.collection.mutable.ListBuffer

class WeatherCardTest extends FunSuite {
  var card1: WeatherCard = null
  var card2: WeatherCard = null
  var card3: WeatherCard = null
  var effect1: WeatherEffect = null
  var effect2: WeatherEffect = null
  var effect3: WeatherEffect = null
  var board: Board = null
  var player: Player = null
  var deck: ListBuffer[Card] = null
  var hand: ListBuffer[Card] = null
  override def beforeEach(context: BeforeEach): Unit = {
    effect1 = new BitingFrost
    effect2 = new BitingFrost
    effect3 = new TorrentialRain
    board = new Board
    deck = new ListBuffer[Card]
    hand = new ListBuffer[Card]
    card1 = new WeatherCard("Weather Report", effect1)
    card2 = new WeatherCard("Weather Report", effect2)
    card3 = new WeatherCard("Jodio Joestar", effect3)
    hand += card1
    player = new Player("Amogus", board, deck, hand)
  }

  test("If a weather card is played, it should be put into its proper section") {
    player.playCard(card1)
    assert(board.weatherSection.contains(card1))
  }

  test("The equals method works properly") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
  }

  test("The hashCode method works properly") {
    assertEquals(card1.##, card2.##)
    assertNotEquals(card1.##, card3.##)
  }
}
