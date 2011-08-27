package net.m14m.ardecha

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class SampleSpec extends FlatSpec with ShouldMatchers {
    "one plus two" should "equal three" in {
        val a = 1 + 2
        a should equal(3)
    }

    "checking one plus two equals four" should "fail the test" in {
        val a = 1 + 2
        a should equal(4)
    }
}
