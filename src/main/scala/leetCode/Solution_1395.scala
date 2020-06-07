package leetCode

object Solution_1395 {
  def numTeams(rating: Array[Int]): Int = {
    var res = 0
    val dp1 = Array.fill(rating.length)(1)
    val dp2 = Array.fill(rating.length)(1)
    (1 until rating.length).foreach(i => {
      var a = 1
      var b = 1
      (0 until i).foreach(j => {
        if (rating(i) > rating(j)) {
          a += 1
          res += (dp1(j) - 1)
        } else {
          b += 1
          res += (dp2(j) - 1)
        }
      })
      dp1(i) = a
      dp2(i) = b
    })
    res
  }
}
