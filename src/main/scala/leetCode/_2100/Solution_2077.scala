package leetCode._2100

object Solution_2077 {
  def numberOfPaths(n: Int, corridors: Array[Array[Int]]): Int = {
    val arr = Array.fill(n, n)(false)
    corridors.foreach(corridor => {
      arr(corridor.head - 1)(corridor(1) - 1) = true
      arr(corridor(1) - 1)(corridor.head - 1) = true
    })
    corridors.foldLeft(0)((acc, corridor) => acc + (0 until corridor.head.min(corridor(1)) - 1).foldLeft(0)((innerAcc, i) =>
      if (arr(corridor.head - 1)(i) && arr(corridor(1) - 1)(i)) innerAcc + 1 else innerAcc
    ))
  }
}
