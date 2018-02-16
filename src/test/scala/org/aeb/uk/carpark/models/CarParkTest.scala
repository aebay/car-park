package org.aeb.uk.carpark.models

import org.scalatest.FlatSpec
import scala.collection.mutable

class CarParkTest extends FlatSpec {

  behavior of "car park"

  it should "park a new car in an empty car park with capacity > 0" in {

    val carPark = new CarPark( 10 )
    carPark.park( "1001" )

    assert( carPark.occupancy.contains( "1001" ) )

  }

  it should "not park a new car in an empty car park with capacity = 0" in {

    val carPark = new CarPark()
    carPark.park( "1001" )

    assert( carPark.occupancy.isEmpty )

  }

  it should "not park a car with an invalid registration" in {

    val carPark = new CarPark( 10 )
    carPark.park( "ABCD" )
    carPark.park( "12345" )
    carPark.park( "123" )

    assert( carPark.occupancy.isEmpty )

  }

  it should "park a new car in the first empty slot in an occupied car park" in {

    val carPark = new CarPark( 10 )
    assert( carPark.occupancy.isEmpty )

    carPark.park( "0001" )
    assert( carPark.occupancy.result === mutable.ArrayStack( "0001" ) )

    carPark.park( "0002" )
    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002" ) )

    carPark.park( "0003" )
    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003" ) )

  }

  it should "not park a new car in a full car park" in {

    val carPark = new CarPark( 3 )
    carPark.park( "0001" )
    carPark.park( "0002" )
    carPark.park( "0003" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003" ) )

    carPark.park( "0004" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003" ) )

  }

  it should "remove the most recently parked car" in {

    val carPark = new CarPark( 10 )
    carPark.park( "0001" )
    carPark.park( "0002" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002" ) )

    carPark.depart()

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001" ) )

  }

  it should "be empty after the last car departs" in {

    val carPark = new CarPark( 10 )
    carPark.park( "0001" )
    carPark.park( "0002" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002" ) )

    carPark.depart()
    carPark.depart()

    assert( carPark.occupancy.isEmpty )

  }

  it should "remove the most recently parked cars if the capacity is reduced below the number of cars present" in {

    val carPark = new CarPark( 10 )
    carPark.park( "0001" )
    carPark.park( "0002" )
    carPark.park( "0003" )
    carPark.park( "0004" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003", "0004" ) )

    carPark.resize( 2 )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002" ) )

  }

  it should "contain the same cars in the order they were parked if the capacity is increased" in {

    val carPark = new CarPark( 10 )
    carPark.park( "0001" )
    carPark.park( "0002" )
    carPark.park( "0003" )
    carPark.park( "0004" )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003", "0004" ) )

    carPark.resize( 20 )

    assert( carPark.occupancy.result === mutable.ArrayStack( "0001", "0002", "0003", "0004" ) )

  }

  it should "return the car with the smallest registration number" in {

    val carPark = new CarPark( 10 )
    carPark.park( "9999" )
    carPark.park( "0001" )
    carPark.park( "0000" )
    carPark.park( "5004" )

    assert( carPark.smallest === "0000" )

  }

}