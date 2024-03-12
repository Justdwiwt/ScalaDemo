package leetCode._1600

object Solution_1507 {
  def reformatDate(date: String): String = {
    val diff = Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    val str = date.split(" ")
    var res = str(2) + "-"
    diff.indices.foreach(i => {
      if (str(1).equals(diff(i)))
        if (i < 9) res += "0" + (i + 1)
        else res += (i + 1)
    })
    val day = str(0).substring(0, str(0).length - 2)
    res + "-" + (if (day.length > 1) day else "0" + day)
  }
}
