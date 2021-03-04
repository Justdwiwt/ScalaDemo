package leetCode

object Solution_224 {

  case class Tracker(var result: Int, var currNum: Int, var sign: Int)

  def updateTracker(tracker: Tracker, sign: Int): Unit = {
    tracker.result += tracker.sign * tracker.currNum
    tracker.currNum = 0
    tracker.sign = sign
  }

  def calculate(s: String): Int = {
    val tracker = Tracker(0, 0, 1)
    val stack = collection.mutable.Stack[Int]()
    s.replace(" ", "").foreach(c =>
      if (c.isDigit) tracker.currNum = 10 * tracker.currNum + c.asDigit
      else if (c == '+') updateTracker(tracker, 1)
      else if (c == '-') updateTracker(tracker, -1)
      else if (c == '(') {
        stack.push(tracker.result)
        stack.push(tracker.sign)
        tracker.sign = 1
        tracker.result = 0
      }
      else if (c == ')') {
        tracker.result += tracker.sign * tracker.currNum
        tracker.currNum = 0
        tracker.result *= stack.pop
        tracker.result += stack.pop
      })
    if (tracker.currNum != 0) updateTracker(tracker, tracker.sign)
    tracker.result
  }

}
