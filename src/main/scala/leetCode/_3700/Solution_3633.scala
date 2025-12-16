package leetCode._3700

object Solution_3633 {
  def earliestFinishTime(landStartTime: Array[Int], landDuration: Array[Int], waterStartTime: Array[Int], waterDuration: Array[Int]): Int = {
    val lands = landStartTime.zip(landDuration).map(n => n._2 + n._1)
    val waters = waterStartTime.zip(waterDuration).map(n => n._1 + n._2)

    waterStartTime
      .map(_.max(lands.min))
      .zip(waterDuration)
      .map(n => n._2 + n._1)
      .min
      .min(landStartTime.map(_.max(waters.min)).zip(landDuration).map(n => n._1 + n._2).min)
  }
}
