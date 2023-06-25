package blakjack.view

import blakjack.domain.Card
import blakjack.domain.CardRank
import blakjack.domain.CardSuit
import blakjack.domain.Player

object OutputView {
    fun printInitialPlayerCards(players: List<Player>) {
        println()
        println("${players.joinToString { it.name }}에게 2장의 나누었습니다.")
        players.forEach(this::printPlayerCards)
    }

    fun printPlayerCards(player: Player) {
        println(getPrintPlayerCards(player))
    }

    fun printPlayerCardsWithScore(players: List<Player>) {
        players.forEach {
            println("${getPrintPlayerCards(it)} - 결과: ${it.score}")
        }
    }

    private fun getPrintPlayerCards(player: Player): String {
        return "${player.name}카드: ${player.cards.values.joinToString(",") { it.korean() }}"
    }

    private fun Card.korean(): String {
        return "${CARD_RANK_KOREAN_MAP[rank]}${CARD_SUIT_KOREAN_MAP[suit]}"
    }
}

private val CARD_RANK_KOREAN_MAP = mapOf(
    CardRank.ACE to "A",
    CardRank.TWO to "2",
    CardRank.THREE to "3",
    CardRank.FOUR to "4",
    CardRank.FIVE to "5",
    CardRank.SIX to "6",
    CardRank.SEVEN to "7",
    CardRank.EIGHT to "8",
    CardRank.NINE to "9",
    CardRank.TEN to "10",
    CardRank.JACK to "J",
    CardRank.QUEEN to "Q",
    CardRank.KING to "K",
)

private val CARD_SUIT_KOREAN_MAP = mapOf(
    CardSuit.HEART to "하트",
    CardSuit.DIAMOND to "다이아몬드",
    CardSuit.SPADE to "스페이드",
    CardSuit.CLOVER to "클로버",
)
