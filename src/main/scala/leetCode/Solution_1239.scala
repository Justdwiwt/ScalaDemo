package leetCode

object Solution_1239 {
  def maxLength(arr: List[String]): Int = {

    def f(_arr: List[String], _i: Int, _m: Int): Int = {
      if (_i == _arr.length) return 0
      val t = _m
      var m = _m
      _arr(_i).foreach(c => {
        if ((m & (1 << (c - 'a'))) > 0) return f(_arr, _i + 1, t)
        m |= (1 << (c - 'a'))
      })
      (_arr(_i).length + f(_arr, _i + 1, m)).max(f(_arr, _i + 1, t))
    }

    f(arr, 0, 0)
  }
}
