package ee.valiit.back_vali_kuusk.domain.product;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TypeMapper {

    @Mapping(source = "id", target = "typeId")
    @Mapping(source = "name", target = "typeName")
    TypeDto typeToTypeDto(Type type);

    List<TypeDto> typesToTypeDtos(List<Type> types);

}
