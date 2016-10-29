package net.thenobody.josephus

/**
  * Created by antonvanco on 29/10/2016.
  */
trait JosephusProblemSolver {

  /**
    * Method returns the position of the final survivor for
    * a given number of "participants" and the increment of elimination
    * @param count  the total number of participants
    * @param step   the increment of elimination
    * @return       the index of the 'last man standing'
    */
  def solve(count: Int, step: Int): Int

  /**
    * Validation of input values
    * Arguments need to be positive integers
    */
  object ValidValue {
    def unapply(value: Int): Option[Int] = value match {
      case v if v > 0 => Some(v)
      case _ => None
    }
  }
}

