package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

trait isPlayer{
  def playCard(card: Card): Unit
  def drawCard(): Unit
  def shuffle(): Unit
}
