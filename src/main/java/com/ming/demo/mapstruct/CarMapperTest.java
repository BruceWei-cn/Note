package com.ming.demo.mapstruct;

/**
 * @author Ming
 * @date 23/12/2021-上午 11:26
 */
public class CarMapperTest {

    public static void main(String[] args) {

        // given
        Car car = new Car(null, 5, CarType.SEDAN);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        // then
        System.out.println(carDto.getSeatCount());
        System.out.println(carDto.getType());
        System.out.println(carDto.getMark());

        // 两个对象地址不同
        System.out.println(car);
        System.out.println(carDto);

        System.out.println(car.getType() == carDto.getType());
    }
}
