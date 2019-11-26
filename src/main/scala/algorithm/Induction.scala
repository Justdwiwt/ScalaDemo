package algorithm

/**
  * 数学归纳法
  */
object Induction {

  private class Result {
    /**
      * 当前格的麦粒数
      */
    var wheatNum: Long = 0L
    /**
      * 目前为止麦粒的总数
      */
    var wheatTotalNum: Long = 0L
  }

  /**
    * 使用函数的递归（嵌套）调用，进行数学归纳法证明
    *
    * @param k      放到第几格
    * @param result 保存当前格子的麦粒数和麦粒总数
    * @return 放到第k格时是否成立
    */
  def prove(k: Int, result: Result): Boolean = k match {
    //  证明n = 1时，命题是否成立
    case 1 => if ((math.pow(2, 1).toInt - 1) == 1) {
      result.wheatNum = 1
      result.wheatTotalNum = 1
      true
    } else false
    //  如果n = (k-1)时命题成立，证明n = k时命题是否成立
    case _ => val proveOfPreviousOne = prove(k - 1, result)
      result.wheatNum *= 2
      result.wheatTotalNum += result.wheatNum
      var proveOfCurrentOne = false
      if (result.wheatTotalNum == (math.pow(2, k).toInt - 1)) proveOfCurrentOne = true
      if (proveOfCurrentOne && proveOfPreviousOne) true else false
  }

}
