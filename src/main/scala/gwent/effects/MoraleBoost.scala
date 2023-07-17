package cl.uchile.dcc
package gwent.effects
import gwent.cards.unit_cards.{AbstractUnitCard, CloseCombatCard, RangeCombatCard, SiegeCombatCard}

class MoraleBoost extends Effect {
  var effectCard: AbstractUnitCard = null
  def assignCard(card: AbstractUnitCard): Unit = {
    effectCard = card
  }
  override def visitCloseCombatCard(card: CloseCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength() 
    }
  }

  override def visitRangeCombatCard(card: RangeCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength()
    }
  }

  override def visitSiegeCombatCard(card: SiegeCombatCard): Unit = {
    if (!card.eq(effectCard)) {
      card.increaseStrength()
    }
  }
}
