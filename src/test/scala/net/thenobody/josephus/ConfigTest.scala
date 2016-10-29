package net.thenobody.josephus

import net.thenobody.josephus.solver.{IterativeMode, RecursiveMode}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by antonvanco on 29/10/2016.
  */
class ConfigTest extends FlatSpec with Matchers {

  val count = 10
  val step = 4
  val recursiveMode = RecursiveMode.ModeName
  val iterativeMode = IterativeMode.ModeName

  it should "parse all parameters" in {
    val expResult = new Config(
      count = count,
      step = step,
      mode = IterativeMode
    )

    val options = Map(
      "--mode" -> iterativeMode
    ).toFlatArray

    val args = Seq(count, step)

    val result = Config(options ++ seqToArray(args))

    result shouldEqual expResult
  }

  it should "fail on missing required parameters" in {
    val requiredArgs = Seq(count, step)

    requiredArgs.foreach { case (arg) =>
      an [IllegalArgumentException] should be thrownBy Config(requiredArgs.filterNot(_ == arg))
    }
  }

  it should "set correct default values for optional parameters" in {
      val requiredArgs = Seq(count, step)

      val expResult = new Config(
        count = count,
        step = step,
        mode = RecursiveMode
      )

      val result = Config(requiredArgs)

      result shouldEqual expResult
  }

  implicit class RichMap(self: Map[String, Any]) {
    def toFlatArray: Array[String] = self.flatMap(_.productIterator.map(_.toString)).toArray
  }

  implicit def seqToArray(seq: Seq[Any]): Array[String] = seq.map(_.toString).toArray
}