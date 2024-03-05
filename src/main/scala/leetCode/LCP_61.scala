package leetCode

object LCP_61 {
  def temperatureTrend(temperatureA: Array[Int], temperatureB: Array[Int]): Int = {
    var res = 0
    var cnt = 0
    temperatureA.indices.drop(1).reverse.foreach(i => (temperatureA(i) - temperatureA(i - 1), temperatureB(i) - temperatureB(i - 1)) match {
      case (a, b) if a * b <= 0 && (a != 0 || b != 0) =>
        res = res.max(cnt)
        cnt = 0
      case _ => cnt += 1
    })
    res.max(cnt)
  }
}
