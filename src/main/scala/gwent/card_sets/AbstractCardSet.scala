package cl.uchile.dcc
package gwent.card_sets

import gwent.cards.Card

import java.util.Objects


abstract class AbstractCardSet() extends isCardSet with Equals {
  protected val length: Int  = 25
  protected var cardArray: Array[Card] = new Array[Card](length)
  protected var numberOfCards: Int = 0
  def getArray: Array[Card] = cardArray

  def getNumberOfCards: Int = numberOfCards

  def this(array: Array[Card]) = {
    this()
    if (array.length <= length) {
      for (i <- array.indices) {
        cardArray(i) = array(i)
        numberOfCards += 1
      }
    }
  }
  
  def isIncluded(card: Card): Boolean = {
    var i: Int = 0
    var bool: Boolean = false
    while (i < numberOfCards && ! bool) {
      if (cardArray(i).equals(card)) {bool = true}
      i += 1
    }
    bool
  }

  def add(card: Card): Unit = {
    if (numberOfCards < length) {
      cardArray(numberOfCards) = card
      numberOfCards += 1
    }
    else {
      println("Card Set is already full")
    }
  }

  def add(otherArray: Array[Card]): Unit = {
    if (otherArray.length <= (length - numberOfCards)) {
      for (i <- otherArray.indices) {
        cardArray(numberOfCards) = otherArray(i)
        numberOfCards += 1
      }
    }
    else {
      println("Array doesn't fit in the Card Set")
    }
  }

  def remove(card: Card): Unit = {
    var i: Int = 0
    var break: Boolean = false
    while (i <= numberOfCards && !break) {
      if (i < numberOfCards) {
        if (cardArray(i).equals(card)) {
          for (j <- i until numberOfCards) {
            cardArray(j) = cardArray(j + 1)
          }
        }
        numberOfCards -= 1
        cardArray(numberOfCards) = null
        break = true
      }
      i += 1
    }
    if (!break) {
      println("Card was not found on the Card Set")
    }
  }
}
