package leetCode

object Solution_1441 {
  def buildArray(target: Array[Int], n: Int): List[String] = {
    var cnt = 1
    var res = List.empty[String]
    target.indices.foreach(i => {
      while (cnt < target(i)) {
        res :+= "Push"
        res :+= "Pop"
        cnt += 1
      }
      if (cnt == target(i)) {
        res :+= "Push"
        cnt += 1
      }
    })
    res
  }
}
