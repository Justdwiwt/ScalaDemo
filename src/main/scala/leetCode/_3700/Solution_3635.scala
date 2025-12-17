package leetCode._3700

object Solution_3635 {
  def earliestFinishTime(landStartTime: Array[Int], landDuration: Array[Int], waterStartTime: Array[Int], waterDuration: Array[Int]): Int = {
    val value1 = calcRide1(landStartTime, landDuration)
    val value2 = calcRide2(waterStartTime, waterDuration, value1)
    val value3 = calcRide1(waterStartTime, waterDuration)
    val value4 = calcRide2(landStartTime, landDuration, value3)
    value2.min(value4)
  }

  def calcRide1(startTime: Array[Int], duration: Array[Int]): Int = {
    startTime.zip(duration).map(v => v._1 + v._2).min
  }

  def calcRide2(startTime: Array[Int], duration: Array[Int], value1: Int): Int = {
    startTime.zip(duration).map {
      case (v1, v2) => if (v1 < value1) value1 + v2 else v1 + v2
    }.min
  }
}
