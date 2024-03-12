package leetCode._1200

object Solution_1111 {
  def maxDepthAfterSplit(seq: String): Array[Int] = {
    var res = Array.empty[Int]
    var t = 0
    seq.foreach(c => {
      if (c == '(') {
        t += 1
        res :+= (t % 2)
      } else {
        res :+= (t % 2)
        t -= 1
      }
    })
    res
  }
}
