package com.ming.demo.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <P>被@Mapper修饰的接口，在编译期间MapStruct会自动为该接口生产实现类</P>
 * <P>根据JSP 269 注解处理自动生产实现类文件，可在target编译包中查看到</P>
 * <P>从编译后的代码可以看到，mapstruct之所以效率高是因为使用原生get/set，而不是使用反射</P>
 * <P>mapstruct与BeanUtils一样，针对基本类型是深拷贝，针对引用类型是浅拷贝</P>
 * @author Ming
 * @date 23/12/2021-上午 11:13
 */
@Mapper
public interface CarMapper {

    /**
     * <P>ClassLoader加载方式</P>
     * Returns an instance of the given mapper type.
     */
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    /**
     * <P>@Mapping内指定不同名字，这两个值可以拷贝，前提类型一致</P>
     * <P>两个对象内字段值一样的，不需要特别申明也会自动拷贝</P>
     */
    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(source = "make", target = "mark",defaultValue = "yoyo")
    CarDto carToCarDto(Car car);

}
