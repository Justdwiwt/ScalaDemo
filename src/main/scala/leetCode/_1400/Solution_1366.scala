package leetCode._1400

import scala.collection.mutable
import scala.math.Ordering.Implicits._

object Solution_1366 {
  def rankTeams(votes: Array[String]): String = {
    val numTeams = votes.head.length
    val teamsVotes = votes.flatMap(_.zipWithIndex)
    val agree = teamsVotes./:(Map.empty[Char, mutable.ArraySeq[Int]])((acc, vote) => {
      val (team, rank) = vote
      val votesPerRank = acc.getOrElse(team, mutable.ArraySeq.fill(numTeams)(0))
      votesPerRank(rank) += 1
      acc.updated(team, votesPerRank)
    })

    val sorted = Ordering.Tuple2(implicitly(Ordering[mutable.ArraySeq[Int]]).reverse, Ordering.Char)
    agree.toList.map(_.swap).sorted(sorted).map(_._2).mkString
  }
}
