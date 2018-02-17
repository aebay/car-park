package org.aeb.uk.carpark

import org.scalatest.FlatSpec

class CarParkJobTest extends FlatSpec {

  behavior of "Car park job executor"

  it should "return the smallest car registration in the car park at the end of a list of instructions" in {

    val input = List( "PARK,1001", "PARK,1002", "DEPART", "DEPART", "PARK,1003", "PARK,1004", "SMALLEST" )

    val expectedResults = "1003"

    val actualResults = CarParkJob.run( input, 10 )

    assert( actualResults === expectedResults )

  }

}
