package leetCode._400

import scala.collection.mutable

object Solution_359 {

  class Logger() {

    var m = mutable.HashMap.empty[String, Int]

    def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
      if (m.contains(message) && (timestamp - m(message) < 10)) return false
      m += message -> timestamp

      true
    }

  }

}
