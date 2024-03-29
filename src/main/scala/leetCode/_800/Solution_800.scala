package leetCode._800

import scala.collection.mutable

object Solution_800 {
  def similarRGB(color: String): String = {
    val sb = new mutable.StringBuilder()
    sb.append("#")
    (1 until color.length by 2).foreach(i => {
      val sub = color.substring(i, i + 2)
      var ori = Integer.parseInt(sub, 16)
      if (ori % 17 < 9) ori = ori / 17
      else ori = ori / 17 + 1
      sb.append((ori * 17).formatted("%02x"))
    })
    sb.mkString
  }
}
