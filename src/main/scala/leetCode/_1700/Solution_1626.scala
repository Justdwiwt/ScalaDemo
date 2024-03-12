package leetCode._1700

object Solution_1626 {
  def bestTeamScore(scores: Array[Int], ages: Array[Int]): Int = {

    class Data(_age: Int, _score: Int, _total: Int) {
      val age: Int = _age
      val score: Int = _score
      var total: Int = _total
    }

    val arr = scores.indices
      .map(i => new Data(ages(i), scores(i), scores(i)))
      .toArray
      .sortWith((a, b) => if (a.age != b.age) a.age <= b.age else a.score <= b.score)

    arr.indices.map(i => {
      if (i >= 1) (0 until i).foreach(j => {
        if (arr(i).score >= arr(j).score || arr(i).age == arr(j).age)
          if (arr(i).total <= arr(j).total + arr(i).score)
            arr(i).total = arr(j).total + arr(i).score
      })
      arr(i).total
    }).max
  }
}
