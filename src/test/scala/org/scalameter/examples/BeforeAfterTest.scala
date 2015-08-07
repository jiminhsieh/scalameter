package org.scalameter
package examples



import reporting._
import Key._



class BeforeAfterTest extends Bench.OfflineRegressionReport {

  val sizes = Gen.range("size")(1000000, 5000000, 2000000)

  performance of "Range" in {
    measure method "toArray" in {

      using(sizes) config (
        exec.benchRuns -> 30,
        exec.independentSamples -> 3
      ) beforeTests {
        println("ABOUT TO START RANGE TESTS!")
      } afterTests {
        println("ALL RANGE TESTS COMPLETED!")
      } in { sz =>
        (0 until sz).toArray
      }

    }
  }

}















