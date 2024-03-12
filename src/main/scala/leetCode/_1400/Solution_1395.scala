package leetCode._1400

object Solution_1395 {
  def numTeams(rating: Array[Int]): Int = {
    var cnt = 0
    if (rating.length != 0)
      (0 to (rating.length - 3))
        .foreach(i => ((i + 1) to (rating.length - 2))
          .foreach(j => (j + 1).until(rating.length)
            .foreach(k => if ((rating(i) < rating(j) && rating(j) < rating(k)) || (rating(i) > rating(j) && rating(j) > rating(k)))
              cnt += 1
            )))
    cnt
  }
}
