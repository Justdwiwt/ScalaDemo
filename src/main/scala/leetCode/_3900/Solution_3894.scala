package leetCode._3900

object Solution_3894 {
  def trafficSignal(timer: Int): String = Option(timer)
    .collect {
      case 0 => "Green"
      case 30 => "Orange"
      case v if v > 30 && v <= 90 => "Red"
    }
    .getOrElse("Invalid")
}
