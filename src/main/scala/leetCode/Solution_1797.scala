package leetCode

import scala.collection.mutable

object Solution_1797 {
  class AuthenticationManager(_timeToLive: Int) {

    private val tokens = mutable.Map.empty[String, Int]

    def generate(tokenId: String, currentTime: Int): Unit =
      tokens += tokenId -> (currentTime + _timeToLive)

    def renew(tokenId: String, currentTime: Int): Unit = tokens.get(tokenId) match {
      case Some(expiryTime) if expiryTime > currentTime => tokens(tokenId) = currentTime + _timeToLive
      case _ => ()
    }

    def countUnexpiredTokens(currentTime: Int): Int =
      tokens.count { case (_, timeToLive) => timeToLive > currentTime }
  }
}
